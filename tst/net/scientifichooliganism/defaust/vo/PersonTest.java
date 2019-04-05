package net.scientifichooliganism.defaust.vo;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.*;

public class PersonTest {
	@Test
	public void test01 () {
		Person p = new Person();
		p.addName("Alfred");
		p.addName("Bob");
		p.addName("Charles");
		p.setDateOfBirth("1901-01-01");
		p.setSummary("a test person");

		Assert.assertEquals("Alfred Bob Charles", p.getName());
		Assert.assertEquals("Tue Jan 01 00:00:00 CST 1901", p.getDateOfBirth().toString());
	}
}