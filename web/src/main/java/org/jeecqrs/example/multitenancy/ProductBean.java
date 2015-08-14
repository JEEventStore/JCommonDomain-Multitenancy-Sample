package org.jeecqrs.example.multitenancy;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ProductBean implements Serializable {

    private final String tenantId;
    private final String productId;
    private final String name;
    private final BigDecimal price;

    public ProductBean(String tenantId, String productId, String name, BigDecimal price) {
        this.tenantId = tenantId;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
