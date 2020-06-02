/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3chapter7.multithreading;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class Java3Chapter7Multithreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            final int count = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        File file = new File("file1.txt");
                        File file2 = new File("file2.txt");
                        Scanner scanner = new Scanner(file);
                        Scanner scanner2 = new Scanner(file2);
                        while (scanner.hasNextLine()) {
                            System.out.println("Thread " + count + " Reading " + scanner.nextLine());
                        }
                        while (scanner2.hasNextLine()) {
                            System.out.println("Thread " + count + " Reading " + scanner2.nextLine());
                        }
                        scanner.close();
                        scanner2.close();
                    } catch (IOException ex) {
                        ex.getStackTrace();
                    }
                }
            });
        }
        es.shutdown();
        //The output for run of this program
//        Thread 1 Reading This is the first file it is for chapter 7 multithreading assignment
//        Thread 2 Reading This is the first file it is for chapter 7 multithreading assignment
//        Thread 2 Reading This is the second file it is for chapter 7 multithreading assignment
//        Thread 1 Reading This is the second file it is for chapter 7 multithreading assignment
    }
}
