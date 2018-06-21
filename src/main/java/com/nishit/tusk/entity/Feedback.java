/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nishit-TCS
 */
public class Feedback {
    private String name;
    private String email;
    private int regarding;
    private String message;
    private String code;
    private int rating;

    public Feedback(String name, String email, int regarding, String message, String code, int rating) {
        this.name = name;
        this.email = email;
        this.regarding = regarding;
        this.message = message;
        this.code = code;
        this.rating = rating;
    }

    public Feedback() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRegarding() {
        return regarding;
    }

    public void setRegarding(int regarding) {
        this.regarding = regarding;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" + "name=" + name + ", email=" + email + ", regarding=" + regarding + ", message=" + message + ", code=" + code + ", rating=" + rating + '}';
    }
}
