package ex.jdbc;

import example.jdbc.bean.Article;
import exaple.jdbc.dao.DaoInterface;
import exaple.jdbc.dao.articleDao;

public class CreateUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Article, Integer> daoRef =
				new articleDao();
		Article rst =
			new Article(104,"random", "painting", "2009-04-24", "Rohit");
		
		daoRef.create(rst);

	}

}
