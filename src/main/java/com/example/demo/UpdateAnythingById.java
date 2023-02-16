package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/updateNameById")
public class UpdateAnythingById extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Так выглядит метод, чтобы обновлять что угодно, можно сразу несколько
        Employee employee = EmployeeRepository.getEmployeeById(
                Integer.parseInt(req.getParameter("id"))
        );
        Enumeration<String> parametrNames = req.getParameterNames();

        while (parametrNames.hasMoreElements()) {
            String parName = parametrNames.nextElement();
            if (parName.equals("name")) {
                employee.setName(req.getParameter(parName));
            }
            if (parName.equals("email")) {
                employee.setEmail(req.getParameter(parName));
            }
            if (parName.equals("country")) {
                employee.setCountry(req.getParameter(parName));
            }
        }
        EmployeeRepository.update(employee);


        // Так выглядит метод, чтобы обновить только по имени
        /* Employee employee = getEmployeeById(
                Integer.parseInt(
                        req.getParameter("id")
                )
        );
        employee.setName(req.getParameter("name"));
        EmployeeRepository.update(employee);*/
    }
    }

