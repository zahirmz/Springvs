package com.example.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.web.bean.Car;

// import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.service.CarService;



@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService cserv;
    @PostMapping("/addcars")
    public ResponseEntity<Car> addCar(@RequestBody Car car)
    {
        Car savedcar=cserv.addCar(car);
        return ResponseEntity.ok(savedcar);
    }

    @GetMapping("/getallcars")
    public ResponseEntity<List<Car>> getAllCar()
    {
        List<Car> savedcar=cserv.getAllCar();

        return ResponseEntity.ok(savedcar);

    }

    @GetMapping("/getcarbyid/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id)
    {
        Optional<Car> car=cserv.getById(id);
        if(car.isPresent())
        {
            return ResponseEntity.ok(car.get());

        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id,@RequestBody Car updatedcar)
    {
        Optional<Car> existingcar=cserv.getById(id);
        if(existingcar.isPresent())
        {
            Car car=existingcar.get();
            car.setBrand(updatedcar.getBrand());
            car.setModel(updatedcar.getModel());
            car.setYear(updatedcar.getYear());

            Car savedcar=cserv.updateCar(car);
            return ResponseEntity.ok().body(savedcar);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}


    
    



    
    


