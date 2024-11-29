package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class RetrieveOneUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer> daoRef =
				new RestaurantDao();
		Restaurant restaurantObj = daoRef.retrieveOne(103);
		if(restaurantObj != null)
			System.out.println(restaurantObj);
		else
			System.out.println("Restaurant with given ID does not exist.");

	}

}
