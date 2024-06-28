package com.kahindi.briskspringdemo.product.repositories;

import com.kahindi.briskspringdemo.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing Product entities.
 * Provides methods to perform CRUD operations on the database table "products".
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}