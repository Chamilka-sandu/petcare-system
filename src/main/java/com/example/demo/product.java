package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class product {
	private Long id;
	private String name;
	private float price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private category category; 

	protected product() {
	}

	protected product(Long id, String name, float price,category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category=category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getcategory() {
		return price;
	}

	public void setcategory(category category) {
		this.category = category;
	}


}
