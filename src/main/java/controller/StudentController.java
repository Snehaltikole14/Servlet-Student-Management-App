package controller;

import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentService();
    public void addStudent(Student student){
        studentService.addStudent(student);
    }
    public void deleteStudentById(int id) {
        studentService.deleteStudentById(id);
    }
    public void editStudent(Student student) {
        studentService.editStudent(student);
    }
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
}
