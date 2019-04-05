package net.scientifichooliganism.defaust;

import java.security.MessageDigest;
import java.util.Date;

public class Block {
	private final Block parent;
	private final String hash;
	private final String data;
	private final Date createdDate;

	public Block (Block in1, String in2) {
		if (in2 == null) {
			throw new IllegalArgumentException("");
		}

		if (in2.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		parent = in1;
		data = in2;
		createdDate = new Date();
		hash = generateHash();
	}

	public String generateHash () {
		String toHash = new String();
		StringBuffer hexString = new StringBuffer();

		if (parent != null) {
			toHash += parent.getHash();
		}

		toHash += Config.getDateFormat().format(createdDate);
		toHash += data;

		try {
			byte[] hash = MessageDigest.getInstance("MD5").digest(toHash.getBytes("UTF-8"));

			//TODO: I think this can be cleaned up a bit.
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);

				if (hex.length() == 1) {
					hexString.append('0');
				}

				hexString.append(hex);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

		return hexString.toString();
	}

	public boolean isChainValid () {
		boolean ret = false;

		if ((parent == null) || (parent.isChainValid())) {
			if (generateHash().equals(getHash())) {
				ret = true;
			}
		}

		return ret;
	}

	public Block getParent () {
		return parent;
	}

	public String getHash () {
		return hash;
	}

	public String getData () {
		return data;
	}

	public Date getCreatedDate () {
		return createdDate;
	}
}