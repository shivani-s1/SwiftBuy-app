//package com.profileService.profileController;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.profileService.model.Profile;
//import com.profileService.profileService.AdminService;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//	
//	@Autowired
//	private AdminService service;
//	
//	@PostMapping("/save")
//	public Profile addAdminProfile(@RequestBody Profile profile) {
//		return service.save(profile);
//	}
//
//}
