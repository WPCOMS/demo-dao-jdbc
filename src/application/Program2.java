package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		System.out.println("=== TEST 1 : new obj ====");
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		System.out.println("=== TEST 2 : new seller ====");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(seller);
		
		System.out.println("=== TEST 3 : new sellerDao ====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(sellerDao);
		
		System.out.println("=== TEST 4 : seller findbyId ====");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		

	}

}
