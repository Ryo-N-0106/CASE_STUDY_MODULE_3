package com.codegym.casestudymodule3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    DBConnection dbConnection = new DBConnection();

    public void addEmployee(Employee employee) {
        String SQL = "INSERT INTO employees (full_name, email, phone, address) VALUES (?,?,?,?)";

        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ) {
            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getAddress());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployee(Employee employee) {
        String SQL = "UPDATE employees SET full_name = ?, email = ?, phone = ?, address = ?" + " WHERE id = ?";

        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getAddress());
            statement.setInt(5, employee.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll(String q) {
        List<Employee> employees = new ArrayList<>();
        String SQL = "SELECT * FROM employees";

        if(q != null && !q.isEmpty()) {
            SQL = SQL + " WHERE full_name LIKE '%" + q + "%' OR email LIKE '%" + q + "%'"  ;
        }

        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            ResultSet rs = statement.executeQuery();//Tập kết quả
            while(rs.next()) {
                int id  = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                Employee employee = new Employee(id, fullName, email, phone,address);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public Employee getById(int id) {
        String SQL = "SELECT * FROM employees WHERE id = ?";

        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int currentId  = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                Employee employee = new Employee(currentId, fullName, email, phone,address);
                return employee;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int deleteByID(int id) {
        String SQL = "DELETE FROM employees WHERE id = ?";

        try (
            Connection conn = dbConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);
                ) {
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
