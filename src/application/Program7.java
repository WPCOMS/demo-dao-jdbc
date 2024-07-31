package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1 : new obj ====");
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		System.out.println("=== TEST 2 : new seller ====");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(seller);
		
		System.out.println("=== TEST 3 : new sellerDao ====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(sellerDao);
		
		System.out.println("=== TEST 4 : seller findById ====");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		
		System.out.println("\n=== TEST 5 : seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj5 : list) {
			System.out.println(obj5);
		}

		System.out.println("\n=== TEST 6 : seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj6 : list) {
			System.out.println(obj6);
		}
		
		System.out.println("\n=== TEST 7 : seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id =  " + newSeller);
		
		System.out.println("\n=== TEST 8 : seller update ====");
		seller = sellerDao.findById(2);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 9 : seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed ");
		
		sc.close();
	}

}
