package com.kahindi.briskspringdemo.product.controllers;


import com.kahindi.briskspringdemo.product.clients.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import product.Product;

import java.util.List;

/**
 * The ProductServiceController class is responsible for handling requests related to products.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"home/products"})
public class ProductServiceController {

    private final ProductServiceClient client;/*inject the client*/

    /**
     * Retrieves all products from the client and adds them to the model.
     *
     * @param model the model to add the products to
     * @return the name of the view for displaying the products
     */
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = client.getAllProducts();/*get all products from the client*/
        model.addAttribute("products", products);/*add the products to the model*/
        return "products";/*return the view*/
    }
}
