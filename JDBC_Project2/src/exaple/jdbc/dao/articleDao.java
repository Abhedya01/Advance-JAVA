package exaple.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import example.jdbc.bean.Article;
import example.jdbc.utils.jdbcUtils;

public class articleDao<arti> implements DaoInterface<Article, Integer> {
	public Collection <Article> retrieveAll() {
		
		Collection<Article> allArticles = new ArrayList<>();
		String sqlQuery = 	"select * from article_master";
		try(
				//Opening the resources using try-with-resources so that they get
				//closed automatically
				Connection conn = jdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)
				){
				while(rs.next()) {
					//Fetching record values from ResultSet
					int id = rs.getInt(1);
					String articleName = rs.getString(2);
					String articleCategory = rs.getString(3);
					String articleDate = rs.getString(4);
					String creatorName = rs.getString(5);
					
					Article rst = new Article(id, articleName, articleCategory, articleDate, creatorName);
					
					allArticles.add(rst);
				}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allArticles;
	}

	@Override
	public void create(Article newArticle) {
		String sqlQuery = "insert into article_master values(?, ?, ?, ?, ?)";
		try (
			Connection conn = jdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
		){
			int id = newArticle.getId();
			String articleName = newArticle.getCreatorName();
			String articleCategory = newArticle.getCategory();
			String articleDate = newArticle.getDataCreated();
			String creatorName = newArticle.getName();
			//Substituting these values in place of '?' using PreparedStatement
			pstmt.setInt(1, id);
			pstmt.setString(2,articleName);
			pstmt.setString(3, articleCategory);
			pstmt.setString(4, articleDate);
			pstmt.setString(5, creatorName);
			
			
		}catch(Exception ex){
			ex.getStackTrace();	
		}
	}
	
	public void delete(Integer id) {
		String sqlQuery = "delete from article_master where id = ?";
		try(Connection conn = jdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			){
			pstmt.setInt(1, id);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + "deleted Account");
			
		}catch(Exception ex) {
			ex.getStackTrace();
		}
	}

	@Override
	public Article retrieveOne(Integer key) {
		Article foundArticle = null;
		String sqlQuery = "Select * from article_master where id = ?";
		try(
				Connection conn = jdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
		){
			pstmt.setInt(1, key);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				int id = rst.getInt(1);
				String articleName = rst.getString(2);
				String articleCategory = rst.getString(3);
				String articleDate = rst.getString(4);
				String creatorName = rst.getString(5);
				//Building Java object (Restaurant) based upon these values
				foundArticle =new Article(id, articleName, articleCategory, articleDate, creatorName);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundArticle;
	}

	@Override
	public void update(Article modifiedArticle) {
		/* This method receives the modified state of the Restaurant
		object: modifiedRestaurant and reflects that state into DB.
		*/
		
		String sqlQuery = "update article_master set id = ?, name = ?, category =?, dataCreated =?, creatorName =?";
		try(
				Connection conn = jdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
				){
			//Capturing the modified state of Restaurant object:modifiedRestaurant
			//using getter methods
			int id = modifiedArticle.getId();
			String articleName = modifiedArticle.getCreatorName();
			String articleCategory = modifiedArticle.getCategory();
			String articleDate = modifiedArticle.getDataCreated();
			String creatorName = modifiedArticle.getName();
			
			//Substituting these values in place of '?' using PreparedStatement
			pstmt.setInt(1, id);
			pstmt.setString(2,articleName);
			pstmt.setString(3, articleCategory);
			pstmt.setString(4, articleDate);
			pstmt.setString(5, creatorName);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + "record updated");
			
			
		}catch(Exception ex) {
			
		}
		
	}	
}