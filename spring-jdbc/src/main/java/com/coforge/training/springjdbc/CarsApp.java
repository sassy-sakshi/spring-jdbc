package com.coforge.training.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*Spring is a popular Java application framework for developing enterprise applications in Java. 
It is also a very good integration system that helps glue together various enterprise components.

JdbcTemplate is a library that helps programmers create applications that work with relational databases and JDBC. 
It handles many tedious and error-prone low-level details such as handling transactions, cleaning up resources, and correctly handling exceptions.

JdbcTemplate is shipped in Spring's spring-jdbc module.*/
//JDBC Template example using Java Configuration.
public class CarsApp 
{
    public static void main( String[] args )
    {
       DriverManagerDataSource  ds=new DriverManagerDataSource();
       ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
       ds.setUrl("jdbc:mysql://localhost:3306/springdb");
       ds.setUsername("root");
       ds.setPassword("7860596667St*");
       
       String sql= "select count(*) from cars";
       //Toll for simplifying programming with jdbc
       JdbcTemplate jtm = new JdbcTemplate(ds);
       //Execute query & return result Objct.
       int n=jtm.queryForObject(sql,Integer.class);
       
       System.out.println("Total Number of cars is:"+n);
       
    }
}
