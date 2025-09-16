package com.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.service.JavakartImpl;

public class Test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		JavakartImpl kart = new JavakartImpl();
		while(true) {
            System.out.println("\nWELCOME TO JAVAKART");
            System.out.println("Choose your service:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Details");
            System.out.println("3. Delete Product");
            System.out.println("4. See Product");
            System.out.println("5. Exit");
            int ch = s.nextInt();
            s.nextLine();

            switch (ch) {
                case 1: {
                    try {
						kart.addProduct();
					} catch (SQLException e) {
						e.printStackTrace();
					}
                    break;
                }

                case 2: {
                    System.out.println("What do you want to update?");
                    System.out.println("1. Product id");
                    System.out.println("2. Product name");
                    System.out.println("3. Product Price");
                    System.out.println("4. Exit");
                    int ch1 = s.nextInt();
                    s.nextLine();

                    switch (ch1) {
                        case 1: {
                            try {
								kart.updateProductId();
							} catch (SQLException e) {
								e.printStackTrace();
							}
                            System.out.println("Product id updated successfully!");
                            break;
                        }
                        case 2: {
                        	try {
								kart.updateProductName();
							} catch (SQLException e) {
								e.printStackTrace();
							}
                            System.out.println("Product name updated successfully!");
                            break;
                        }
                        case 3: {
                        	try {
								kart.updateProductPrice();
							} catch (SQLException e) {
								e.printStackTrace();
							}
                            System.out.println("Product price updated successfully!");
                            break;
                        }
                        case 4: {
                            break;
                        }
                        default: {
                            System.out.println("Wrong entry...choose correct");
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                	try {
                		kart.deleteProduct();
					} catch (SQLException e) {
						e.printStackTrace();
					}
                    System.out.println("Product deleted successfully!");
                    break;
                }

                case 4: {
                    System.out.println("Options to show products:");
                    System.out.println("1. All products");
                    System.out.println("2. Single product");
                    int show = s.nextInt();
                    s.nextLine();

                    if (show == 1) {
                    	try {
							kart.displayAllProduct();
						} catch (SQLException e) {
							e.printStackTrace();
						}
                    } else if (show == 2) {
                    	try {
							kart.displayOneProduct();
						} catch (SQLException e) {
							e.printStackTrace();
						}
                    }
                    break;
                }

                case 5: {
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Wrong entry...choose correct");
                    break;
                }
            }
        }


	}

}
