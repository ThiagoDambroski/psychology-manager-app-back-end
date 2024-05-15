package com.dambroski.clientManager.user;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.clientManager.erros.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public User post(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User put(User user, Long userId) {
		
		User oldUser = repository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found"));
		
		if(Objects.nonNull(user.getName())) {
			oldUser.setName(user.getName());
		}
		
		if(Objects.nonNull(user.getPassword())) {
			oldUser.setName(user.getPassword());
		}
		
		return repository.save(oldUser);
	}

}
