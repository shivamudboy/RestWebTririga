package com.cts.tririga.service;

import java.util.List;

import com.cts.tririga.entity.Article;


public interface IArticleService {
     List<Article> getAll();
     Article getArticleByName(String articleId);
     /*boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);*/
}
