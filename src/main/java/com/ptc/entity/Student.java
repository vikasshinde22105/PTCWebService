package com.ptc.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String name;

	//bi-directional many-to-one association to Parent
	@ManyToOne
    @JsonBackReference
	private Parent parent;

	public Student() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}