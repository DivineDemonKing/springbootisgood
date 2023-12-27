package com.example.demo.dao;


import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public void deleteById (long id) {
      Session session = entityManager.unwrap(Session.class);
      try{
         User user = (User) session.get(User.class, id);
         session.delete(user);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   @Override
   public void update (User user1) {
      Session session = entityManager.unwrap(Session.class);
      try {
         User user2 = (User) session.get(User.class, user1.getId());
         session.evict(user2);
         user2.setEmail(user1.getEmail());
         user2.setFirstName(user1.getFirstName());
         user2.setLastName(user1.getLastName());
         session.update(user2);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return entityManager.createQuery("select u From User u", User.class).getResultList();
   }

}
