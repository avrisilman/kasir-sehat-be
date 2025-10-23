package com.kasir.sehat.dto;

import com.kasir.sehat.entity.MenuCategory;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class MenuResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal finalPrice;
    private String imageUrl;
    private MenuCategory category;
    private String description;
    private Boolean isAvailable;
    private BigDecimal ppnRate;
}
