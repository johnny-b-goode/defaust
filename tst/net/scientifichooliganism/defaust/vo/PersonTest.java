package net.scientifichooliganism.defaust.vo;

import net.scientifichooliganism.defaust.PersonAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

		Assert.assertEquals("{\"name\":[{\"id\":0,\"index\":0,\"name\":\"Alfred\"},{\"id\":1,\"index\":1,\"name\":\"Bob\"},{\"id\":2,\"index\":2,\"name\":\"Charles\"}],\"dateOfBirth\":\"1901-01-01\",\"summary\":\"\",\"description\":\"\"}", new GsonBuilder().registerTypeAdapter(Person.class, new PersonAdapter()).setDateFormat("yyyy-MM-dd").create().toJson(p));
	}
}