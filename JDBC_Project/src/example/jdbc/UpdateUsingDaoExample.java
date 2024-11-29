package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class UpdateUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer> daoRef =
				new RestaurantDao();
		//Obtaining a Restaurant on which update is to be performed.
		Restaurant rst = daoRef.retrieveOne(104);
		//Changing the name and branch count using setters
		rst.setName("New Little Italy");
		rst.setBranchCount(20);
		//rst.setCuisine("Oriental");
		//Reflecting this changed state back to DB
		daoRef.update(rst);

	}

}
