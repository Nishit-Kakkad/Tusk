/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Nishit-TCS
 */
@Configuration
@ComponentScan(basePackages = "com.nishit.tusk.Controller")
public class SpringConfig implements WebMvcConfigurer{
    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver resolve = new InternalResourceViewResolver();
        resolve.setViewClass(JstlView.class);
        resolve.setPrefix("");
        resolve.setSuffix(".jsp");
        return resolve;
    }
}
