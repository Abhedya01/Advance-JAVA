package ex.jdbc;

import java.util.Collection;

import example.jdbc.bean.Article;
import exaple.jdbc.dao.DaoInterface;
import exaple.jdbc.dao.articleDao;

public class RetrieveAllUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Article, Integer> daoRef = new articleDao();
		Collection<Article> allAvailableArticles = daoRef.retrieveAll();
		allAvailableArticles.stream().
		forEach(rst -> System.out.println(rst));
	}

}
