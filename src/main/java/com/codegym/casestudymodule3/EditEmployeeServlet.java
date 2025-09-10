package com.codegym.casestudymodule3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        EmployeeService service = new EmployeeService();
        Employee employee = service.getById(Integer.parseInt(id));

        req.setAttribute("employee", employee);

        req.getRequestDispatcher("form-employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Chỉnh sửa
        String id = req.getParameter("id");

        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Employee employee = new Employee(Integer.parseInt(id), fullName, email, phone, address);
        EmployeeService service = new EmployeeService();
        service.updateEmployee(employee);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật thông tin nhân viên thành công!");
    }
}
