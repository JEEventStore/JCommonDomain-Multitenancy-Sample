package org.jeecqrs.example.multitenancy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jeecqrs.example.multitenancy.domain.common.RandomId;
import org.jeecqrs.example.multitenancy.domain.product.Product;
import org.jeecqrs.example.multitenancy.domain.product.ProductId;
import org.jeecqrs.example.multitenancy.domain.product.ProductRepository;
import org.jeecqrs.example.multitenancy.domain.common.TenantId;

@Path("product")
@Stateless
public class ProductWebService {

    @EJB
    private ProductRepository productRepository;

    @GET
    @Path("{tenantId}/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(
            @PathParam("tenantId") String tenantIdString,
            @PathParam("productId") String productIdString) {

        TenantId tenantId = TenantId.fromString(tenantIdString);
        ProductId productId = ProductId.fromString(productIdString);

        if (!productRepository.exists(tenantId, productId)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No such product: " + tenantId + "/" + productId)
                    .build();
        }

        Product product = productRepository.ofIdentity(tenantId, productId);
        ProductBean bean = new ProductBean(
                product.tenantId().toString(),
                product.id().toString(),
                product.name(),
                product.price());
        return Response.status(Response.Status.OK)
                .entity(bean)
                .build();
    }

    @PUT
    @Path("{tenantId}/{productId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response putProduct(
            @PathParam("tenantId") String tenantIdString,
            @PathParam("productId") String productIdString,
            NewProductBean productBean) {
            
        TenantId tenantId = TenantId.fromString(tenantIdString);
        ProductId productId = ProductId.fromString(productIdString);

        if (productRepository.exists(tenantId, productId)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Cannot overwrite existing product: " + tenantId + "/" + productId)
                    .build();
        }

        Product product = new Product(tenantId, productId,
                productBean.getName(), productBean.getPrice());
	productRepository.save(product, RandomId.get());

        return Response.status(Response.Status.CREATED).build();
    }

}
