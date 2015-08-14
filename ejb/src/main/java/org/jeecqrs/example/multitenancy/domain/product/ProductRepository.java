package org.jeecqrs.example.multitenancy.domain.product;

import org.jeecqrs.example.multitenancy.domain.common.MultiTenancyRepository;
import org.jeecqrs.example.multitenancy.domain.common.TenantId;

public interface ProductRepository extends MultiTenancyRepository<Product, ProductId> {

    boolean exists(TenantId tenantId, ProductId productId);
    
}
