package com.profileService.profileRepo;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.profileService.model.Profile;
@Repository
public interface ProfileRepository extends MongoRepository<Profile, String>{

	Profile getByFullName(String fullName);

	Profile getByMobileNumber(long mobileNumber);

	Profile getByEmailId(String emailId);


}
