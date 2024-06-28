package com.kahindi.briskspringdemo.product.services;

import com.kahindi.briskspringdemo.product.entities.OrderEntity;
import com.kahindi.briskspringdemo.product.entities.ProductEntity;
import com.kahindi.briskspringdemo.product.repositories.OrderEntityRepository;
import com.kahindi.briskspringdemo.product.repositories.ProductEntityRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import orders.OrderServiceGrpc.OrderServiceImplBase;
import orders.OrderServiceOuterClass.Order;
import orders.OrderServiceOuterClass.OrderRequest;
import org.springframework.transaction.annotation.Transactional;
import product.Empty;
import product.Product;
import product.ProductID;
import product.ProductList;

import java.util.List;
import java.util.stream.Stream;

/**
 * The OrderServiceImpl class is responsible for handling order-related operations.
 * It extends the OrderServiceImplBase class, which is a gRPC service.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@GrpcService
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl extends OrderServiceImplBase {

    private final OrderEntityRepository orderRepository;
    private final ProductEntityRepository productRepository;


    /**
     * Converts a ProductEntity object to a Product object.
     *
     * @param productEntity The ProductEntity object to be converted.
     * @return The converted Product object.
     */
    private Product productEntityToProduct(ProductEntity productEntity) {

        return Product.newBuilder()
                .setID(productEntity.getId())
                .setProductName(productEntity.getName())
                .setSerialNo(productEntity.getSerialNo())
                .setPrice(productEntity.getPrice().doubleValue())
                .build();

    }
    /**
     * Converts an OrderEntity object to an Order object.
     *
     * @param orderEntity    The OrderEntity object to be converted.
     * @param orderProducts  The list of products associated with the order.
     * @return The converted Order object.
     */
    private Order orderEntityToOrder(OrderEntity orderEntity, List<Product> orderProducts) {

        ProductList productList = ProductList.newBuilder()
                .addAllProducts(orderProducts)
                .build();
        return Order.newBuilder()
                .setOrderNo(orderEntity.getOrderNumber())
                .setProducts(productList)
                .build();
    }

    /**
     * Places an order based on the given request and sends the response through the provided response observer.
     *
     * @param request          The OrderRequest object containing the list of product IDs.
     * @param responseObserver The StreamObserver to send the response Order object.
     */
    @Override
    public void placeOrder(OrderRequest request, StreamObserver<Order> responseObserver) {

        /*get the products and create an order*/
        List<Long> productIDsList = request.getIdList().stream().map(ProductID::getID).toList();
        List<ProductEntity> orderedProducts = productRepository.findAllById(productIDsList);

        OrderEntity orderEntity = OrderEntity.builder()
                .build();
        orderEntity.getProducts().addAll(orderedProducts);

        /*persist the order*/
        OrderEntity savedOrder = orderRepository.save(orderEntity);

        /*create the response object*/
        List<Product> orderedProductList = orderedProducts.stream().map(this::productEntityToProduct).toList();

        Order createdOrder = this.orderEntityToOrder(savedOrder, orderedProductList);
        /*process the response*/
        responseObserver.onNext(createdOrder);
        responseObserver.onCompleted();
    }

    /**
     * Retrieves all orders and sends them through the provided response observer.
     *
     * @param request          An Empty object representing the request. It is not used in this method.
     * @param responseObserver The StreamObserver to send the response Order objects.
     */
    @Override
    public void getAllOrders(Empty request, StreamObserver<Order> responseObserver) {

        /*get all orders*/
        Stream<Order> orderStream = orderRepository.getAllOrders().map(orderEntity -> {
            List<Product> productList = orderEntity.getProducts().stream().map(this::productEntityToProduct).toList();
            return this.orderEntityToOrder(orderEntity, productList);
        });

        /*process the response*/
        orderStream.forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
