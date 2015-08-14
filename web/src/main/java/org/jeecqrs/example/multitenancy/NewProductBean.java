package org.jeecqrs.example.multitenancy;

import java.io.Serializable;
import java.math.BigDecimal;

public class NewProductBean implements Serializable {

    private String name;
    private BigDecimal price;

    public NewProductBean() {
    }

    public NewProductBean(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
