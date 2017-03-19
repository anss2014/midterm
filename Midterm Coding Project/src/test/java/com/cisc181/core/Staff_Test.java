package com.cisc181.core;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import com.cisc181.core.PersonException;

public class Staff_Test {
	
	public static ArrayList<Staff> testStaff;

	@BeforeClass
	public static void setup() {
		testStaff = new ArrayList<Staff>(5);
		Calendar cal = Calendar.getInstance();
		Date dob = null;
		Date hired = null;
		Staff staff = null;
		
		cal.set(1996, Calendar.JANUARY, 0, 1, 2, 5);
		dob = cal.getTime();
		cal.set(2017, Calendar.MARCH, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("ZiChen", "NONE", "Zhou", dob, "1 easton court", "(302)-509-1680","anss@udel.edu", "Monday 1:00 to 2:00pm", 1, 100000, hired, eTitle.MR);
		testStaff.add(staff);
		
		cal.set(1996, Calendar.JANUARY, 0, 1, 2, 5);
		dob = cal.getTime();
		cal.set(2017, Calendar.MARCH, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("AAA", "BBB", "CCC", dob, "1 EASTON COURT", "(302)-111-1111","AAAAAA@udel.edu", "Tuesday 1:00 to 2:00pm", 1, 200000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(1996, Calendar.JANUARY, 0, 1, 2, 5);
		dob = cal.getTime();
		cal.set(2017, Calendar.MARCH, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("AAAA", "BBBA", "CCCA", dob, "1 EASTON COURT", "(302)-111-1111","AAAAAA@udel.edu", "Tuesday 1:00 to 2:00pm", 1, 200000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(1996, Calendar.JANUARY, 0, 1, 2, 5);
		dob = cal.getTime();
		cal.set(2017, Calendar.MARCH, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("AAAAA", "BBBAA", "CCCAA", dob, "1 EASTON COURT", "(302)-111-1111","AAAAAA@udel.edu", "Tuesday 1:00 to 2:00pm", 1, 200000, hired, eTitle.MS);
		testStaff.add(staff);
		
		cal.set(1996, Calendar.JANUARY, 0, 1, 2, 5);
		dob = cal.getTime();
		cal.set(2017, Calendar.MARCH, 1, 0, 0, 0);
		hired = cal.getTime();
		staff = new Staff("AAAAAA", "BBBAAA", "CCCAAA", dob, "1 EASTON COURT", "(302)-111-1111","AAAAAA@udel.edu", "Tuesday 1:00 to 2:00pm", 1, 200000, hired, eTitle.MS);
		testStaff.add(staff);
	}

	@Test
	public void testStaffCount() {
		assertEquals(testStaff.size(), 5);
	}
	
	@Test
	public void testAverageSalary() {
		double sum = 0.0;
		int number = 0;
		for (Staff s : testStaff) {
			number++;
			sum += s.getSalary();
		}
		assertEquals(sum / (double) number, 300000.0, 1);
	}
	

	@Test(expected = PersonException.class)
	public void dobExceptionTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(2016,  Calendar.JANUARY, 1);
		Date dob = cal.getTime();
		Staff staff = new Staff("ZiChen", "NONE", "Zhou", dob, "1 easton court", "(302)-509-1680","anss@udel.edu", "Monday 1:00 to 2:00pm", 1, 100000, dob, eTitle.MR);
	}
	

	@Test(expected = PersonException.class)
	public void phoneNumberExceptionTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(2016,  Calendar.JANUARY, 1);
		Date dob = cal.getTime();
		Staff staff = new Staff("ZiChen", "NONE", "Zhou", dob, "1 easton court", "(302)-509-1680","anss@udel.edu", "Monday 1:00 to 2:00pm", 1, 100000, dob, eTitle.MR);
	}
}