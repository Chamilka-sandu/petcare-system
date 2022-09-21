package com.example.demo.Doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Doctor.DoctorProfileRepositpry;
import com.example.demo.Doctor.DoctorRepository;
import com.example.demo.product.product;




@Controller
public class DoctorController {
	@Autowired
	private DoctorProfileRepositpry profileRepo;
	
	@Autowired
	private DoctorRepository docrepo;

	@GetMapping("/doctors")
	public String listDoctors(Model model) {
	List<Doctor> listDoctors=	docrepo.findAll();
	model.addAttribute("listDoctors ",listDoctors  );

	return "doctorlist";
	}

	@GetMapping("/new")
	public String showCreateNewdoctorList(Model model) {
	DoctorProfile doctorProfile = new DoctorProfile();

	model.addAttribute("doctor", new Doctor());
		model.addAttribute("doctorProfile", doctorProfile );
		
		return "doctor";
	}
	
	@PostMapping("/doctors/save")
	public String saveuser(DoctorProfile doctorProfile ) {
		profileRepo.save(doctorProfile);

	return "redirect:/doctorli";
	}
	
	@GetMapping("/doctors/new")
	public String showCreateNewdoc(Model model) {
	Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		
		return "Doctorsdetail";
	}
	@PostMapping("/doctorsd/save")
	public String savedoctor(Doctor doctorProfile ) {
		docrepo.save(doctorProfile);

	return "redirect:/doctorli";
	}
}
