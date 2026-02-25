package ru.example.servletlesson.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.example.servletlesson.service.Calculator;
import ru.example.servletlesson.service.impl.CalculatorImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private Calculator calculator;

    @Override
    public void init() {
        calculator = new CalculatorImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("calculator.jsp");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
