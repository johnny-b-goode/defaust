package net.scientifichooliganism.defaust.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public abstract class Entity {
	private List <Name> name;
	private Date dateOfCreation;
	private String summary;
	private String description;

	public Entity () {
		name = new Vector<Name>();
		dateOfCreation = new Date();
		summary = new String();
		description = new String();
	}


	public String getName () {
		String ret = new String();

		for (Name n : name) {
			if (n.getName().length() > 0) {
				ret += n.getName() + " ";
			}
		}

		return ret.trim();
	}

	public List getNames () {
		return name;
	}

	public void addName (String nameIn) {
		addName(new Name(name.size(), name.size(), nameIn));
	}

	public void addName (Name nameIn) {
		if (nameIn == null) {
			throw new IllegalArgumentException("");
		}

		if (name.contains(nameIn)) {
			throw new IllegalArgumentException("");
		}

		try {
			if (nameIn.getId() < 0) {
				int maxId = 0;

				for (Name n : name) {
					if (n.getId() > maxId) {
						maxId = n.getId();
					}
				}

				nameIn.setId(maxId + 1);
			}

			if (nameIn.getIndex() < 0) {
				nameIn.setIndex(name.size());
			}

			name.add(nameIn.getIndex(), nameIn);
		}
		catch (Exception e) {
			throw e;
		}
	}


	public Date getDateOfCreation () {
		return dateOfCreation;
	}

	public void setDateOfCreation (String dateIn) {
		if (dateIn == null) {
			throw new IllegalArgumentException("");
		}

		if (dateIn.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		try {
			setDateOfCreation(new SimpleDateFormat("yyyy-MM-dd").parse(dateIn));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDateOfCreation (Date dateIn) {
		if (dateIn == null) {
			throw new IllegalArgumentException("");
		}

		dateOfCreation = dateIn;
	}


	public String getSummary () {
		return summary;
	}

	public void setSummary (String summaryIn) {
		if (summaryIn == null) {
			throw new IllegalArgumentException("");
		}

		if (summaryIn.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		summary = summaryIn;
	}


	public String getDescription () {
		return description;
	}

	public void setDescription (String descriptionIn) {
		if (descriptionIn == null) {
			throw new IllegalArgumentException("");
		}

		if (descriptionIn.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		description = descriptionIn;
	}
}