package org.jeecqrs.example.multitenancy.domain.product;

import java.math.BigDecimal;
import org.jeecqrs.example.multitenancy.domain.common.AbstractMultiTenancyDomainEvent;
import org.jeecqrs.example.multitenancy.domain.common.TenantId;

/**
 * A product has been listed in the shop.
 */
public final class ProductListed extends AbstractMultiTenancyDomainEvent<ProductListed> {

    private final ProductId productId;
    private final String name;
    private final BigDecimal price;

    public ProductListed(TenantId tenantId, ProductId productId,
            String name, BigDecimal price) {
        super(tenantId);
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public ProductId productId() {
        return productId;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }

}
