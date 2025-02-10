package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entites.Student;


public class StudentDaoimpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    // Constructor for Dependency Injection
    public StudentDaoimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // Insert Query
        String query = "INSERT INTO student (id, name, city) VALUES (?, ?, ?)";
        return this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
    }

    @Override
    public int update(Student student) {
        // Update Query
        String query = "UPDATE student SET name = ?, city = ? WHERE id = ?";
        return this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public int delete(int id) {
        // Delete Query
        String query = "DELETE FROM student WHERE id = ?";
        return this.jdbcTemplate.update(query, id);
    }

    // Getter for JdbcTemplate (if needed)
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public Student select(int id) {
        // Select Query
        String query = "SELECT * FROM student WHERE id = ?";
        RowMapperImpl rowMapper = new RowMapperImpl();
        return this.jdbcTemplate.queryForObject(query,rowMapper,id);
        // return (Student) this.jdbcTemplate.queryForObject(query, new RowMapper(){
        //     public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        //         Student student = new Student();
        //         student.setId(rs.getInt("id"));
        //         student.setName(rs.getString("name"));
        //         student.setCity(rs.getString("city"));
        //         return student;
        //         }

        // },id);
    }

    @Override
    public List<Student> selectAll() {
      //selete multile student
      String query = "SELECT * FROM student";
      RowMapperImpl rowMapper = new RowMapperImpl();
      return this.jdbcTemplate.query(query, rowMapper);
    }
}
