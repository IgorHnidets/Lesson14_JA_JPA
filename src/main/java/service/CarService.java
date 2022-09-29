package service;

import models.Car;

import java.util.List;

public interface CarService {
    Car getCarById(int id);
    List<Car> getAll();
    void create(Car car);
    void delete(int id);
}
