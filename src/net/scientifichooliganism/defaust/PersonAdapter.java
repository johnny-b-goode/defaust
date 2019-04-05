package net.scientifichooliganism.defaust;

import net.scientifichooliganism.defaust.vo.Person;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;
//import java.text.SimpleDateFormat;

public class PersonAdapter implements JsonDeserializer<Person>, JsonSerializer<Person> {
	@Override
	public Person deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		Person person = new Person();
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonElement element;

		if((element = jsonObject.get("dateOfBirth")) != null){
			person.setDateOfBirth(element.getAsString());
		}

		return person;
	}

	@Override
	public JsonElement serialize(Person person, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject jsonObject = new JsonObject();

		//if(person.getDateOfBirth() != null){
		//	jsonObject.addProperty("dateOfBirth", Config.getDateFormat().format(person.getDateOfBirth()));
		//}
		jsonObject.add("dateOfBirth", jsonSerializationContext.serialize(Config.getDateFormat().format(person.getDateOfBirth())));

		return jsonObject;
	}
}