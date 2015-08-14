package org.jeecqrs.example.multitenancy.infra;

import javax.ejb.Stateless;
import org.jeecqrs.example.multitenancy.domain.product.Product;
import org.jeecqrs.example.multitenancy.domain.product.ProductId;
import org.jeecqrs.example.multitenancy.domain.product.ProductRepository;

@Stateless
public class ProductRepositoryImpl extends AbstractMultiTenancyRepository<Product, ProductId>
    implements ProductRepository {

}
