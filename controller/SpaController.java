package com.olp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SpaController {

    /**
     * Forward all non-API routes to Angular's index.html
     * This allows Angular routing to work properly when the app is served from Spring Boot
     * Excludes API routes (/olp/**) and static resources
     */
    @RequestMapping(value = {
        "/",
        "/home",
        "/courses",
        "/about",
        "/contact",
        "/login",
        "/register",
        "/dashboard"
    })
    public String forward(HttpServletRequest request) {
        // Forward to index.html for Angular to handle routing
        return "forward:/index.html";
    }
}
