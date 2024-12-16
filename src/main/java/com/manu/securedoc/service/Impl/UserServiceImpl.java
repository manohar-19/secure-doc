/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.service.Impl;

import com.manu.securedoc.entity.ConfirmationEntity;
import com.manu.securedoc.entity.CredentialsEntity;
import com.manu.securedoc.entity.RoleEntity;
import com.manu.securedoc.entity.UserEntity;
import com.manu.securedoc.enumeration.EventType;
import com.manu.securedoc.event.UserEvent;
import com.manu.securedoc.exception.ApiException;
import com.manu.securedoc.repository.ConfirmationRepository;
import com.manu.securedoc.repository.CredentialRepository;
import com.manu.securedoc.repository.RoleRepository;
import com.manu.securedoc.repository.UserRepository;
import com.manu.securedoc.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.manu.securedoc.enumeration.AuthorityEnum.USER;
import static com.manu.securedoc.utils.UserUtils.createUserEntity;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;

    private final ApplicationEventPublisher publisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        var userEntity = userRepository.save(createNewUser(firstName, lastName, email));
        var credentialEntity = new CredentialsEntity(password,userEntity);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key", confirmationEntity.getKey())));
    }

    @Override
    public RoleEntity getRoleName(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return role.orElseThrow(()-> new ApiException("Role not found"));
    }

    @Override
    public void verifyAccountKey(String key) {
        ConfirmationEntity confirmationEntity = getUserConfirmation(key);
        UserEntity userEntity = getUserEntityByEmail(confirmationEntity.getUserEntity().getEmail());
        userEntity.setEnabled(true);
        userRepository.save(userEntity);
        confirmationRepository.delete(confirmationEntity);
    }

    private UserEntity getUserEntityByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(()-> new ApiException("User not found"));
    }

    private ConfirmationEntity getUserConfirmation(String key) {
        return  confirmationRepository.findByKey(key)
                .orElseThrow(()-> new ApiException("Confirmation key not found"));
    }


    private UserEntity createNewUser(String firstName, String lastName, String email) {
        var role = getRoleName(USER.name());
        return createUserEntity(firstName, lastName, email, role);
    }
}
