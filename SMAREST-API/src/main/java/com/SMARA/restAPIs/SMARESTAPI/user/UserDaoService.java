package com.SMARA.restAPIs.SMARESTAPI.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//JPA/Hibernate -> Database
	// UserDaoService - > Static List
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Krutik", LocalDate.now().minusYears(30)));
		users.add(new User(2,"Eve", LocalDate.now().minusYears(25)));
		users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));
	}
	
	//public List<User> findAll()
	public List<User> findAll() {
		return users;
	}
	
	
	//public User findOne(int id)
	public User findUserbyId(int userId)
	{
		// Also can return but looping and finding
		Predicate<? super User> predicate  = user -> user.getId().equals(userId);
		return users.stream().filter(predicate).findFirst().get();
			
	}
	
	
}
