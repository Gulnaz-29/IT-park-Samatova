package ru.example.servletlesson.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/*
import ru.example.servletlesson.mapper.CategoryMapper;
import ru.example.servletlesson.mapper.ProductMapper;
//import ru.example.servletlesson.mapper.UserMapper;
import ru.example.servletlesson.mapper.impl.CategoryMapperImpl;
import ru.example.servletlesson.mapper.impl.ProductMapperImpl;
//import ru.example.servletlesson.mapper.impl.UserMapperImpl;
import ru.example.servletlesson.repository.CategoryRepository;
import ru.example.servletlesson.repository.ProductRepository;
//import ru.example.servletlesson.repository.UserRepository;
import ru.example.servletlesson.repository.impl.CategoryRepositoryImpl;
import ru.example.servletlesson.repository.impl.ProductRepositoryImpl;
//import ru.example.servletlesson.repository.impl.UserRepositoryImpl;
import ru.example.servletlesson.service.CategoryService;
import ru.example.servletlesson.service.ProductService;
//import ru.example.servletlesson.service.UserService;
import ru.example.servletlesson.service.impl.CategoryServiceImpl;
import ru.example.servletlesson.service.impl.ProductServiceImpl;
//import ru.example.servletlesson.service.impl.UserServiceImpl;
*/
import ru.example.servletlesson.mapper.ProductMapper;
import ru.example.servletlesson.mapper.impl.ProductMapperImpl;
import ru.example.servletlesson.repository.ProductRepository;
import ru.example.servletlesson.repository.impl.ProductRepositoryImpl;
import ru.example.servletlesson.service.ProductService;
import ru.example.servletlesson.service.impl.ProductServiceImpl;
import ru.example.servletlesson.utils.PropertyReader;


import javax.sql.DataSource;
import java.util.List;

@Slf4j
@WebListener

public class MainContextListener implements ServletContextListener  {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        DataSource dataSource = dataSource();
        context.setAttribute("dataSource", dataSource);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        context.setAttribute("jdbcTemplate", jdbcTemplate);


        ProductMapper productMapper = new ProductMapperImpl();
        context.setAttribute("productMapper", productMapper);
/*
        CategoryMapper categoryMapper = new CategoryMapperImpl();
        context.setAttribute("categoryMapper", categoryMapper);

        UserMapper userMapper = new UserMapperImpl();
        context.setAttribute("userMapper", userMapper);

        CategoryRepository categoryRepository = new CategoryRepositoryImpl(jdbcTemplate, categoryMapper);
        context.setAttribute("categoryRepository", categoryRepository);
*/
        ProductRepository productRepository = new ProductRepositoryImpl(jdbcTemplate, /*,categoryRepository*/ productMapper);
        context.setAttribute("productRepository", productRepository);
/*
        UserRepository userRepository = new UserRepositoryImpl(jdbcTemplate, userMapper);
        context.setAttribute("userRepository", userRepository);

        CategoryService categoryService = new CategoryServiceImpl(categoryRepository, categoryMapper);
        context.setAttribute("categoryService", categoryService);
*/
        ProductService productService = new ProductServiceImpl(productRepository, productMapper);
        context.setAttribute("productService", productService);
/*
        UserService userService = new UserServiceImpl(userRepository, userMapper);
        context.setAttribute("userService", userService);

        List<String> PROTECTED_URIS = List.of(PropertyReader.getProperty("PROTECTED_URIS").split(","));
        context.setAttribute("PROTECTED_URIS", PROTECTED_URIS);
        List<String> PROTECTED_ADMIN_URIS = List.of(PropertyReader.getProperty("PROTECTED_ADMIN_URIS").split(","));
        context.setAttribute("PROTECTED_ADMIN_URIS", PROTECTED_ADMIN_URIS);
        List<String> NOTAUTH_URIS = List.of(PropertyReader.getProperty("NOTAUTH_URIS").split(","));
        context.setAttribute("NOTAUTH_URIS", NOTAUTH_URIS);


        String PROTECTED_REDIRECT = PropertyReader.getProperty("PROTECTED_REDIRECT");
        context.setAttribute("PROTECTED_REDIRECT", PROTECTED_REDIRECT);
        String PROTECTED_ADMIN_REDIRECT = PropertyReader.getProperty("PROTECTED_ADMIN_REDIRECT");
        context.setAttribute("PROTECTED_ADMIN_REDIRECT", PROTECTED_ADMIN_REDIRECT);
        String NOTAUTH_REDIRECT = PropertyReader.getProperty("NOTAUTH_REDIRECT");
        context.setAttribute("NOTAUTH_REDIRECT", NOTAUTH_REDIRECT);

        String AUTHORIZATION = PropertyReader.getProperty("AUTHORIZATION");
        context.setAttribute("AUTHORIZATION", AUTHORIZATION);

        String IS_ADMIN = PropertyReader.getProperty("IS_ADMIN");
        context.setAttribute("IS_ADMIN", IS_ADMIN);

        String SECRET_KEY = PropertyReader.getProperty("SECRET_KEY");
        context.setAttribute("SECRET_KEY", SECRET_KEY);

*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("-=-=-=-=-=-=-=-=- CONTEXT DESTROYED -==-=-=-=-=-=-=-=-=");
    }

    private DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(PropertyReader.getProperty("DB_URL"));
        dataSource.setUser(PropertyReader.getProperty("DB_USER"));
        dataSource.setPassword(PropertyReader.getProperty("DB_PASSWORD"));
        return dataSource;
    }

}
