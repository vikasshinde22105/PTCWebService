package com.demoapp.demo.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoapp.demo.model.user.User;
import com.ptc.dao.service.ParentDaoService;
import com.ptc.entity.Parent;
import com.ptc.entity.Student;

@Controller
@RequestMapping("/parents")
public class UserLogin {

	@Autowired 
	ParentDaoService userManager ;
	


	 @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	    public List<Parent> fetchAllUsers(@RequestParam(value = "include_all", required = false) boolean includeAll) {
	        return userManager.fetchAll(includeAll);
	    }
	 
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	    @ResponseBody
	    public Parent fetchUser(@PathVariable Long id) {
	        return userManager.fetch(id);
	    }

		 @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
		 @ResponseBody
		    public List<Student> fetchAllStudents(@RequestParam(value = "include_all", required = false) boolean includeAll) {
		        return userManager.fetchAllStudent(includeAll);
		    }
		 
		    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
		    @ResponseBody
		    public Student fetchStudent(@PathVariable Long id) {
		        return userManager.fetchStudent(id);
		    }

}
