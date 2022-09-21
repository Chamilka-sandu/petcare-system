package com.example.demo.Doctor;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "doctor_profiles")
public class DoctorProfile {

	@Id

	private long id;
	
	
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE ,mappedBy = "doctorProfile")
	private Doctor doctor;

	public DoctorProfile() {}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor (Doctor doctor) {
		this.doctor = doctor;
	}
	
}
