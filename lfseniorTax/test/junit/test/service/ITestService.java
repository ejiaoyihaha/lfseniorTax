package junit.test.service;

import java.io.Serializable;

import junit.test.entity.Person;

public interface ITestService {
	//输出
	public void say();
	
	public void save(Person person);
	
	public Person findPeronById(Serializable id);
}
