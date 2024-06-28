package com.kahindi.briskspringdemo.product.clients;


import io.grpc.ManagedChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import product.Empty;
import product.Product;
import product.ProductList;
import product.ProductServiceGrpc;
import product.ProductServiceGrpc.ProductServiceBlockingStub;

import java.util.List;

/**
 * A client class for interacting with the Product Service.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceClientImpl implements ProductServiceClient {

    private final ManagedChannel channel; /*inject the managed channel bean*/

    /**
     * Retrieves all the products from the server.
     *
     * @return A list of Product objects representing all the products.
     */
    @Override
    public List<Product> getAllProducts() {

        /*create a blocking stub*/
        ProductServiceBlockingStub blockingStub = ProductServiceGrpc.newBlockingStub(channel);

        /*invoke the findAll rpc method and get the response and return*/
        ProductList productList = blockingStub.findAll(Empty.newBuilder().build());

        if (channel.isShutdown()) {
            channel.shutdownNow();
        }

        return productList.getProductsList();
    }
}
