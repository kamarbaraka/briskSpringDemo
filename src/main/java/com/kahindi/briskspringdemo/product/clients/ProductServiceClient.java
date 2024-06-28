package com.kahindi.briskspringdemo.product.clients;

import product.Product;

import java.util.List;



/**
 * The ProductServiceClient interface defines the contract for a client that interacts with a ProductService
 * to retrieve a list of all products.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
public interface ProductServiceClient {

    List<Product> getAllProducts(); /*get a list of all products from the system*/
}
