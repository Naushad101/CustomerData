package com.bnt.dao;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.bnt.model.Customer;



@Repository
public class CustomerRepository {

    @Autowired
    DataSource dataSource;

    public Customer saveCustomer(Customer customer){
        if(customer==null){
            throw new NullPointerException("Object is null");
        }
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer (id, name,city) VALUES (?, ?, ?)");
            statement.setInt(1, customer.getId());
            statement.setString(2,customer.getName()); 
            statement.setString(3,customer.getCity());
            statement.executeUpdate();
                statement.close();
                connection.close();
    
        }
        catch(Exception e){
            System.out.println("Empty Object");
        }
        return customer;
    }


    public Customer updateCustomer(int id,String newName){
        Customer cust = new Customer();
            try {
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET name=? WHERE id=?");
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();


                Connection connection1 = dataSource.getConnection();
                PreparedStatement preparedStatement1 = connection1.prepareStatement("SELECT * FROM customer WHERE id=?");
                preparedStatement1.setInt(1, id);
                ResultSet resultSet = preparedStatement1.executeQuery();
                while (resultSet.next()) {
                    int iD = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String city = resultSet.getString("city");
                    cust.setId(iD);
                    cust.setName(name);
                    cust.setCity(city);
                }
                resultSet.close();
                preparedStatement1.close();
                connection1.close();
                return cust;
            } catch (Exception e) {
                System.out.println("id is not present");
            }

          
            return cust;
    }


    public List<Customer> getCustomer(){
        List<Customer> res = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Customer customer = new Customer();
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                // customer.setId(id);
                // customer.setName(name);
                // customer.setCity(city);
                // res.add(customer);
                
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return res;
    }

    public void deleteCustomer(int id){
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Integer> getId(){
        List<Integer> ans = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT id FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                ans.add(id);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return ans;
    }

}
