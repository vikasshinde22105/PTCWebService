package com.demoapp.demo.model.stock;

import java.io.Serializable;

import javax.persistence.*;

import com.demoapp.demo.model.user.User;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@Table(name="stock")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stock_id", unique=true, nullable=false)
	private int stockId;

	@Column(name="stock_code", nullable=false, length=45)
	private String stockCode;

	@Column(name="stock_name", nullable=false, length=45)
	private String stockName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}