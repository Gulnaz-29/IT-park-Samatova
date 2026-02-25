package ru.example.servletlesson.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.example.servletlesson.dto.response.ListProductsResponse;
import ru.example.servletlesson.service.ProductService;
import ru.example.servletlesson.service.impl.CalculatorImpl;

import java.io.IOException;

@WebServlet(name = "products", value = "/products")
public class ProductServlet  extends HttpServlet {
    private ProductService productService;
//  private CategoryService categoryService;

    @Override
    public void init() throws ServletException {

        ServletContext servletContext = getServletContext();

      productService = (ProductService) servletContext.getAttribute("productService");
//      categoryService = (CategoryService) servletContext.getAttribute("categoryService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println("Сервлет /products вызван!");
        // resp.sendRedirect("products.jsp");
//      UserDataResponse user = (UserDataResponse) session.getAttribute("user");

      ListProductsResponse listProductsResponse = productService.getAllProducts();
//      ListCategoriesResponse listCategoryResponse = categoryService.getAllCategories();


      session.setAttribute("products", listProductsResponse);
//      session.setAttribute("categories", listCategoryResponse);

      req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);



    }
    @Override
    public void destroy() {
        super.destroy();
    }
  //  }
}
