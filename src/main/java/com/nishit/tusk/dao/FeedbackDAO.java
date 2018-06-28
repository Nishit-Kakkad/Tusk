/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk.dao;

import com.nishit.tusk.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nishit-TCS
 */
@Component(value = "FeedbackDAO")
public class FeedbackDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public boolean addFeedback(Feedback feedback) {
        boolean result = false;
        System.out.println(feedback);
        Session session = sessionFactory.getCurrentSession();
        session.save(feedback);
        return result;
    }
}
