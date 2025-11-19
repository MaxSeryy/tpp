package ua.cn.stu.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.cn.stu.lab3.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
