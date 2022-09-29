package service.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.FactoryManager;
import models.Car;
import service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private EntityManager entityManager = FactoryManager.getEntityManager();
    @Override
    public Car getCarById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        Root<Car> from = query.from(Car.class);
        query.select(from);
        query.where(builder.equal(from.get("id"),id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Car> getAll() {
        TypedQuery<Car> query = entityManager.createQuery("select car from Car car", Car.class);
        List<Car> resultList = query.getResultList();
        return resultList;


    }

    @Override
    public void create(Car car) {
        if (!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Car carById = getCarById(id);
        if (!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(carById);
        entityManager.getTransaction().commit();
    }
}
