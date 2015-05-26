package com.demoapp.demo.model.user;

import java.io.Serializable;

import javax.persistence.*;

import com.demoapp.demo.model.stock.Stock;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="date_of_birth", nullable=false)
	private Integer  dateOfBirth;

	@Column(name="month_of_birth", nullable=false)
	private Integer  monthOfBirth;

	@Column(name="name_first", nullable=false, length=30)
	private String nameFirst;

	@Column(name="name_last", nullable=false, length=30)
	private String nameLast;

	@Column(name="name_middle", length=10)
	private String nameMiddle;

	@Column(nullable=false, length=64)
	private String password;

	@Column(name="updated_at", nullable=false)
	private Date updatedAt;

	@Column(name="user_status_code", nullable=false, length=1)
	private String userStatusCode;

 
	@Column(nullable=false, length=32)
	private String username;

	@Column(name="year_of_birth", nullable=false)
	private Integer  yearOfBirth;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Stock> stocks;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer  getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Integer  dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer  getMonthOfBirth() {
		return this.monthOfBirth;
	}

	public void setMonthOfBirth(Integer  monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameMiddle() {
		return this.nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserStatusCode() {
		return this.userStatusCode;
	}

	public void setUserStatusCode(String userStatusCode) {
		this.userStatusCode = userStatusCode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer  getYearOfBirth() {
		return this.yearOfBirth;
	}

	public void setYearOfBirth(Integer  yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setUser(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setUser(null);

		return stock;
	}
	 @Override
	    public String toString() {
	        return "User{" +
	                
	                ", nameFirst='" + nameFirst + '\'' +
	                ", nameMiddle='" + nameMiddle + '\'' +
	                ", nameLast='" + nameLast + '\'' +
	                ", username='" + username + '\'' +
	                ", password='" + password + '\'' +
	                ", userStatus=" + userStatusCode +
	                ", userStatusCode='" + userStatusCode + '\'' +
	                ", dateOfBirth=" + dateOfBirth +
	                ", monthOfBirth=" + monthOfBirth +
	                ", yearOfBirth=" + yearOfBirth +
	                ", createdAt=" + createdAt +
	                ", updatedAt=" + updatedAt +
	                ",stocks="+ stocks.toString()+
	                '}';
	    }

}