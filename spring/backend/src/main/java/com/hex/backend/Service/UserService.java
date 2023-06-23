package com.hex.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.backend.Entity.User;
import com.hex.backend.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		List<User> l = repo.findAll();
		return l;
	}
	
	public Object findByuserId(String id) {
		User u = repo.findById(id).get();
		if(u!=null) {
			return u;
		}else {
			return "User not found";
		}
	}
	
	public Object findByuserName(String name) {
		Object u = repo.findByuserName(name);
		if(u!=null) {
			return u;
		}else {
			return "User not found";
		}
	}
	
	public Object findByuserAddress(String addr) {
		Object u = repo.findByuserAddress(addr);
		if(u!=null) {
			return u;
		}else {
			return "User not found";
		}
	}
	
	public Object findByuserPhone(long phone) {
		Object u = repo.findByuserPhone(phone);
		if(u!=null) {
			return u;
		}else {
			return "User not found";
		}
	}
	
	public String updatePassword(String pass,String id) 
    {
           String msg = "Unable to update password";
           int res = repo.updatePassword(pass, id);
           if (res > 0) 
           {
               msg = "Password updated";
           }
           return msg;
    }
	
	public String updatePhone(long phone,String id) 
    {
           String msg = "Unable to update phone number";
           int res = repo.updatePhone(phone, id);            
           if (res > 0) 
           {
               msg = "Phone number updated";
           }
           return msg;
    }
	 
	 public String updateMail(String mail,String id) 
    {
           String msg = "Unable to update admin mail";
           int res = repo.updateMail(mail, id);
           
           if (res > 0) 
           {
               msg = "User mail updated";
           }
           return msg;
    }
	 
	public User addUser(User user) {
		User u = repo.save(user);
		return u;
	}

	public String deleteByUserId(String id)
    {
        String str ="Unable to delete the user";
        int r=repo.deleteAdmin(id);
        if(r>0)
        {
            str="User with id: "+id+" deleted";
        }
        return str;
    }
}
