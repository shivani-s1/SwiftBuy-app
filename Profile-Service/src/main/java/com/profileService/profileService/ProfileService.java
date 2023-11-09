package com.profileService.profileService;

import java.util.List;

import com.profileService.exception.AlreadyExistsException;
import com.profileService.exception.InvalidException;
import com.profileService.exception.ProfileNotFoundException;
import com.profileService.model.Profile;

public interface ProfileService {

	Profile save(Profile profile) throws AlreadyExistsException;

	List<Profile> findAllProfile();

	Profile getById(String id) throws ProfileNotFoundException;

	Profile updateCustomer(Profile profile, String id) throws ProfileNotFoundException;

	String deleteProfile(String id) ;

	Profile getByMobileNumber(long mobileNumber);

	Profile getByFullName(String fullName);

	Profile getByEmailId(String emailId);


}
