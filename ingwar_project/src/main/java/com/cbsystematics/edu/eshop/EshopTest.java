package com.cbsystematics.edu.eshop;

import com.cbsystematics.edu.eshop.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.util.Arrays.asList;

public class EshopTest {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.cbsystematics.edu.eshop");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

//        Role role = new Role();
//        role.setName("Admin");
//        entityManager.persist(role);
//
//        Discount discount5 = new Discount();
//        discount5.setDiscountValue(5);
//        Discount discount0 = new Discount();
//        discount0.setDiscountValue(0);
//        entityManager.persist(discount0);
//        entityManager.persist(discount5);
//
//        Category phones = new Category();
//        phones.setName("Phones");
//        entityManager.persist(phones);
//        Category sensorPhones = new Category();
//        sensorPhones.setName("Sensor phones");
//        sensorPhones.setParentCategory(asList(phones));
//        phones.setChildCategory(asList(sensorPhones));
//        entityManager.persist(sensorPhones);
//        entityManager.persist(phones);
//
//        Product product = new Product();
//        product.setName("New sensor phone");
//        product.setSerial("XX234");
//        product.setCategories(asList(phones,sensorPhones));
//        product.setDiscounts(asList(discount0,discount5));
//        product.setPrice(3000.00);
//        entityManager.persist(product);
//
//        UserDetails userDetails = new UserDetails();
//        userDetails.setPhone("099-455-3322");
//        userDetails.setCity("Kyiv");
//        userDetails.setAge(33);
//        entityManager.persist(userDetails);
//
//        Order order = new Order();
//        order.setOrderNumber("NN203");
//        try {
//            order.setOrderDate(new SimpleDateFormat("yyyy-mm-dd").parse("2019-01-09"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        order.setProducts(asList(product));
//        entityManager.persist(order);
//
//        User user = new User();
//        user.setUsername("SuperAdmin");
//        user.setPassword("11245");
//        user.setFirstName("Jack");
//        user.setLastName("Johnson");
//        user.setUserDetails(userDetails);
//        user.setRole(role);
//        user.setOrders(asList(order));
//        entityManager.persist(user);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
