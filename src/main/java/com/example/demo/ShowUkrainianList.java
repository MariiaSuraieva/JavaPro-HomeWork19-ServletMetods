package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ukrainiansEmployee")
public class ShowUkrainianList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Employee> listUkrainians = EmployeeRepository.getUkrainiansList (EmployeeRepository.getAllEmployees());

        for (Employee employee : listUkrainians) {
            out.print(employee);
        }
        out.close();
    }
}
