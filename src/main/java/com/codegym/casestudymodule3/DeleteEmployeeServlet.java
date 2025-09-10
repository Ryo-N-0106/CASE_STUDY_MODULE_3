package com.codegym.casestudymodule3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        EmployeeService service = new EmployeeService();
        int result = service.deleteByID(Integer.parseInt(id));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Delete Employee</title></head><body>");
        if (result > 0) {
            out.println("<h1>Đã xóa nhân viên có id = " + id + " thành công!</h1>");
        } else {
            out.println("<h1>Thao tác xóa thất bại!</h1>");
        }
        out.println("</body></html>");
    }

}
