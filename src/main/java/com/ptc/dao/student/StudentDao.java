package com.ptc.dao.student;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demoapp.demo.model.stock.Stock;
import com.demoapp.demo.model.user.User;
import com.demoapp.demo.util.HibernateUtil;
import com.ptc.entity.Parent;
import com.ptc.entity.Student;

@Transactional
@Repository
public class StudentDao {
    public List<Student> fetchAll(boolean includeAll) {
        System.out.println("Student: fetchAll");
        System.out.println("Student: START - fetching all parents from the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        List<Student> fetchedParents = (List<Student>) session.createCriteria(Student.class).
                list();

        System.out.println("DEBUG: includeAll [" + includeAll + "]");
       

        return fetchedParents;
    }

    public Student fetch(Long userID) {
        System.out.println("Student: fetch");
        System.out.println("Student: START - fetching parent from the database by user ID");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Student fetchedUser = (Student) session.get(Student.class, userID);
        System.out.println("Student: END - fetching user from the database by user ID");
        //fetchedUser.addStock(stock);
        return fetchedUser;
    }


}
