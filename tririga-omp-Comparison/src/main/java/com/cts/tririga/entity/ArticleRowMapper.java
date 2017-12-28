package com.cts.tririga.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleRowMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet row, int rowNum) throws SQLException {
		Article article = new Article();
		article.setOm_pkg_id(row.getInt("om_pkg_id"));
		article.setOm_pkg_name(row.getString("om_pkg_name"));
		
		return article;
	}

}
