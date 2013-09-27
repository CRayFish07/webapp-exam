package edisonbetter.webexam.infra.test;

import org.junit.BeforeClass;

public class TestBase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("spring.profiles.active", "hsqldb");
	}

}
