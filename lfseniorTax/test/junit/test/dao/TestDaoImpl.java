package junit.test.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import junit.test.entity.Person;


public class TestDaoImpl extends HibernateDaoSupport implements ITestDao {
	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findPeronById(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
