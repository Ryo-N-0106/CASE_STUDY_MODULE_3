package com.codegym.casestudymodule3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAll(q);

        req.setAttribute("employees",employees);
        req.getRequestDispatcher("list-employee.jsp").forward(req,resp);

    }
}
