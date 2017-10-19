package junit.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import junit.test.dao.ITestDao;
import junit.test.entity.Person;
import junit.test.service.ITestService;
@Service("testService")
public class TestServiceImpl implements ITestService {
	@Resource()
	ITestDao testDao;
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("service sya hello");
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		testDao.save(person);
	}

	@Override
	public Person findPeronById(Serializable id) {
		// TODO Auto-generated method stub
		testDao.save(new Person("test"));
		return testDao.findPeronById(id);
	}

}
