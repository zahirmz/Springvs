package com.example.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.bean.Car;
import com.example.web.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car)
    {
        return carRepository.save(car);
    }
    public List<Car> getAllCar()
    {
        return carRepository.findAll();
    }

    public Optional<Car> getById(Long id)
    {
        return carRepository.findById(id);
    }

    public Car updateCar(Car car)
    {
        return carRepository.save(car);
    }

    public Boolean deleteCar(Long id) {
        if(carRepository.existsById(id))
        {
            carRepository.deleteById(id);
            return true;
        }
        else{
            return false;

        }
    }

    public List<Car> getCarsByBrand(String brand) {
    return carRepository.findByBrand(brand);
    }

    public List<Car> getCarsByModel(String model) {
        return carRepository.findByModel(model);
    }
 

}
