package ru.example.servletlesson.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import ru.example.servletlesson.dto.response.ListProductsResponse;
import ru.example.servletlesson.dto.response.ProductsResponse;
import ru.example.servletlesson.service.ProductService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/products/sort")
public class SortProductsServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        this.productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        // Получаем данные из БД (не из сессии!)
        ListProductsResponse freshProducts = productService.getAllProducts();

        // Сортируем в памяти
        List<ProductsResponse> sorted = freshProducts.getProducts().stream()
                .sorted(Comparator.comparing(ProductsResponse::getName))
                .collect(Collectors.toList());

        // Сохраняем в запросе (не в сессии!)
        req.setAttribute("products", new ListProductsResponse(sorted));
        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }
}
