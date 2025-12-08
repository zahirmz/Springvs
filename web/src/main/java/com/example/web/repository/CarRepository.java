package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.bean.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
