package com.example.befinalexam.repository.postgres;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProductJpaRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product> {
//    @Query("SELECT p.id, p.description, p.image, p.price, p.productname, t.name " +
//            "FROM Product  p inner join Type t on  p.type.id = t.id ")
//    List<Product> getProductsBy();

    @Query("SELECT p.price, p.id, p.type.id, p.description, p.image, p.productname, t.name FROM Product  p inner join Type t on  p.type.id = t.id")
    List<Object> getProductsBy();
}
