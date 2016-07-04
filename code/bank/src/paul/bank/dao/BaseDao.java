package paul.bank.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * add t to database
	 * @param T 
	 * */
	String add(T t);
	
	/**
	 * find the specific t from the database
	 * @param T the one to be found
	 * @return T the found one
	 * 
	 * */
	T find(String id);
	
	/**
	 * find all Ts from the database
	 * @return the list containing Ts
	 * */
	List<T> findAll();
}
