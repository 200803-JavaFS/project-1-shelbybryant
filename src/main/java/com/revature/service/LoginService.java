package com.revature.service;





import com.revature.daos.UserDAO;
import com.revature.models.User;

public class LoginService {

	public UserDAO uDao = new UserDAO();
	public UserService us = new UserService();
	
	public boolean login(User user) {
		try {
			
			
			
			
			if(user != null) {
				String username = user.getUsername();
				String password = user.getPassword();
				
				System.out.println("REQUEST USER: " + user);
				User u = uDao.getByUsername(username);
				System.out.println("\n\nFetched User: " + u);
				
//				StringBuilder sb = new StringBuilder();
//				sb.append(password.hashCode());
//				String hashedPassword = sb.toString();
				
				if (password.equals(u.getPassword())) {
					return true;
				} else {
					System.out.println("Wrong password");
					
				}
			}
			
			
			
		} catch (NullPointerException e) {
			System.out.println("The user does not exist");
			e.printStackTrace();
		}
		return false;
		
	}
	
}

/*







*/