package ru.example.servletlesson.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ru.example.servletlesson.service.Calculator;
import ru.example.servletlesson.service.impl.CalculatorImpl;

@WebServlet(value = "/")
public class HelloServlet extends HttpServlet {
    private String message;
    private Calculator calculator;

    public void init() {
        calculator = new CalculatorImpl();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("jsp/basic.jsp").forward(request, response);
    }

    public void destroy() {
    }
}