package ru.example.servletlesson.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.example.servletlesson.service.Calculator;
import ru.example.servletlesson.service.impl.CalculatorImpl;

@WebServlet(name = "MINUS", value = "/calculator/minus")
public class CalculatorServlet_Minus extends HttpServlet{
    private Calculator calculator;

    @Override
    public void init() {
        calculator = new CalculatorImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int a = Integer.parseInt(request.getParameter("value1"));
        int b = Integer.parseInt(request.getParameter("value2"));

        int result = calculator.minus(a,b);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2> MINUS = " + result + "</h2>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

