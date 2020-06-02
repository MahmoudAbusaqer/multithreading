/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Chapter6.Question1.controllers;

import com.Chapter6.Question1.models.Registration;
import com.Chapter6.Question1.models.Student;
import com.Chapter6.Question1.repositories.CourseRepository;
import com.Chapter6.Question1.repositories.RegistrationRepository;
import com.Chapter6.Question1.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
public class MainController {
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    RegistrationRepository registrationRepository;
    
//    @RequestMapping("/")
//    public String Index(){
//        return String.format("%s", "Chapter 6");
//    }
    
    @RequestMapping("/")
    public String showAll(){
        List<Registration> registrations = registrationRepository.findAll();
        String str = "";
        for (Registration student : registrations) {
            str += student + "<br>";
        }
        return String.format("%s", str);
    }
}
