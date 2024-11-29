package exaple.jdbc.dao;

import java.util.Collection;

import example.jdbc.bean.Article;

public interface DaoInterface<T, K> {
	Collection<T>retrieveAll();

	void create(T t);
	
	void delete(K key);
	
	T retrieveOne(K key);
	
	void update(T t);
}
