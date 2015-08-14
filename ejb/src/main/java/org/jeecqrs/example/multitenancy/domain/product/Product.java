package org.jeecqrs.example.multitenancy.domain.product;

import java.math.BigDecimal;
import org.jeecqrs.example.multitenancy.domain.common.AbstractMultiTenancyEventSourcedAggregateRoot;
import org.jeecqrs.example.multitenancy.domain.common.TenantId;

public class Product extends AbstractMultiTenancyEventSourcedAggregateRoot<Product, ProductId> {

    private ProductId productId;
    private String name;
    private BigDecimal price;

    public Product(TenantId tenantId, ProductId productId, String name, BigDecimal price) {
        if (tenantId == null)
            throw new NullPointerException("tenantId must not be null");
        if (productId == null)
            throw new NullPointerException("productId must not be null");
        if (name == null)
            throw new NullPointerException("product name must not be empty");
        if (price == null)
            throw new NullPointerException("price must not be null");
        this.apply(new ProductListed(tenantId, productId, name, price));
    }

    @Override
    public ProductId id() {
        return this.productId;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }

    protected void when(ProductListed event) {
        this.setTenantId(event.tenantId());
        this.productId = event.productId();
        this.name = event.name();
        this.price = event.price();
    }

    // required for repository
    private Product() { }

}
