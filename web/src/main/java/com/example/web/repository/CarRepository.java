package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.bean.Car;


public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);   // ✅ Search by Brand

    List<Car> findByModel(String model);

}
