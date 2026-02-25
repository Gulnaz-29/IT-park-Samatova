package ru.example.servletlesson.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.example.servletlesson.mapper.ProductMapper;
import ru.example.servletlesson.model.ProductEntity;
import ru.example.servletlesson.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_SELECT_BY_ID = "select * from  products where id_product = ?";

    private static final String SQL_SELECT_ALL_PRODUCTS = "SELECT * FROM products";

    private static final String SQL_INSERT_PRODUCT = "insert into products(name_product, price, quantity) values (?,?,?);";

    //private final CategoryRepository categoryRepository;public

    private final ProductMapper productMapper;


    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> products = jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productMapper);
/*
        for (ProductEntity product : products) {
            product.setCategories(categoryRepository.findCategoriesByProductId(product.getId()));
        }
*/
        return products;
    }

    @Override
    public Optional<ProductEntity> findProductById(int id_product) {
        try {
            ProductEntity product = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, productMapper, id_product);
    /*        if (product != null) {
                product.setCategories(categoryRepository.findCategoriesByProductId(id));
            }
*/
            return Optional.ofNullable(product);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> saveNewProduct(ProductEntity product/*, List<CategoryRequest> category*/) {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(SQL_INSERT_PRODUCT, new String[] {"id_product"});
                ps.setString(1, product.getName_product());
                ps.setInt(2, product.getPrice());
                ps.setInt(3, product.getQuantity());
                return ps;
            }, holder);
            int id_product = Objects.requireNonNull(holder.getKey()).intValue();

        /*    if (product.getCategories() == null) {
                categoryRepository.saveProductCategories(id, category);
            }
*/

            return findProductById(id_product);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
