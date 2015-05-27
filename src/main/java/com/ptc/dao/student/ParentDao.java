package com.ptc.dao.student;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demoapp.demo.model.stock.Stock;
import com.demoapp.demo.model.user.User;
import com.demoapp.demo.util.HibernateUtil;
import com.ptc.entity.Parent;

@Transactional
@Repository
public class ParentDao {
    public List<Parent> fetchAll(boolean includeAll) {
        System.out.println("ParentDao: fetchAll");
        System.out.println("ParentDao: START - fetching all parents from the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        List<Parent> fetchedParents = (List<Parent>) session.createCriteria(Parent.class).
                list();

        System.out.println("DEBUG: includeAll [" + includeAll + "]");
       

        return fetchedParents;
    }

    public Parent fetch(Long userID) {
        System.out.println("Parent: fetch");
        System.out.println("Parent: START - fetching parent from the database by user ID");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Parent fetchedUser = (Parent) session.get(Parent.class, userID);
        System.out.println("Parent: END - fetching user from the database by user ID");
        //fetchedUser.addStock(stock);
        return fetchedUser;
    }


}
