package dao;

import model.Student;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("dob").toLocalDate()
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<String> searchStudent(String key) {
        List<String> studentList = new ArrayList<>();
        String sql = "SELECT name FROM students WHERE name LIKE ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + key + "%"); // Partial search
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                studentList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }

}
