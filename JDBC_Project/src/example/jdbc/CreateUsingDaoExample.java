package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class CreateUsingDaoExample {
	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer> daoRef = new RestaurantDao();
		Restaurant rst = new Restaurant(106, "Mainland China", "Chinese", 5);
		daoRef.create(rst);
	}


}
//public class DeleteUsingDaoExample {
//
//	public static void main(String[] args) {
//		DaoInterface<Restaurant, Integer> daoRef =
//				new RestaurantDao();
//		daoRef.delete(101);
//
//	}
//
//}
//public static void main(String[] args) {
//	DaoInterface<Restaurant, Integer> daoRef = new RestaurantDao();
//	Restaurant rst = new Restaurant(106, "Mainland China", "Chinese", 5);
//	daoRef.create(rst);
//
//}