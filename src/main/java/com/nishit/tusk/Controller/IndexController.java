/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk.Controller;

import com.nishit.tusk.dao.FeedbackDAO;
import com.nishit.tusk.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishit-TCS
 */
@Controller
public class IndexController {
    
    FeedbackDAO fdao = new FeedbackDAO();
    
    Feedback feedback;
    
    @RequestMapping(value = "/addFeedback", method = { RequestMethod.GET })
    public ModelAndView addFeedback(@RequestParam("name") String name, 
                @RequestParam("email") String email, 
                @RequestParam("regarding") int regarding, 
                @RequestParam("message") String message, 
                @RequestParam("code") String code, 
                @RequestParam("rating") int rating) {
        ModelAndView mv = new ModelAndView();
        feedback = new Feedback(name, email, regarding, message, code, rating);
        boolean result = fdao.addFeedback(feedback);
        mv.addObject("result", result);
        mv.setViewName("index");
        return mv;
    }
}
