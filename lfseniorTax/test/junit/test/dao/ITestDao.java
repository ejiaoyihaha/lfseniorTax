package junit.test.dao;

import java.io.Serializable;

import junit.test.entity.Person;

public interface ITestDao {
	public void save(Person person);

	/**
	 * 查询Person
	 * @param id
	 * @return
	 */
	public Person findPeronById(Serializable id);
}
