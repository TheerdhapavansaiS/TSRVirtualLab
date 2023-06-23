package com.hex.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.backend.Entity.Admin;
import com.hex.backend.Repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public List<Admin> findAll() 
	{
		List<Admin> a = adminRepo.findAll();
		return a;
	}
	
	public Object findByAdminId(String id) 
	{
		Admin a = adminRepo.findById(id).get();
		if(a!=null) {
			return a;
		}else {
			return "Admin not found!!";
		}
	}
	
	public Object findByAdminMail(String mail) 
	{
		Admin a = adminRepo.findByAdminMail(mail);
		if(a!=null) {
			return a;
		}else {
			return "Admin not found!!";
		}
		
	}
	
	public Admin[] findByAdminName(String name) 
	{
		Admin[] a = adminRepo.findByAdminName(name);
		return a;
	}

	public Object findByAdminPhone(long phone) 
	{
		Admin a = adminRepo.findByAdminPhone(phone);
		if(a!=null) {
			return a;
		}else {
			return "Admin not found!!";
		}
	}

	 public String updatePassword(String pass,String id) 
     {
            String msg = "Unable to update password";
            int res = adminRepo.updatePassword(pass, id);
            if (res > 0) 
            {
                msg = "Password updated";
            }
            return msg;
     }
	 
	 public String updatePhone(long phone,String id) 
     {
            String msg = "Unable to update phone number";
            int res = adminRepo.updatePhone(phone, id);            
            if (res > 0) 
            {
                msg = "Phone number updated";
            }
            return msg;
     }
	 
	 public String updateMail(String mail,String id) 
     {
            String msg = "Unable to update admin mail";
            int res = adminRepo.updateMail(mail, id);
            
            if (res > 0) 
            {
                msg = "Admin mail updated";
            }
            return msg;
     }
	 
	 public Admin addAdmin(Admin admin)
	    {
	       
	       Admin a=adminRepo.save(admin);
	    
	        return a;
	    }
	 
	 public String deleteByAdminId(String id)
	    {
	        String str ="Unable to delete the admin";
	        int r=adminRepo.deleteAdmin(id);
	        if(r>0)
	        {
	            str="Admin with id: "+id+" deleted";
	        }
	        return str;
	    }
}
