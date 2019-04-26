package io.github.demirmustafa.cloudcontract.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Mustafa Demir <mustafa.demir@sahabt.com>
 */
@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private Category category;
    private BigDecimal price;
}


@NoArgsConstructor
@AllArgsConstructor
enum Category {

    BOOK("Book", "book"),
    TECH("Tech", "tech");

    private String cleanName;
    private String code;
}