/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.enumeration.converter;

import com.manu.securedoc.enumeration.AuthorityEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<AuthorityEnum,String> {

    @Override
    public String convertToDatabaseColumn(AuthorityEnum authorityEnum) {
        if (authorityEnum==null){
            return null;
        }
        return authorityEnum.getValue();
    }

    @Override
    public AuthorityEnum convertToEntityAttribute(String code) {
        if (code==null) {
            return null;
        }
        return Stream.of(AuthorityEnum.values())
                .filter(authorityEnum -> authorityEnum.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
