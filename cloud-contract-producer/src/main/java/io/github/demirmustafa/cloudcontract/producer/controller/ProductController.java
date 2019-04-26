package io.github.demirmustafa.cloudcontract.producer.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mustafa Demir <mustafa.demir@sahabt.com>
 */
@RestController
@RequestMapping("/producer/api/v1/products")
@Slf4j
public class ProductController {


    private static List<Product> products;

    static {
        products = products();
    }

    @GetMapping
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product){
        log.info("Creating new product: {}", product.toString());
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        if(id <= products.size()){
            return products.get(id - 1);
        }

        throw new RuntimeException("No such element!");
    }



    private static List<Product> products(){
        Product book = Product.builder()
                .category(Category.BOOK)
                .id(1)
                .name("Introduction to Java Programming")
                .price(BigDecimal.valueOf(53.98))
                .build();

        Product headPhone = Product.builder()
                .id(2)
                .name("Creative WP-300")
                .category(Category.TECH)
                .price(BigDecimal.valueOf(132))
                .build();
        return Arrays.asList(book, headPhone);
    }
}


@Data
@Builder
class Product {

    private Integer id;
    private String name;
    private Category category;
    private BigDecimal price;
}

@NoArgsConstructor
@AllArgsConstructor
enum Category {

    BOOK ("Book", "book"),
    TECH("Tech", "tech");

    private String cleanName;
    private String code;
}
