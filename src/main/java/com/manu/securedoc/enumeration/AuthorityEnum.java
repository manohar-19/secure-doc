/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.enumeration;

import static com.manu.securedoc.constants.Constants.ADMIN_AUTHORITIES;
import static com.manu.securedoc.constants.Constants.MANAGER_AUTHORITIES;
import static com.manu.securedoc.constants.Constants.SUPER_ADMIN_AUTHORITIES;
import static com.manu.securedoc.constants.Constants.USER_AUTHORITIES;

public enum AuthorityEnum {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;

    AuthorityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
