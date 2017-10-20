package com.a.dao;

import java.sql.SQLException;


public interface CheckDao {
  
    public boolean isBookInfoId(int bookId) throws SQLException;
    public boolean isReadId(int readerId) throws SQLException;
    public boolean isTypeId(int typeId) throws SQLException;
    public boolean isBorrowForLib(int bookId) throws SQLException;
    public boolean isBorrowForReader(int readerId) throws SQLException;
  
    public boolean isReaderIsBook(int readerId) throws SQLException;
    
    
    public int bookLib(String isbn) throws SQLException;
    public int notBookLib(String isbn)throws SQLException;
}