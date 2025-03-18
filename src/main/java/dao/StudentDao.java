package dao;

import model.Student;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
    public void addStudent(Student student) {
        String query = "INSERT INTO student.students(Name,Gender,DOB) VALUES (?,?,?)";

        try {
            Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

           preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setDate(3, java.sql.Date.valueOf(student.getDob()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Student added successfully");
    }
    public void deleteStudentById(int id) {
        String query = "delete from students where id=?";
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Student deleted successfully");
    }
    public void editStudent(Student student) {
        String query = "update students set name=?,Gender=?,DOB=? where id=?";
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setDate(3, java.sql.Date.valueOf(student.getDob()));
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Student updated successfully");
    }



}
