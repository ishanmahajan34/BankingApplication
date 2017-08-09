package com.cdk.dao;

import com.cdk.model.Bank;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Collection;

@Repository
public class BranchDao {

    Connection con = null;
    Statement stm = null;
    ResultSet rs = null;

    public Connection createDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useSSL=false", "root", "root");
        return con;
    }

    public  Statement createDatabaseStatement() throws SQLException {
        this.stm = this.con.createStatement();
        return stm;
    }


    public ResultSet executeQuery(String query) throws SQLException {
        this.rs = this.stm.executeQuery(query);
        return rs;
    }


    public void cleanUp() {
        try {
            if (this.rs != null) {
                this.rs.close();
                rs = null;
            }
            if (this.stm != null) {
                this.stm.close();
                stm = null;
            }
            if (this.con != null) {
                this.con.close();
                con = null;
            }
        } catch (SQLException e) {
        }
    }

    public Bank getBranchDetails(int branchId) {

        Bank bank = new Bank();
        try {
            createDatabaseConnection();
            createDatabaseStatement();
            executeQuery("select * from branch");
            while (rs.next()) {
                if (rs.getInt(1) == branchId) {
                    bank.setBranchId(rs.getInt(1));
                    bank.setBranchName(rs.getString(2));
                    bank.setBranchType(rs.getString(3));
                    bank.setBranchStrength(rs.getInt(4));
                    bank.setManagerId(rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }
        return bank;
    }

    public static void main(String[] args) {
        BranchDao bankDao = new BranchDao();
        Bank bank = bankDao.getBranchDetails(600);
        System.out.println(bank);
    }

}
