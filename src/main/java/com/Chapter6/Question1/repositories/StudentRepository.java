/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Chapter6.Question1.repositories;

import com.Chapter6.Question1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
