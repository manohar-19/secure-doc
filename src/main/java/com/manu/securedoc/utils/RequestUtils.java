/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.utils;

import com.manu.securedoc.domain.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static java.time.LocalTime.now;
import static org.apache.logging.log4j.util.Strings.EMPTY;

public class RequestUtils {

    public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status){
        return new Response(now().toString(), status.value(), request.getRequestURI(), status, message, EMPTY, data);
    }
}
