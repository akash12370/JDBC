package com.service;

import java.sql.SQLException;

public interface JavaKart {
	void addProduct() throws SQLException;
	void deleteProduct() throws SQLException;
	void updateProductId() throws SQLException;
	void updateProductName() throws SQLException;
	void updateProductPrice() throws SQLException;
	void displayAllProduct() throws SQLException;
	void displayOneProduct() throws SQLException;
}
