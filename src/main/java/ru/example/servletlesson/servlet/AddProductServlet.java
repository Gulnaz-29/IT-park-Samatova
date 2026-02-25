package ru.example.servletlesson.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.jakarta.servlet5.JakartaServletFileUpload;
import ru.example.servletlesson.dto.request.NewProductRequest;
import ru.example.servletlesson.service.ProductService;
import ru.example.servletlesson.service.impl.CalculatorImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "add", value = "/products/add")
public class AddProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        productService = (ProductService) context.getAttribute("productService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/jsp/addproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            // Получаем параметры напрямую из запроса
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            NewProductRequest newProductRequest = NewProductRequest.builder()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();

            productService.saveNewProduct(newProductRequest);

            // Перенаправляем на сервлет с продуктами, а не напрямую на JSP
            resp.sendRedirect(req.getContextPath() + "/products");
        }
        catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Некорректный формат числа: " + e.getMessage());
        }
        catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Ошибка при добавлении продукта: " + e.getMessage());
        }
    }

    public void destroy() {
    }

}

