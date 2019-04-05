package net.scientifichooliganism.defaust;

import net.scientifichooliganism.defaust.vo.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.*;

public class BlockTest {
	@Test
	public void test01 () {
		Block block0 = new Block(null, "First!");
		System.out.println("Block 0: " + block0.getHash());

		Block block1 = new Block(block0, "Second is the best.");
		System.out.println("Block1: " + block1.getHash());

		Block block2 = new Block(block1, "Third is the one...");
		System.out.println("Block2: " + block2.getHash());

		Assert.assertTrue(block2.isChainValid());
	}
}