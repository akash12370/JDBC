package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.dbconnection.DbConnect;

public class JavakartImpl implements JavaKart{

	Scanner s = new Scanner(System.in);
	Connection con;
	
	@Override
	public void addProduct() throws SQLException{
		String insertData = "insert into javakart values (?,?,?)";
		con = DbConnect.getDbConnection();
        PreparedStatement ps = con.prepareStatement(insertData);

        System.out.println("Enter product id:");
        ps.setInt(1, s.nextInt());
        s.nextLine();

        System.out.println("Enter product name:");
        ps.setString(2, s.nextLine());

        System.out.println("Enter product price:");
        ps.setInt(3, s.nextInt());
        s.nextLine();

        ps.execute();
        ps.close();
        System.out.println("Product added successfully!");
	}

	@Override
	public void deleteProduct() throws SQLException{
		 String deleteData = "delete from javakart where productid = ?";
		 con = DbConnect.getDbConnection();
         PreparedStatement ps = con.prepareStatement(deleteData);
         System.out.println("Enter product id of product which you want to delete:");
         ps.setInt(1, s.nextInt());
         ps.execute();
         ps.close();
	}

	@Override
	public void updateProductId() throws SQLException {
		String updateId = "update javakart set productid=? where productid=?";
		con = DbConnect.getDbConnection();
		PreparedStatement ps = con.prepareStatement(updateId);
		System.out.println("Enter old id:");
		ps.setInt(2, s.nextInt());
		System.out.println("Enter new id:");
		ps.setInt(1, s.nextInt());
		ps.execute();
		ps.close();
	}

	@Override
	public void updateProductName() throws SQLException{
		String updateName = "update javakart set productname=? where productname=?";
		con = DbConnect.getDbConnection();
		PreparedStatement ps = con.prepareStatement(updateName);
		System.out.println("Enter old name:");
		ps.setString(2, s.nextLine()+s.next());
		System.out.println("Enter new name:");
		ps.setString(1, s.nextLine()+s.next());
		ps.execute();
		ps.close();
	}

	@Override
	public void updateProductPrice() throws SQLException{
		String updatePrice = "update javakart set productprice=? where productprice=?";
		con = DbConnect.getDbConnection();
		PreparedStatement ps = con.prepareStatement(updatePrice);
		System.out.println("Enter old price:");
		ps.setInt(2, s.nextInt());
		System.out.println("Enter new price:");
		ps.setInt(1, s.nextInt());
		ps.execute();
		ps.close();	
	}

	@Override
	public void displayAllProduct() throws SQLException{
		String displayAllData = "select * from javakart";
		con = DbConnect.getDbConnection();
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery(displayAllData);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Price: " + rs.getInt(3));
            System.out.println("-------------------------");
        }
        smt.close();
	}

	@Override
	public void displayOneProduct() throws SQLException{
		String displayOneData = "select * from javakart where productid=?";
		con = DbConnect.getDbConnection();
        PreparedStatement ps = con.prepareStatement(displayOneData);
        System.out.println("Enter product id:");
        ps.setInt(1, s.nextInt());
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Price: " + rs.getInt(3));
        } else {
            System.out.println("No product found!");
        }
        ps.close();
		
	}

}
