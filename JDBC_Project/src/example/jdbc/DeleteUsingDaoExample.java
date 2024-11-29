package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class DeleteUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer> daoRef =
				new RestaurantDao();
		daoRef.delete(101);

	}

}
