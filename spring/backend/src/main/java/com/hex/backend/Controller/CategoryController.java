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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.backend.Entity.Category;
import com.hex.backend.Service.CategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4202")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping("/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category cate) {
        Category c = service.addCategory(cate);
        return ResponseEntity.ok().body(c);
    }
	
	@GetMapping("/category")
	public List<Category> listAllCates(){
		List<Category> l=service.findAllCates();
		return l;
	}
	
	@GetMapping("/category/name/{name}")
	public ResponseEntity<Object> retrieveAdminByName(@PathVariable("name") String name) {
	     Object cate = service.findCatByName(name);
	     return ResponseEntity.ok().body(cate);
	}
	
	@DeleteMapping("/category/delCate/{name}")
    @Transactional
    public ResponseEntity<String> removeCateByName(@PathVariable("name") String name) {
        String str = service.deleteByCatName(name);
        return ResponseEntity.ok().body(str);
    }
}
