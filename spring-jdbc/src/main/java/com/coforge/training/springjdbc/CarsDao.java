package com.coforge.training.springjdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarsDao {
	  //tool for simplying programming with jdbc in springframework.
      private JdbcTemplate jtm;

	public JdbcTemplate getJtm() {
		return jtm;
	}
	
	
      
	public void setJtm(JdbcTemplate jtm) {
		this.jtm = jtm;
	}



	/*
    *
    * For executing a query that select all rows from the table and returns a
    * list of domain model class objects,
    * you can use the BeanPropertyRowMapper class greatly simplifies the code
    */
	public List<Cars> getAllCars(){
		String sql = "select * from Cars";
		List<Cars> listcars=jtm.query(sql,BeanPropertyRowMapper.newInstance(Cars.class));
		return listcars;
	}
	
	public Cars findCarById(int CarId){
		String sql = "select * from Cars where id ="+CarId;
		Cars Car=jtm.queryForObject(sql,BeanPropertyRowMapper.newInstance(Cars.class));
		return Car;
	}
	
	public int saveCar(Cars c) {
		String qry ="insert into cars(name,price) values('"+c.getName()+"','"+c.getPrice()+"')";
		return jtm.update(qry);
	}
	public void countCars() {
		String sql = "select count(*) from Cars";
		int n=jtm.queryForObject(sql,Integer.class);
		System.out.println("Total number of cars:"+n);
	}
	
	public int updateCar(Cars c)
    {
        String qry="update cars set price='"+c.getPrice()+"' where id='"+c.getId()+"'";
        return jtm.update(qry);
    }
   
    public int deleteCar(Cars c)
    {
        String qry= "delete from cars where id='"+c.getId()+"'";
        return jtm.update(qry);
    }
      
      
}
