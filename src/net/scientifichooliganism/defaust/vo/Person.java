package net.scientifichooliganism.defaust.vo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Person extends Entity {
	//height
	//weight
	//gender
	//handDominance
	//ocularDominance
	//skin color
	//eye color
	//hair color
	//religion

	public enum Handedness {
		//https://en.wikipedia.org/wiki/Handedness
		LEFT,
		RIGHT,
		AMBIDEXTROUS
	}

	public enum Eye {
		//https://en.wikipedia.org/wiki/Ocular_dominance
		LEFT,
		RIGHT,
		NEITHER
	}

	public enum Gender {
		MALE,
		FEMALE
	}

	public enum SkinColor {
		//https://en.wikipedia.org/wiki/Human_skin_color
		//https://en.wikipedia.org/wiki/Von_Luschan%27s_chromatic_scale
		WHITE,
		YELLOW,
		BROWN,
		BLACK
	}

	public enum EyeColor {
		//https://en.wikipedia.org/wiki/Eye_color#Eye_color_chart_(Martin_scale)
		AMBER,
		BLUE,
		BROWN,
		GRAY,
		GREEN
	}

	public enum HairColor {		
		//https://en.wikipedia.org/wiki/Human_hair_color#Natural_hair_colors
		//https://en.wikipedia.org/wiki/Fischer%E2%80%93Saller_scale
		WHITE,
		GRAY,
		LIGHT_BLOND,
		BLOND,
		DARK_BLOND,
		STRAWBERRY_BLOND,
		COPPER,
		RED,
		AUBURN,
		CHESTNUT,
		LIGHT_BROWN,
		BROWN,
		DARK_BROWN,
		BRUNETTE,
		BLACK
	}

	public Person () {
		super();
	}


	public Date getDateOfBirth () {
		return getDateOfCreation();
	}

	public void setDateOfBirth (String dateIn) {
		setDateOfCreation(dateIn);
	}

	public void setDateOfBirth (Date dateIn) {
		setDateOfCreation(dateIn);
	}
}