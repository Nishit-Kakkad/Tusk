/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk.dao;

import com.nishit.tusk.entity.Feedback;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nishit-TCS
 */
@Component
public class FeedbackDAO {
    public boolean addFeedback(Feedback feedback) {
        boolean result = false;
        System.out.println(feedback);
        return result;
    }
}
