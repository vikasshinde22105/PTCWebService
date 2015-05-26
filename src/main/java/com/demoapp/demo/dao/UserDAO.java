package com.demoapp.demo.dao;


import com.demoapp.demo.model.stock.Stock;
import com.demoapp.demo.model.user.User;
import com.demoapp.demo.model.user.UserStatus;
import com.demoapp.demo.util.HibernateUtil;
import com.demoapp.demo.util.PasswordEncoder;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Transactional  
@Repository
public class UserDAO {
    public User add(User user) throws NoSuchAlgorithmException {
        System.out.println("UserDAO: add");
        System.out.println("UserDAO: START - adding user to the database");

        user.setUserStatusCode("A");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        user.setPassword(PasswordEncoder.getEncodedPassword(user.getUsername(), user.getPassword()));
        session.save(user);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - adding user to the database");

        return user;
    }

    public User update(Long userID, User user) throws NoSuchAlgorithmException {
        System.out.println("UserDAO: update");
        System.out.println("UserDAO: START - updating user to the database");
       
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = fetch(userID);

        if(user.getNameFirst() != null && !fetchedUser.getNameFirst().equals(user.getNameFirst())) {
            fetchedUser.setNameFirst(user.getNameFirst());
        }
        if(user.getNameMiddle() != null && !fetchedUser.getNameMiddle().equals(user.getNameMiddle())) {
            fetchedUser.setNameMiddle(user.getNameMiddle());
        }
        if(user.getNameLast() != null && !fetchedUser.getNameLast().equals(user.getNameLast())) {
            fetchedUser.setNameLast(user.getNameLast());
        }
        String currentEncodedPassword = PasswordEncoder.getEncodedPassword(user.getUsername(), user.getPassword());
        if(user.getPassword() != null && !fetchedUser.getPassword().equals(currentEncodedPassword)) {
            fetchedUser.setPassword(currentEncodedPassword);
        }
        if(user.getUserStatusCode() != null && fetchedUser.getUserStatusCode() != user.getUserStatusCode()) {
            fetchedUser.setUserStatusCode(user.getUserStatusCode());
        }
        if(user.getDateOfBirth() != null && fetchedUser.getDateOfBirth() != user.getDateOfBirth()) {
            fetchedUser.setDateOfBirth(user.getDateOfBirth());
        }
        if(user.getMonthOfBirth() != null && fetchedUser.getMonthOfBirth() != user.getMonthOfBirth()) {
            fetchedUser.setMonthOfBirth(user.getMonthOfBirth());
        }
        if(user.getYearOfBirth() != null && fetchedUser.getYearOfBirth() != user.getYearOfBirth()) {
            fetchedUser.setYearOfBirth(user.getYearOfBirth());
        }
        fetchedUser.setUpdatedAt(new Date());

        session.update(fetchedUser);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - updating user to the database");

        return fetchedUser;
    }

    public User fetch(Long userID) {
        System.out.println("UserDAO: fetch");
        System.out.println("UserDAO: START - fetching user from the database by user ID");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = (User) session.get(User.class, userID);
        System.out.println("UserDAO: END - fetching user from the database by user ID");
        Stock stock = new Stock();
        //fetchedUser.addStock(stock);
        System.out.println("Data"+fetchedUser.getStocks());
        return fetchedUser;
    }

    public User fetchByUsername(String username) {
        System.out.println("UserDAO: fetchByUsername");
        System.out.println("UserDAO: START - fetching user from the database by username");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = (User) session.createCriteria(User.class).
                add(Restrictions.eq("username", username)).
                uniqueResult();
        System.out.println("UserDAO: END - fetching user from the database by username");

        return fetchedUser;
    }
	    public List<User>  testJoinSelect(boolean includeAll) {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        SQLQuery  q =session.createSQLQuery("select {e.*}, {c.*} from User e join Stock c "
            + "on e.id = c.user_id ");
	        q.addEntity(User.class);
	        q.addJoin("c", "e.stocks");
	        List<User> entities = q.list();
	        for (User entity : entities) {
	            System.out.println(entity);
	        }
	        return entities;
	    }
    public List<User> fetchAll(boolean includeAll) {
        System.out.println("UserDAO: fetchAll");
        System.out.println("UserDAO: START - fetching all users from the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        List<User> fetchedUsers = (List<User>) session.createCriteria(User.class).
                list();

        System.out.println("DEBUG: includeAll [" + includeAll + "]");
        if(includeAll == false) {
            System.out.println("UserDAO: removing non-active users");
            Iterator<User> iterator = fetchedUsers.iterator();
            while(iterator.hasNext()) {
                User currentUser = (User) iterator.next();
                String userStatusCode = currentUser.getUserStatusCode();
                System.out.println("DEBUG: User Status Code [" + userStatusCode + "]");
                if(!userStatusCode.equals("A")) {
                    System.out.println("DEBUG: Removing User [" + currentUser.getUsername() + "]");
                    iterator.remove();
                }
            }
        } else {
            System.out.println("UserDAO: including all users");
        }
        System.out.println("UserDAO: END - fetching all users from the database");

        return fetchedUsers;
    }

    public User delete(Long userID) {
        System.out.println("UserDAO: delete");
        System.out.println("UserDAO: START - setting user status to delete in the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = fetch(userID);
        fetchedUser.setUserStatusCode("D");
        fetchedUser.setUpdatedAt(new Date());
        session.update(fetchedUser);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - setting user status to delete in the database");

        return fetchedUser;
    }
}
