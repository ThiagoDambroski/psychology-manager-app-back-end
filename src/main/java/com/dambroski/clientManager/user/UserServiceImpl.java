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
		user.setLimitTimeOfSession("22:00");
		user.setLimitDurationOfSession("02:00");;
		user.setNumberOfClientsPerPage(10);
		user.setNumberOfPagamentsPerPage(10);
		user.setNumberOfSessionsPerPage(10);
		user.setNumberOfPagamentsPerMonthPage(10);
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
			oldUser.setPassword(user.getPassword());
			
		}
		if(Objects.nonNull(user.getLimitTimeOfSession())) {
			oldUser.setLimitTimeOfSession(user.getLimitTimeOfSession());
			
		}
		
		if(Objects.nonNull(user.getLimitDurationOfSession())) {
			oldUser.setLimitDurationOfSession(user.getLimitDurationOfSession());
		}
		
		if(Objects.nonNull(user.getNumberOfClientsPerPage())) {
			oldUser.setNumberOfClientsPerPage(user.getNumberOfClientsPerPage());
			
		}
		
		if(Objects.nonNull(user.getNumberOfPagamentsPerPage())) {
			oldUser.setNumberOfPagamentsPerPage(user.getNumberOfPagamentsPerPage());
			
		}
		
		if(Objects.nonNull(user.getNumberOfSessionsPerPage())) {
			oldUser.setNumberOfSessionsPerPage(user.getNumberOfSessionsPerPage());
		}
		
		if(Objects.nonNull(user.getNumberOfPagamentsPerMonthPage())) {
			oldUser.setNumberOfPagamentsPerMonthPage(user.getNumberOfPagamentsPerMonthPage());
		}
		
		
		return repository.save(oldUser);
	}

}
