package ex.jdbc;

import example.jdbc.bean.Article;
import exaple.jdbc.dao.DaoInterface;
import exaple.jdbc.dao.articleDao;

public class DeleteUsingDao {

	public static void main(String[] args) {
		DaoInterface<Article, Integer> daoRef = new articleDao();
		daoRef.delete(101);

	}

}
