package com.ptc.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the parent database table.
 * 
 */
@Entity
@Table(name="parent")
@NamedQuery(name="Parent.findAll", query="SELECT p FROM Parent p")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String address;

	private String name;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
//	private List<Student> students;
    @JsonManagedReference
	private Set<Student> students = 
			new HashSet<Student>(0);
	public Parent() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<Student> getStudents() {
//		return this.students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = (Set<Student>) students;
//	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setParent(this);

		return student;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setParent(null);

		return student;
	}

}