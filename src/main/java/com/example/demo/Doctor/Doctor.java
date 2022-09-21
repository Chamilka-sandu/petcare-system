package com.example.demo.Doctor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "up_id")
	private DoctorProfile doctorProfile ;
	
	public Doctor() {
		
	}

	public Doctor(String name, String email, DoctorProfile doctorProfile) {
		super();
		this.name = name;
		this.email = email;
		this.doctorProfile = doctorProfile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DoctorProfile getDoctorProfile() {
		return doctorProfile;
	}

	public void setDoctorProfile(DoctorProfile doctorProfile) {
		this.doctorProfile = doctorProfile;
	}
	
	
	
	
}
