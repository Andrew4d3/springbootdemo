package com.andrew.demo.resource;

import com.andrew.demo.model.Student;
import com.andrew.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/vi/students")
public class StudentResource {
    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudent(@PathVariable("studentId") UUID studentId){
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student) {
        studentService.persistNewStudent(student);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudent(@RequestBody Map<String, Object> payload, @PathVariable("studentId") UUID studentId) {
        Student updatedStudent = new Student(studentId, payload);
        studentService.updateStudentById(studentId, updatedStudent);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}"
    )
    public void deleteStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }
}
