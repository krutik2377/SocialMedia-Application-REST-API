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
	
	private static int usersCount = 0;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(++usersCount ,"Krutik", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(20)));
	}
	
	//public List<User> findAll()
	public List<User> findAll() {
		return users;
		
	}
	
	public User save(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	//public User findOne(int id)
	public User findUserbyId(int userId)
	{
		// Also can return but looping and finding
		Predicate<? super User> predicate  = user -> user.getId().equals(userId);
		return users.stream().filter(predicate).findFirst().get();	
	}
	
	
}
