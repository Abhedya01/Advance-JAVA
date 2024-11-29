package ex.jdbc;

import example.jdbc.bean.Article;
import exaple.jdbc.dao.DaoInterface;
import exaple.jdbc.dao.articleDao;

public class RetrieveOneUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Article, Integer> daoRef = new articleDao();
		Article articleObj = daoRef.retrieveOne(103);
		if(articleObj != null) {
			System.out.println(articleObj);
		}else {
			System.out.println("Article with given ID does not exist.");
		}

	}

}