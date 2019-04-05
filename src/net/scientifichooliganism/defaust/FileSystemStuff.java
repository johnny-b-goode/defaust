package net.scientifichooliganism.defaust;

import net.scientifichooliganism.defaust.vo.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;

public class FileSystemStuff {
	public static Object readObject (String fileName) {
		Object ret = null;

		try {
			ret = readObject(Class.forName(fileName.substring(0, fileName.indexOf("."))), fileName);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

		return ret;
	}

	public static Object readObject (Class c, String fileName) {
		Object ret = null;
		File file = null;
		BufferedReader br = null;

		try {
			file = new File(fileName);

			if(file == null) {
                throw new IOException("");
			}

            if(! file.exists()) {
                throw new IOException("");
			}

			if (! file.isFile()) {
				throw new IOException("");
			}

			br = new BufferedReader(new FileReader(file));
			Gson gson = new GsonBuilder().setDateFormat(Config.getDateFormat().toPattern()).setPrettyPrinting().create();
			ret = gson.fromJson(br, c);
		}
		catch (Exception exc) {
            exc.printStackTrace();
		}
		finally {
			try {
				br.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}

		return ret;
	}

	public static void writeObject (Object obj) {
		writeObject(obj, obj.getClass().getSimpleName().concat(".json"));
	}

	public static void writeObject (Object obj, String fileName) {
		if (obj == null) {
			throw new IllegalArgumentException("");
		}

		if (fileName == null) {
			throw new IllegalArgumentException("");
		}

		if (fileName.isEmpty()) {
			throw new IllegalArgumentException("");
		}

		File file = null;
		BufferedWriter bw = null;

		try {
			file = new File(fileName);

			if(file == null) {
                throw new IOException("");
			}

			if(! file.exists()){
				file.createNewFile();
			}

			if (! file.isFile()) {
				throw new IOException("");
			}

			bw = new BufferedWriter(new FileWriter(file));
//			Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonAdapter()).setDateFormat("yyyy-MM-dd").create();
			Gson gson = new GsonBuilder().setDateFormat(Config.getDateFormat().toPattern()).setPrettyPrinting().create();
			gson.toJson(obj, bw);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
        	try {
				bw.flush();
				bw.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
}