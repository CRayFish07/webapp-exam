package edisonbetter.webexam.domain.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edisonbetter.webexam.domain.model.Exam;
import edisonbetter.webexam.infra.dao.DataAccessObject;

public class TestDomainEntity {
	private DataAccessObject<Exam> dao;
	
	@Before
	public void setUp() throws Exception {
		dao = (DataAccessObject<Exam>) new ClassPathXmlApplicationContext("infra.xml").getBean("defaultDAO");
		dao.setEntity(Exam.class);
	}

	@Test
	public void test() {
		Exam exam = new Exam();
		exam.setName("abc");
		dao.create(exam);
	}

}
