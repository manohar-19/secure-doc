/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc;

import com.manu.securedoc.domain.RequestContext;
import com.manu.securedoc.entity.RoleEntity;
import com.manu.securedoc.enumeration.AuthorityEnum;
import com.manu.securedoc.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(RoleRepository roleRepository){
//		return  args-> {
//			RequestContext.setUserId(0L);
//			var userRole = new RoleEntity();
//			userRole.setName(AuthorityEnum.USER.name());
//			userRole.setAuthorities(AuthorityEnum.USER);
//			roleRepository.save(userRole);
//
//			var adminRole = new RoleEntity();
//			adminRole.setName(AuthorityEnum.ADMIN.name());
//			adminRole.setAuthorities(AuthorityEnum.ADMIN);
//			roleRepository.save(adminRole);
//			RequestContext.start();
//		};
//	}

}
