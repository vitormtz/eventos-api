/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author vitor
 */
@Component
public class HeaderValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String nomeHeader = request.getHeader("nome");
        String senhaHeader = request.getHeader("senha");

        if (nomeHeader == null || senhaHeader == null
                || nomeHeader.isEmpty() || senhaHeader.isEmpty()
                || !nomeHeader.equals("Juca Bala") || !senhaHeader.equals("senhaforte")) {
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        return true;
    }
}
