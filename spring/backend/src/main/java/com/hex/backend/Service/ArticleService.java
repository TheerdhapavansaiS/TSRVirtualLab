package com.hex.backend.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.backend.Entity.Article;
import com.hex.backend.Repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository repo;
	
	public List<Article> findAllArts(){
		List<Article> l = repo.findAll();
		return l;
	}

	public List<Article> findByArtCatName(String name) 
	{
		List<Article> o = repo.findByArtCatName(name);
		return o;	
	}
	
	public Object findByArtId(String id) {
		Object a = repo.findById(id).get();
		if(a!=null) {
			return a;
		}else {
			return "Article not found!!";
		}
	}		
	
	public Object findByArtTitle(String title) 
	{
		Object a = repo.findByArtTitle(title);
		if(a!=null) {
			return a;
		}else {
			return "Article not found!!";
		}
	}
	
	public Object findByArtDate(Date date) {
		Object a = repo.findByArtDate(date);
		if(a!=null) {
			return a;
		}else {
			return "Article not found!!!";
		}
	}
	
	public Article addArticle(Article art) {
		Article a = repo.save(art);
		return a;
	}
	
	 public String updateTitle(String title,String id) 
     {
            String msg = "Unable to update article title";
            int res = repo.updateArtTitle(title, id);
            
            if (res > 0) 
            {
                msg = "Article title updated";
            }
            return msg;
     }
	 
	 public String updateDesc(String desc,String id) 
     {
            String msg = "Unable to update article description";
            int res = repo.updateArtDescription(desc, id);
            
            if (res > 0) 
            {
                msg = "Article description updated";
            }
            return msg;
     }
	 
	 public String deleteByArtId(String id)
	    {
	        String str ="Unable to delete the article";
	        int r=repo.deleteArticle(id);
	        if(r>0)
	        {
	            str="Article with id: "+id+" deleted";
	        }
	        return str;
	    }
}
