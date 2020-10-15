package com.cts.bms.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class BMSBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence
            (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
             {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    @Override
    public void afterPropertiesSet()  {
        setRealmName("bms"); 
        super.afterPropertiesSet();
    }
}