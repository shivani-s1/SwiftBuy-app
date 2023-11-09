package com.profileService.profileController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profileService.exception.AlreadyExistsException;
import com.profileService.exception.InvalidException;
import com.profileService.exception.ProfileNotFoundException;
import com.profileService.model.Profile;
import com.profileService.profileService.ProfileService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

	@Autowired
	private ProfileService service;
	
	@PostMapping("/save")
	public Profile addCustomerProfile(@RequestBody Profile profile) throws AlreadyExistsException {
		return service.save(profile);
		
	}
	
//	@GetMapping("/login/{emailId}/{password}")
//	public Profile login(@PathVariable String emailId, @PathVariable String password) throws InvalidException {
//		return service.login(emailId,password);
//
//	}
	
	
	
	@GetMapping("/getAll")
	public List<Profile> getAllProfile(){
		return service.findAllProfile();
	}
	
	@GetMapping("/getById/{id}")
	public Profile getByProfileId(@PathVariable String id) throws ProfileNotFoundException {
		return service.getById(id);
	}
	
	@GetMapping("/getByEmailId/{emailId}")
	public Profile getByEmailId(@PathVariable String emailId) {
		return service.getByEmailId(emailId);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Profile updateCustomer(@RequestBody Profile profile,@PathVariable String id) throws ProfileNotFoundException {
		return service.updateCustomer(profile,id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteProfile(@PathVariable String id) {
		return service.deleteProfile(id);
	}
	
	@GetMapping("/getByMobile/{mobileNumber}")
	public Profile getByMobileNumber(@PathVariable long mobileNumber) {
		return service.getByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/getByUserName/{fullName}")
	public Profile getByFullName(@PathVariable String fullName) {
		return service.getByFullName(fullName);
	}
	
	
	
}
