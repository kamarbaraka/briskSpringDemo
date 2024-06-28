package com.kahindi.briskspringdemo.product.repositories;

import com.kahindi.briskspringdemo.product.entities.OrderEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Represents a repository for managing OrderEntity objects in the system.
 *
 * <p>
 * The OrderEntityRepository interface extends the JpaRepository interface, which provides
 * CRUD operations (create, read, update, delete) for OrderEntity objects. It is used to
 * interact with the underlying database table for OrderEntity objects.
 * </p>
 *
 * <p>
 * This repository is responsible for managing the persistence of OrderEntity objects.
 * It provides methods such as save, findById, findAll, delete, etc. for CRUD operations.
 * </p>
 *
 * @see OrderEntity
 *
 * @since 1.0
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * Finds an OrderEntity by its order number.
     *
     * @param orderNumber The order number of the OrderEntity to find. Cannot be null.
     * @return An Optional containing the OrderEntity if found, or an empty Optional if not found.
     */
    Optional<OrderEntity> findOrderEntityByOrderNumber(@NotNull String  orderNumber);

    /**
     * Retrieves all orders from the database.
     *
     * @return A Stream of OrderEntity objects containing all orders in the database.
     */
    @Query("select o from OrderEntity o")
    Stream<OrderEntity> getAllOrders();
}