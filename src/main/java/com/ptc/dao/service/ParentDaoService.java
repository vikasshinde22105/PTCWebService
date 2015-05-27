package com.ptc.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demoapp.demo.model.user.User;
import com.ptc.dao.student.ParentDao;
import com.ptc.dao.student.StudentDao;
import com.ptc.entity.Parent;
import com.ptc.entity.Student;

@Component
public class ParentDaoService {

	@Autowired
	StudentDao studentdao;

	@Autowired
	ParentDao parentdao;
    public List<Parent> fetchAll(boolean includeAll) {
        System.out.println("ParentDeo: fetchAll");
        List<Parent> fetchedParents = parentdao.fetchAll(includeAll);
        return fetchedParents;
    }
    
    public Parent fetch(Long userID) {
        System.out.println("ParentDeo: fetch");
        Parent fetchedUser = parentdao.fetch(userID);
        return fetchedUser;
    }
    public List<Student> fetchAllStudent(boolean includeAll) {
        System.out.println("studenttDeo: fetchAll");
        List<Student> fetchedStudents = studentdao.fetchAll(includeAll);
        return fetchedStudents;
    }
    
    public Student fetchStudent(Long userID) {
        System.out.println("StudentDeo: fetch");
        Student fetchedUser = studentdao.fetch(userID);
        return fetchedUser;
    }
}
