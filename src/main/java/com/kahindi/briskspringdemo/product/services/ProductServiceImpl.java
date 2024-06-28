package com.kahindi.briskspringdemo.product.services;

import com.kahindi.briskspringdemo.product.entities.ProductEntity;
import com.kahindi.briskspringdemo.product.repositories.ProductEntityRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import product.Empty;
import product.Product;
import product.ProductID;
import product.ProductList;
import product.ProductServiceGrpc.ProductServiceImplBase;

import java.math.BigDecimal;
import java.util.List;


/**
 * This class is an implementation of the Product service. It provides methods to register, retrieve
 * and search for products.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@GrpcService
@Log4j2(topic = "Product Service") /*define the logger*/
@RequiredArgsConstructor
public class ProductServiceImpl extends ProductServiceImplBase {

    private final ProductEntityRepository repository;

    /**
     * Registers a new product.
     *
     * @param request           the product to be registered
     * @param responseObserver the response observer that handles the registration result
     */
    @Override
    public void register(Product request, StreamObserver<ProductID> responseObserver) {

        /*create a product*/
        ProductEntity newProduct = ProductEntity.builder()
                .name(request.getProductName())
                .serialNo(request.getSerialNo())
                .price(BigDecimal.valueOf(request.getPrice()))
                .build();


        /*persist the product*/
        repository.save(newProduct);

        /*create the response*/
        ProductID productID = ProductID.newBuilder()
                .setID(newProduct.getId())
                .build();

        /*process the response*/
        responseObserver.onNext(productID);
        responseObserver.onCompleted();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param request           the request containing the ID of the product
     * @param responseObserver the response observer that handles the retrieved product
     */
    @Override
    public void findProductByID(ProductID request, StreamObserver<Product> responseObserver) {

        /*retrieve the product matching the ID else throw*/
        ProductEntity retrievedProduct = repository.findById(request.getID())
                .orElseThrow();

        /*create the response object*/
        Product foundProduct = Product.newBuilder()
                .setID(request.getID())
                .setProductName(retrievedProduct.getName())
                .setSerialNo(retrievedProduct.getSerialNo())
                .setPrice(retrievedProduct.getPrice().doubleValue())
                .build();

        /*process the response*/
        responseObserver.onNext(foundProduct);
        responseObserver.onCompleted();

    }

    /**
     * Retrieves all products from the system and sends them as a list of Product DTOs to the client.
     *
     * @param request           the request parameter (Empty) used to trigger the findAll operation
     * @param responseObserver the response observer that handles the list of Product DTOs
     */
    @Override
    public void findAll(Empty request, StreamObserver<ProductList> responseObserver) {


        /*get all the products from the system and convert them to Product DTO*/
        List<Product> productList = repository.findAll().stream().map(productEntity ->
                Product.newBuilder()
                        .setID(productEntity.getId())
                        .setProductName(productEntity.getName())
                        .setSerialNo(productEntity.getSerialNo())
                        .setPrice(productEntity.getPrice().doubleValue())
                        .build()
        ).toList();

        /*append the products to the list*/
        ProductList response = ProductList.newBuilder().addAllProducts(productList).build();

        /*process the response*/
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
