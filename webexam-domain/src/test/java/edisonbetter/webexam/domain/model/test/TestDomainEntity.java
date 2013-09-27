package edisonbetter.webexam.domain.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edisonbetter.webexam.domain.model.Exam;
import edisonbetter.webexam.infra.dao.DataAccessObject;
import edisonbetter.webexam.infra.test.TestBase;

public class TestDomainEntity extends TestBase{
	private DataAccessObject<Exam> dao;
	
	@Before
	public void setUp() throws Exception {
		dao = (DataAccessObject<Exam>) new ClassPathXmlApplicationContext("infra.xml").getBean("defaultDAO");
		dao.setEntity(Exam.class);
	}

	@Test
	public void test() {
		Exam exam1 = new Exam();
		exam1.setName("abc");
		
		Exam exam2 = new Exam();
		exam2.setName("efg");
		
		dao.create(exam1);
		dao.create(exam2);
	}

}
