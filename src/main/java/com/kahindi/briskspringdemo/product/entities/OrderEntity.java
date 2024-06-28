package com.kahindi.briskspringdemo.product.entities;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an order in the system.
 *
 * <p>
 * The OrderEntity class represents an order placed by a customer. It is annotated with
 * {@link jakarta.persistence.Entity} indicating that it is an entity to be stored in the database.
 * It maps to a table named "orders" using the {@link jakarta.persistence.Table} annotation.
 * The class also uses Lombok annotations such as {@link Builder}, {@link AllArgsConstructor},
 * {@link NoArgsConstructor}, and {@link Getter} to generate boilerplate code.
 * </p>
 *
 * <p>
 * The class extends {@link AbstractAuditable} which provides
 * auditing support, maintaining information about creation and modification of the order.
 * </p>
 *
 * @see ProductEntity
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
@Getter
public class OrderEntity extends AbstractAuditable<OrderEntity, Long> {

    @Transient
    private final Random random = new Random();
    @Column(name = "order_number")
    private final String orderNumber = random.nextInt(0, 100)+ "Kbhs"+
            random.nextInt(100, 1000)+ "sbk";

    @ManyToMany
    private final Set<ProductEntity> products = new HashSet<>();

}