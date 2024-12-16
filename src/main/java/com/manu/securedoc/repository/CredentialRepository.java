/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.repository;

import com.manu.securedoc.entity.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialsEntity,Long> {

    Optional<CredentialsEntity> getCredentialByUserEntityId(Long userId);
}
