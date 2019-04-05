package net.scientifichooliganism.defaust;

import net.scientifichooliganism.defaust.vo.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.*;

public class FileSystemStuffTest {
	String fileName = "Person.json";

	@Test
	public void test01 () {
		Person p = new Person();
		p.addName("Alfred");
		p.addName("Bob");
		p.addName("Charles");
		p.setDateOfBirth("1901-01-01");
		p.setSummary("a test person");
		p.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ipsum quam, suscipit at iaculis at, ullamcorper quis justo. Vestibulum sit amet nulla leo. Vestibulum rhoncus, lorem vitae efficitur pellentesque, nunc sem varius lorem, et sagittis turpis lectus eu nisl. Sed sollicitudin vitae purus nec sagittis. Aenean non iaculis justo. In in quam velit. Curabitur at mattis est, vehicula porttitor risus. Nunc fermentum orci velit, vitae sollicitudin enim egestas vitae. Proin pretium tellus nibh, eget venenatis tortor imperdiet in. Sed placerat elit ut sodales sodales. Maecenas vitae molestie ligula. Aenean congue turpis non massa mollis molestie. Praesent porta tempus vehicula. Mauris non dolor luctus, tempus ante nec, dapibus massa.\n\nNunc gravida efficitur ante eget ultrices. Nunc vitae arcu vel turpis viverra sollicitudin. Maecenas facilisis tellus ut rutrum sollicitudin. Cras euismod ultrices ante. Pellentesque bibendum arcu mi, at dignissim ligula faucibus et. Aliquam erat volutpat. Mauris tristique mattis urna quis consequat.");
		FileSystemStuff.writeObject(p);
	}

	@Test
	public void test02 () {
		Person p = (Person) FileSystemStuff.readObject(Person.class, fileName);
		Assert.assertEquals("Alfred Bob Charles", p.getName());
		Assert.assertEquals("Tue Jan 01 00:00:00 CST 1901", p.getDateOfBirth().toString());
	}
}