package com.todo.webApplication.todo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<user> Users = new ArrayList<user>();
	private Integer idCounter=3;
	static {
		Users.add(new user(1,"ppmaster","PP","master",new Date(),"kkbit233@gmail.com"));
		Users.add(new user(2,"kkmishra","kk","mishra",new Date(),"kkmishra233@yahoo.com"));
		Users.add(new user(3,"rkmishra","rk","mishra",new Date(),"kkwritesomething@gmail.com"));
	}

	public user findById(int id){
		for(user user:Users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public List<user> findAll(){
		return Users;
	}
	public user save(user user) {
		if(user.getId()==null) {
			user.setId(++idCounter);
		}
		Users.add(user);
		return user;
	}
	
	public user deleteById(int id) {
		Iterator<user> iterator = Users.iterator();
		while(iterator.hasNext()) {
			user user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;	
	}
}
