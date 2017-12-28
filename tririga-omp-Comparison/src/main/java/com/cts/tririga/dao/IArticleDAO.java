package com.cts.tririga.dao;
import java.util.List;

import com.cts.tririga.entity.Article;

public interface IArticleDAO {
    List<Article> getAll();
    Article getArticleByName(String articleName);
    /*void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);*/
    boolean articleExists(int om_pkg_id, String om_pkg_name);

}
 