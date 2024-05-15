package com.dambroski.clientManager.user;

import java.util.List;

public interface UserService {

	List<User> getAll();

	User post(User user);

	User put(User user, Long userId);

}
