package com.hex.backend.Controller;

import java.sql.Date;
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

import com.hex.backend.Entity.Article;
import com.hex.backend.Service.ArticleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4202")
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/art")
    public List<Article> listAllArticles() {
        List<Article> l = service.findAllArts();
        return l;
    }
	
	@GetMapping("/art/cate/{name}")
    public List<Article> listAllArticlesByCatName(String name) {
        List<Article> l = service.findByArtCatName(name);
        return l;
    }

	@GetMapping("/art/{id}")
	public ResponseEntity<Object> retrieveArticleById(@PathVariable("id") String id) {
	    Object a  = service.findByArtId(id);
	     return ResponseEntity.ok().body(a);
	}
	
	@GetMapping("/art/title/{title}")
	public ResponseEntity<Object> retrieveArticleByTitle(@PathVariable("title") String title) {
	    Object a  = service.findByArtTitle(title);
	     return ResponseEntity.ok().body(a);
	}
	
	@GetMapping("/art/date/{date}")
	public ResponseEntity<Object> retrieveArticleByDate(@PathVariable("date") Date date) {
	    Object a  = service.findByArtDate(date);
	     return ResponseEntity.ok().body(a);
	}
	
	@PutMapping("/art/title/{title}/{id}")
    @Transactional
    public ResponseEntity<String> updateTitle(@PathVariable("title") String title, @PathVariable("id") String id) {
        String str = service.updateTitle(title, id);
        return ResponseEntity.ok().body(str);
    }
	
	@PutMapping("/art/desc/{desc}/{id}")
    @Transactional
    public ResponseEntity<String> updateDescription(@PathVariable("desc") String desc, @PathVariable("id") String id) {
        String str = service.updateDesc(desc, id);
        return ResponseEntity.ok().body(str);
    }
	
	@PostMapping("/art")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        Article a = service.addArticle(article);
        return ResponseEntity.ok().body(a);
    }
	
	@DeleteMapping("/art/delArt/{id}")
    @Transactional
    public ResponseEntity<String> removeArticleById(@PathVariable("id") String id) {
        String str = service.deleteByArtId(id);
        return ResponseEntity.ok().body(str);
    }
}
