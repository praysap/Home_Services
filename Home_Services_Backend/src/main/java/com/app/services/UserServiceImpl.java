package com.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.IFeedbackRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Feedback;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private IFeedbackRepository feedbackRepo;

	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}
	
	//public Address processAddress(Address address,long id) {
		
	//	return userRepo.save(address);
	//}
	
	@Override
	public User authenticateUser(String email, String pass) {
		
		Optional<User> optional = userRepo.findByEmailAndPassword(email, pass);
		
		return optional.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials"));
		//return optional or if error is present go in custom exception package and give message
	}

	@Override
	public User getUser(long custid) {
		
		return userRepo.findById(custid).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
	}

	@Override
	public User updateUser(User user, long custid) {
		user.setId(custid);
		userRepo.findById(custid).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		
		return userRepo.save(user);
	}

	@Override
	public Feedback addNewFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

}
