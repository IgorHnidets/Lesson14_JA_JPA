import models.Car;
import models.User;
import service.CarService;
import service.UserService;
import service.impl.CarServiceImpl;
import service.impl.UserServiceImpl;

import javax.persistence.*;
import java.util.List;


public class Main {
    private static CarService carService = new CarServiceImpl();
    private static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {

//        FOR CAR ( Classwork ) {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_test");
//        EntityManager manager = factory.createEntityManager();

//        manager.getTransaction().begin();
//        manager.persist(new Car("Audi","RS3"));
//        manager.persist(new Car("MB","S300"));
//        manager.getTransaction().commit();

//        TypedQuery<Car> query = manager.createQuery("select c from Car c where c.id = :id",Car.class);
//        query.setParameter("id",1);
//        List<Car> resultList = query.getResultList();
//        resultList.forEach(System.out::println);
//
//        factory.close();
//        manager.close();

//        carService.create(new Car("Peugeot","308"));
//        carService.getAll().forEach(System.out::println);
//        System.out.println(carService.getCarById(3));
//        carService.delete(2);
//        carService.getAll().forEach(System.out::println);

//           }



//        FOR USER ( Homework ) {

//        EntityManagerFactory factoryUser = Persistence.createEntityManagerFactory("jpa_test");
//        EntityManager managerUser = factoryUser.createEntityManager();
//
//        managerUser.getTransaction().begin();
//        managerUser.persist(new User("Igor","Hnidets","mail.com","123","ADMIN"));
//        managerUser.getTransaction().commit();
//
//        factoryUser.close();
//        managerUser.close();


        userService.getAllUsers().forEach(System.out::println);
        System.out.println(userService.getUserById(6));

    }
}
