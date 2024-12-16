/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.utils;

import com.manu.securedoc.entity.RoleEntity;
import com.manu.securedoc.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.EMPTY;


public class UserUtils {
    public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role){
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .lastLogin(LocalDateTime.now())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .mfa(false)
                .enabled(false)
                .loginAttempts(0)
                .qrCodeSecret(EMPTY)
                .phone(EMPTY)
                .bio(EMPTY)
                .imageUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png")
                .role(role)
                .build();
    }
}
