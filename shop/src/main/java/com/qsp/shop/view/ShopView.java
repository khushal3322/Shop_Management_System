package com.qsp.shop.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.qsp.shop.controller.ShopController;
import com.qsp.shop.model.Product;

public class ShopView {
	static Scanner myInput = new Scanner(System.in);
	Product product = new Product();
	static ShopController shopController = new ShopController();

	public static void main(String[] args) throws SQLException {
		do {
			System.out.println("Select operation to perfrom: ");
			System.out.println("1.Add product\n2.Remove product\n3.Update product details\n4.Fetch product\n0.Exit");
			System.out.print("Enter digit respective to desired option: ");
			int userInput = myInput.nextInt();
			myInput.nextLine();
			switch (userInput) {
			case 0:
				myInput.close();
				System.out.println("----------------------------EXITED----------------------------");
				System.exit(0);

				break;
			case 1:
				System.out.println("How many product \n1.Single product \n2.multiple product");
				int productCount = myInput.nextInt();
				if (productCount == 1) {
					System.out.println("Enter product id: ");
					int i_p_d = myInput.nextInt(); // i_p_id--- input p id
					myInput.nextLine();
					System.out.println("Enter product name: ");
					String i_p_name = myInput.nextLine();
					System.out.println("Enter price: ");
					int i_p_price = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter quantity: ");
					int i_p_quantity = myInput.nextInt();
					myInput.nextLine();
					boolean i_p_availability = false;
					if (i_p_quantity > 0) {
						i_p_availability = true;
					}
					System.out.println("Enter date in yyyy-mm-dd format");
					String i_p_date = myInput.nextLine();
					
					Date date = Date.valueOf(i_p_date);
					
					
					if ((shopController.addproduct(i_p_d, i_p_name, i_p_price, i_p_quantity, i_p_availability, date)) != 0) {
						System.out.println("Product added");
						System.out.println();
					} else {
						System.out.println("Product not added");
						System.out.println();
					}

				}
				else{
					boolean toCoutinue=true;
				ArrayList<Product> products = new ArrayList();

				do {
					Product product = new Product();
					System.out.println("Enter id :");
					product.setP_id(myInput.nextInt());
					myInput.nextLine();
					System.out.println("Enter name :");
					product.setP_name(myInput.nextLine());
					System.out.println("Enter price :");
					product.setP_price(myInput.nextInt());
					//1
					
					System.out.println("Enter quantity :");
					int quantity =myInput.nextInt();							//      WHY
					product.setP_qauntity(quantity);
					myInput.nextLine();
					
					boolean i_p_availability=false;
					if (quantity>0) {
						i_p_availability=true;
					}
					product.setP_availability(i_p_availability);
				products.add(product);
				System.out.println("Product Added");
				System.out.println("press 1 to countinue add product else press 0 to stop");
				int toAdd=myInput.nextInt();
				if (toAdd==0) {
					toCoutinue=false;
				}
				} while (toCoutinue);
			}
//				
//				

				break;
			case 2:
				
				//
				System.out.println("Enter product id to remove");
				int producttoremove=myInput.nextInt();
				myInput.nextLine();
				
				if (shopController.removeProduct(producttoremove)!=0) {
					System.out.println("ha deleted");
				} else {
					System.out.println("not exeist id deleted");
				} 
				
				break;
			case 3:
				//
				System.out.println("Enter product id to Update");
				int producttoupdate=myInput.nextInt();
				myInput.nextLine();
				ResultSet Product=shopController.fetchProduct(producttoupdate);
				 
				if (Product.next()) {
					System.out.println("");
				} else {
					System.out.println("Product with given id does not exist");
				}
				break;
			case 4:
				//4
				System.out.println("Enter product id to fetch");
				int producttofind=myInput.nextInt();
				myInput.nextLine();
				ResultSet fetchProduct=shopController.fetchProduct(producttofind);
				boolean next = fetchProduct.next();
				if (next) {
					System.out.println("PRODUCT DETAILS :");
					System.out.println("id : "+fetchProduct.getInt(1));
					System.out.println("id : "+fetchProduct.getString(2));
					System.out.println("id : "+fetchProduct.getInt(3));
					System.out.println("id : "+fetchProduct.getInt(4));
					if (fetchProduct.getBoolean(5)) {
						System.out.println("avaiblitity : Avaiable");
					} else {
						System.out.println("avaiblitity :  not Avaiable");
					}
				} else {
					System.out.println("product id : "+producttofind+"does not exist.");
					System.out.println();
				}
				break;

			default:
				System.out.println("--------------------------INVALID SECTION----------------------------");
				break;
			}
		} while (true);
	}

	
	
	
}
