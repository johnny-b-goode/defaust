package net.scientifichooliganism.defaust.vo;

public class Name {
	private int id;
	private int index;
	private String name;

	public Name () {
		this(-1, -1, new String());
	}

	public Name (int idIn, int indexIn, String nameIn) {
		id = idIn;
		index = indexIn;
		name = nameIn;
	}

	public int getId () {
		return id;
	}

	public void setId (int idIn) {
		if (idIn < 0) {
			throw new IllegalArgumentException("");
		}

		id = idIn;
	}


	public int getIndex () {
		return index;
	}

	public void setIndex (int indexIn) {
		if (indexIn < 0) {
			throw new IllegalArgumentException("");
		}

		index = indexIn;
	}


	public String getName () {
		return name;
	}

	public void setName (String nameIn) {
		if (nameIn.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		name = nameIn;
	}
}