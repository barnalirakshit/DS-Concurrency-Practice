package practice.custom.ds.test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practice.custom.ds.CustomHashMap;
import practice.custom.ds.CustomMap;

class CustomHashMapTestCase {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		CustomMap<String, Integer> map = new CustomHashMap<String, Integer>();
		map.put("A", 1);
		System.out.println(map.get("A"));
		map.put("B", 2);
		map.put("C", 3);
		map.put("A", 4);
		System.out.println(map.get("A"));
		map.put("D", 5);
		map.put("E", 6);
		System.out.println(map.get("E"));
		System.out.println(map.size());
	}

}
