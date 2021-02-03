/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author saemundur
 */
public class CycleEntryTest {

	public CycleEntryTest() {
	}

	@BeforeAll
	public static void setUpClass() {
	}

	@AfterAll
	public static void tearDownClass() {
	}

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	/**
	 * Test of getName method, of class CycleEntry.
	 */
	@Test
	public void testGetName() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		String expResult = "Alice";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getDay method, of class CycleEntry.
	 */
	@Test
	public void testGetDay() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "gravel", "moderate");
		int expResult = 1;
		int result = instance.getDay();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMonth method, of class CycleEntry.
	 */
	@Test
	public void testGetMonth() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "mountain", "fast");
		int expResult = 2;
		int result = instance.getMonth();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getYear method, of class CycleEntry.
	 */
	@Test
	public void testGetYear() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "gravel", "slow");
		int expResult = 2003;
		int result = instance.getYear();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getHour method, of class CycleEntry.
	 */
	@Test
	public void testGetHour() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "fast");
		int expResult = 0;
		int result = instance.getHour();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMin method, of class CycleEntry.
	 */
	@Test
	public void testGetMin() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		int expResult = 16;
		int result = instance.getMin();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getSec method, of class CycleEntry.
	 */
	@Test
	public void testGetSec() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		int expResult = 7;
		int result = instance.getSec();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getDistance method, of class CycleEntry.
	 */
	@Test
	public void testGetDistance() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		float expResult = 3.0F;
		float result = instance.getDistance();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTerrain method, of class CycleEntry.
	 */
	@Test
	public void testGetTerrain() {
		CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		String expResult = "asphalt";
		String result = instance.getTerrain();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTempo method, of class CycleEntry.
	 */
	@Test
	public void testGetTempo() {
		CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		String expResult = "moderate";
		String result = instance.getTempo();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getEntry method, of class CycleEntry.
	 */
	@Test
	public void testGetEntry() {
		Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003. Terrain: asphalt, Tempo: moderate\n";
		String result = instance.getEntry();
		assertEquals(expResult, result);
	}

}