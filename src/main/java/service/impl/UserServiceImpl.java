package service.impl;

import jpa.FactoryManager;
import models.User;
import service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserServiceImpl implements UserService {

    private EntityManager entityManager = FactoryManager.getEntityManager();
    @Override
    public User getUserById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
        query.where(builder.equal(from.get("id"),id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select user from User user", User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void createNewUser(User user) {
        if (!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(int id) {
        User userById = getUserById(id);
        if (!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(userById);
        entityManager.getTransaction().commit();
    }
}
