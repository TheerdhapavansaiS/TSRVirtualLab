package com.hex.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.backend.Entity.Category;
import com.hex.backend.Repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Object findCatByName(String name) {
		Category c = repo.findBycatName(name);
		if(c!=null) {
			return c;
		}else {
			return "Category not found!!";
		}	
	}
	
	public List<Category> findAllCates(){
		List<Category> l = repo.findAll();
		return l;
	}
	
	public Category addCategory(Category cat) {
		Category c = repo.save(cat);
		return c;
	}
	
	public String deleteByCatName(String name)
    {
        String str ="Unable to delete the category";
        int r=repo.deleteCategory(name);
        if(r>0)
        {
            str="Category "+name+" deleted ";
        }
        return str;
    }

}
