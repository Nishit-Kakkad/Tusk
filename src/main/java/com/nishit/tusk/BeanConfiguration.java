/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk;

import com.nishit.tusk.dao.FeedbackDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nishit-TCS
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public FeedbackDAO getFeedbackDAO() {
        return new FeedbackDAO();
    }
}
