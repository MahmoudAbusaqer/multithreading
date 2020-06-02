/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Chapter6.Question1.repositories;

import com.Chapter6.Question1.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
