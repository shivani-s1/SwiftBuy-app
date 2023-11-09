package com.profileService.profileService;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.profileService.client.MailClient;
import com.profileService.exception.AlreadyExistsException;
import com.profileService.exception.ProfileNotFoundException;
import com.profileService.model.Profile;
import com.profileService.profileRepo.ProfileRepository;
@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository repo;
	
	@Autowired
	private MailClient mailClient;
	
	@Override
	public Profile save(@PathVariable Profile profileEntity) throws AlreadyExistsException {
		if(repo.findById(profileEntity.getFullName()).isEmpty()) {
			Profile profile = new Profile();
			profile.setEmailId(profileEntity.getEmailId());
	        profile.setDateOfBirth(profileEntity.getDateOfBirth());
	        profile.setFullName(profileEntity.getFullName());
	        profile.setGender(profileEntity.getGender());
	        profile.setMobileNumber(profileEntity.getMobileNumber());
	        profile.setPassword(profileEntity.getPassword());
			profile.setRole(profileEntity.getRole());
			mailClient.sendEmail(profileEntity.getEmailId());
			return repo.save(profile);
			
		}
		else {
			throw new AlreadyExistsException("User with Similar username already exists");
		}
	}

	@Override
	public List<Profile> findAllProfile() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Profile getById(String id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Profile> findById = repo.findById(id);
		if(findById.isEmpty()) {
			throw new ProfileNotFoundException("Profile with given Id "+ id + " not found");
		}
		Profile profile = findById.get();
		return profile;
	}

	@Override
	public Profile updateCustomer(Profile profile, String id) throws ProfileNotFoundException{
		// TODO Auto-generated method stub
		  Optional<Profile> findById = repo.findById(id);
		  if(findById.isEmpty()) {
				throw new ProfileNotFoundException("Profile with given Id "+ id + " not found");
			}
		  Profile entity = findById.get();
		entity.setDateOfBirth(profile.getDateOfBirth());
		entity.setEmailId(profile.getEmailId());
		entity.setFullName(profile.getFullName());
		entity.setGender(profile.getGender());
		entity.setImage(profile.getImage());
		entity.setMobileNumber(profile.getMobileNumber());
		entity.setPassword(profile.getPassword());
		entity.setRole(profile.getRole());
		repo.save(entity);
		return entity;
	}

	@Override
	public String deleteProfile(String id) {
		// TODO Auto-generated method stub
		Optional<Profile> profile = repo.findById(id);
		if(profile.isPresent()) {
			repo.deleteById(id);
			return "profile deleted";
		}
		return "profile not deleted";
	}

//	@Override
//	public Profile getByMobileNumber(long mobileNumber) {
//		// TODO Auto-generated method stub
//		Profile profile = repo.getByMobileNumber(mobileNumber);
//		return profile;
//	}

	@Override
	public Profile getByFullName(String fullName) {
		// TODO Auto-generated method stub
		return repo.getByFullName(fullName);
	}

	@Override
	public Profile getByMobileNumber(long mobileNumber) {
		// TODO Auto-generated method stub
		Profile profile=repo.getByMobileNumber(mobileNumber);
		return profile;
	}

	@Override
	public Profile getByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Profile profile = repo.getByEmailId(emailId);
		return profile;
	}

//	@Override
//	public Profile login(String emailId, String password) throws InvalidException {
//		// TODO Auto-generated method stub
//		Profile profile = repo.getByEmailId(emailId);
//		return profile;
////		if(profile.isPresent() && profile.get().getPassword().equals(password)) {
////			return profile.get();
////		}
////		throw new InvalidException("Login details not found");
//	}

}
