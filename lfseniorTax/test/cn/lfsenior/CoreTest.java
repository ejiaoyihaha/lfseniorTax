package cn.lfsenior;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.test.entity.Person;
import junit.test.service.ITestService;

public class CoreTest {
	private ClassPathXmlApplicationContext ac;
	@Before
	public void loadAc(){
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testSpring(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ITestService ts= (ITestService) ac.getBean("testService");
		ts.say();
	}
	@Test
	public void testHibernate(){
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session = sf.openSession();
		session.beginTransaction();
		/**
		 * 保存用户
		 */
		session.save(new Person("人员一"));
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testServiceDao(){
		ITestService ts=(ITestService) ac.getBean("testService");
		Person person=new Person("人员2");
//		ts.save(person);
		System.out.println(ts.findPeronById("ff8080815f2408e1015f2408e57f0000"));
	}
	
	@Test
	public void tsetTransationReadOnly(){
		ITestService ts=(ITestService) ac.getBean("testService");
		System.out.println(ts.findPeronById("ff8080815f2408e1015f2408e57f0000"));
	}
	
	@Test
	public void tsetRollBack(){
		ITestService ts=(ITestService) ac.getBean("testService");
		Person person=new Person("人员4");
		ts.save(person);
	}
}
