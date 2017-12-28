package com.cts.tririga.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.tririga.entity.Article;
import com.cts.tririga.entity.ArticleRowMapper;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public Article getArticleByName(String articleName) {
		String sql = "SELECT om_pkg_id,om_pkg_name FROM TRIDATA.OM_PKG_HEADER WHERE om_pkg_name = ?";
		RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		Article article = jdbcTemplate.queryForObject(sql, rowMapper, articleName);
		return article;
	}
	
	@Override
	public List<Article> getAll() {
		String sql = "SELECT om_pkg_id, om_pkg_name FROM TRIDATA.OM_PKG_HEADER";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Article> rowMapper = new ArticleRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	/*@Override
	public void addArticle(Article article) {
		//Add article
		String sql = "INSERT INTO articles (articleId, title, category) values (?, ?, ?)";
		jdbcTemplate.update(sql, article.getArticleId(), article.getTitle(), article.getCategory());
		
		//Fetch article id
		sql = "SELECT articleId FROM articles WHERE title = ? and category=?";
		int articleId = jdbcTemplate.queryForObject(sql, Integer.class, article.getTitle(), article.getCategory());
		
		//Set article id 
		article.setArticleId(articleId);
	}
	@Override
	public void updateArticle(Article article) {
		String sql = "UPDATE articles SET title=?, category=? WHERE articleId=?";
		jdbcTemplate.update(sql, article.getTitle(), article.getCategory(), article.getArticleId());
	}
	@Override
	public void deleteArticle(int articleId) {
		String sql = "DELETE FROM articles WHERE articleId=?";
		jdbcTemplate.update(sql, articleId);
	}*/
	@Override
	public boolean articleExists(int om_pkg_id, String om_pkg_name) {
		String sql = "SELECT count(*) FROM TRIDATA.OM_PKG_HEADER where om_pkg_id and om_pkg_name";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, om_pkg_id, om_pkg_name);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
}
