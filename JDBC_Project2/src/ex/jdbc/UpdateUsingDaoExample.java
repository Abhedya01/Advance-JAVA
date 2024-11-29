package ex.jdbc;

import example.jdbc.bean.Article;
import exaple.jdbc.dao.DaoInterface;
import exaple.jdbc.dao.articleDao;

public class UpdateUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Article, Integer> daoRef = new articleDao();
		Article rst = daoRef.retrieveOne(104);
		rst.setName("hellooo Welcome");
		rst.setCreatorName("swami");

	}

}
