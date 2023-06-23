package com.hex.backend.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.backend.Entity.Admin;
import com.hex.backend.Entity.User;
import com.hex.backend.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4202")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user")
    public List<User> listAllUsers() {
        List<User> l = service.findAll();
        return l;
    }

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> retrieveUserById(@PathVariable("id") String id) {
	     Object o = service.findByuserId(id);
	     return ResponseEntity.ok().body(o);
	}
	
	@GetMapping("/user/name/{name}")
	public ResponseEntity<Object> retrieveUserByName(@PathVariable("name") String name) {
	     Object o = service.findByuserName(name);
	     return ResponseEntity.ok().body(o);
	}
	
	@GetMapping("/user/addr/{addr}")
	public ResponseEntity<Object> retrieveUserByAddr(@PathVariable("addr") String addr) {
	     Object o = service.findByuserAddress(addr);
	     return ResponseEntity.ok().body(o);
	}
	
	@GetMapping("/user/phone/{phone}")
	public ResponseEntity<Object> retrieveUserByphone(@PathVariable("phone") long phone) {
	     Object o = service.findByuserPhone(phone);
	     return ResponseEntity.ok().body(o);
	}
	
	@PutMapping("/user/password/{password}/{id}")
    @Transactional
    public ResponseEntity<String> updatePassword(@PathVariable("password") String password, @PathVariable("id") String id) {
        String str = service.updatePassword(password, id);
        return ResponseEntity.ok().body(str);
    }
	
	@PutMapping("/user/phone/{phone}/{id}")
    @Transactional
    public ResponseEntity<String> updatePhone(@PathVariable("phone") long phone, @PathVariable("id")String id) {
        String str = service.updatePhone(phone, id);
        return ResponseEntity.ok().body(str);
    }
	
	@PutMapping("/user/email/{email}/{id}")
    @Transactional
    public ResponseEntity<String> updateMail(@PathVariable("email") String email, @PathVariable("id")String id) {
        String str = service.updateMail(email, id);
        return ResponseEntity.ok().body(str);
    }
	
	@PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User u = service.addUser(user);
        return ResponseEntity.ok().body(u);
    }
	
	@DeleteMapping("/user/delUser/{id}")
    @Transactional
    public ResponseEntity<String> removeuserById(@PathVariable("id") String id) {
        String str = service.deleteByUserId(id);
        return ResponseEntity.ok().body(str);
    }
}
