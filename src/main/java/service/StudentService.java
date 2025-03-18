package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
    }

    public Student editStudent(Student student) {
        studentDao.editStudent(student);
        return student;
    }
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}


