package com.cts.tririga.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONObject;

import com.cts.tririga.entity.Article;
import com.cts.tririga.service.IArticleService;

@Controller
@RequestMapping("OMP")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	
	@RequestMapping(
		    value = "getOMP", 
		    method = RequestMethod.POST)
	public ResponseEntity<Article> getArticleByName(@RequestBody String Name) {
		final JSONObject obj = new JSONObject(Name);
		String pkg_name=obj.getString("om_pkg_name");
		System.out.println(Name);
		System.out.println(pkg_name);
		Article article = articleService.getArticleByName(pkg_name);		
		return new ResponseEntity<Article>(article, HttpStatus.OK);
		
	}
	@GetMapping("All")
	public ResponseEntity<List<Article>> getAll() {
		List<Article> list = articleService.getAll();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	/*@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/	
} 