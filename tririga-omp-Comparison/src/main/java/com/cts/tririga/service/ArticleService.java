package com.cts.tririga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.tririga.dao.IArticleDAO;
import com.cts.tririga.entity.Article;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	@Override
	public Article getArticleByName(String articleId) {
		Article obj = articleDAO.getArticleByName(articleId);
		return obj;
	}	
	
		
	@Override
	public List<Article> getAll(){
		return articleDAO.getAll();
	}
	/*@Override
	public synchronized boolean addArticle(Article article){
       if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
    	   return false;
       } else {
    	   articleDAO.addArticle(article);
    	   return true;
       }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}*/
	
}
