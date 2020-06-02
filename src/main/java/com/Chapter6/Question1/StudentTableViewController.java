/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Chapter6.Question1;

import com.Chapter6.Question1.models.Course;
import com.Chapter6.Question1.models.Registration;
import com.Chapter6.Question1.models.Student;
import com.Chapter6.Question1.repositories.CourseRepository;
import com.Chapter6.Question1.repositories.RegistrationRepository;
import com.Chapter6.Question1.repositories.StudentRepository;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author Mahmoud_Abusaqer
 */
@Component
public class StudentTableViewController implements Initializable {

    @FXML
    private FlowPane rootPane;
    @FXML
    private TextField textFiledStudentId;
    @FXML
    private TextField textFiledName;
    @FXML
    private TextField textFiledMajor;
    @FXML
    private TextField textFiledGrade;
    @FXML
    private TextField textFiledCourseId;
    @FXML
    private TextField textFiledSemester;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, Integer> tcStudentId;
    @FXML
    private TableColumn<Student, String> tcStudentName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private TableView<Registration> registrationTableView;
    @FXML
    private TableColumn<Registration, Integer> tcStudentIdR;
    @FXML
    private TableColumn<Registration, Integer> tcCourseId;
    @FXML
    private TableColumn<Registration, String> tcSemester;
    @FXML
    private Button addStudentButton;
    @FXML
    private Button editStudentButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addRegistration;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    RegistrationRepository registrationRepository;
    Student student;
    Course course;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcStudentId.setCellValueFactory(new PropertyValueFactory("id"));
        tcStudentName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tcStudentIdR.setCellValueFactory(new PropertyValueFactory("studentId"));
        tcCourseId.setCellValueFactory(new PropertyValueFactory("courseId"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));
        studentTableView.getSelectionModel().selectedItemProperty().addListener(listener -> selectStudent());
        if (rootPane.isVisible()) {
            showStudents();
            showRegistration();
        }
    }

    @FXML
    private void textFiledStudentIdHandle(ActionEvent event) {
        student = studentRepository.findById(Integer.parseInt(textFiledStudentId.getText())).get();
    }

    @FXML
    private void textFiledCourseIdHandle(ActionEvent event) {
        course = courseRepository.findById(Integer.parseInt(textFiledCourseId.getText())).get();
    }

    @FXML
    private void addButtonHandle(ActionEvent event) {
        Student addStudent = new Student();
        addStudent.setId(Integer.parseInt(textFiledStudentId.getText()));
        addStudent.setName(textFiledName.getText());
        addStudent.setMajor(textFiledMajor.getText());
        addStudent.setGrade(Double.parseDouble(textFiledGrade.getText()));
        studentRepository.save(addStudent);
        showStudents();
        clearFields();
    }

    @FXML
    private void editButtonHandle(ActionEvent event) {
        Student editStudent = studentRepository.findById(Integer.parseInt(textFiledStudentId.getText())).get();
        editStudent.setName(textFiledName.getText());
        editStudent.setMajor(textFiledMajor.getText());
        editStudent.setGrade(Double.parseDouble(textFiledGrade.getText()));
        studentRepository.save(editStudent);
        showStudents();
        clearFields();
    }

    @FXML
    private void deleteButtonHandle(ActionEvent event) {
        Student deleteStudent = studentRepository.findById(Integer.parseInt(textFiledStudentId.getText())).get();
        studentRepository.delete(deleteStudent);
        showStudents();
        clearFields();
    }

    @FXML
    private void addRegistrationHandle(ActionEvent event) {
        Registration registration = new Registration();
        registration.setStudentId(student);
        registration.setCourseId(course);
        registration.setSemester(textFiledSemester.getText());
        registrationRepository.save(registration);
        showStudents();
        clearFields();
        showRegistration();
        clearFields();
    }

    private void showStudents() {
        List<Student> students = studentRepository.findAll();
        studentTableView.getItems().setAll(students);
    }

    private void showRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        registrationTableView.getItems().setAll(registrations);
    }

    private void selectStudent() {
        Student student = (Student) studentTableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            textFiledStudentId.setText(String.valueOf(student.getId()));
            textFiledName.setText(student.getName());
            textFiledMajor.setText(student.getMajor());
            textFiledGrade.setText(String.valueOf(student.getGrade()));
        }
    }

    private void clearFields() {
        textFiledStudentId.setText("");
        textFiledName.setText("");
        textFiledMajor.setText("");
        textFiledGrade.setText("");
        textFiledCourseId.setText("");
        textFiledSemester.setText("");
    }
}
