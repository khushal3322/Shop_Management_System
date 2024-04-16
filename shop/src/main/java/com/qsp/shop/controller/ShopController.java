package com.qsp.shop.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class ShopController {
	public int addproduct(int id, String name, int price, int quantity, boolean avaibility,Date date) {
		// TODO Auto-generated method stub
		int Rowsaffected = 0;
		Connection connection = null;
		Driver driver = new Driver();
		try {
			DriverManager.registerDriver(driver);

			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");

			Properties properties = new Properties();

			properties.load(fileInputStream);

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program",
					properties);

			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO products VALUES(?,?,?,?,?,?)");

			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setInt(3, price);
			prepareStatement.setInt(4, quantity);
			prepareStatement.setBoolean(5, avaibility);
			prepareStatement.setDate(6, date); 

			Rowsaffected = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Rowsaffected;
	}
	
	
	
	

	
	public ResultSet fetchProduct(int id) {
		Connection connection = null;
		ResultSet resultSet=null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");

			Properties properties = new Properties();

			properties.load(fileInputStream);

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program",
					properties);

			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM products WHERE id=?");

			prepareStatement.setInt(1, id);
			 resultSet = prepareStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultSet;
	}
	
	
	
	
	
	
	public int removeProduct(int id) {
		Connection connection = null;
		int executeUpdate1=0;
		Driver driver = new Driver();
		try {
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");

			Properties properties = new Properties();

			properties.load(fileInputStream);

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program",
					properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM products WHERE id=?");

			prepareStatement.setInt(1, id);
			
			executeUpdate1 = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return executeUpdate1;
	}
	public void updateproduct(int id){
		
	}
}
