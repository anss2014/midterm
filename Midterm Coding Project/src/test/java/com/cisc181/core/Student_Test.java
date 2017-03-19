package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.core.PersonException;

public class Student_Test
{
	static ArrayList<Course> courseList;
	static ArrayList<Semester> semesterList;
	static ArrayList<Section> sectionList;
	static ArrayList<Student> studentList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		courseList = new ArrayList<Course>();
		courseList.add(new Course(UUID.randomUUID(), "CISC181", 4));
		courseList.add(new Course(UUID.randomUUID(), "PHYS207", 4));
		courseList.add(new Course(UUID.randomUUID(), "MATH241", 4));

		semesterList = new ArrayList<Semester>();
		// Fall, Spring
		semesterList.add(new Semester(UUID.randomUUID(), new Date(0), new Date(1000)));
		semesterList.add(new Semester(UUID.randomUUID(), new Date(2000), new Date(3000)));

		sectionList = new ArrayList<Section>();
		// Fall - CISC, PHYS, MATH
		sectionList.add(new Section(courseList.get(0).getCourseID(),UUID.randomUUID(), 005));
		sectionList.add(new Section(courseList.get(1).getCourseID(),UUID.randomUUID(), 130));
		sectionList.add(new Section(courseList.get(2).getCourseID(),UUID.randomUUID(), 240));
		// Spring - CISC, PHYS, MATH
		sectionList.add(new Section(courseList.get(0).getCourseID(),UUID.randomUUID(), 005));
		sectionList.add(new Section(courseList.get(1).getCourseID(),UUID.randomUUID(), 135));
		sectionList.add(new Section(courseList.get(2).getCourseID(),UUID.randomUUID(), 245));

		studentList = new ArrayList<Student>();
		studentList.add(new Student("First", "Middle", "Last", new Date(0), eMajor.BUSINESS, "Address0", "(111)-111-1100", "Student0@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(1), eMajor.BUSINESS, "Address1", "(111)-111-1101", "Student1@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(2), eMajor.CHEM, "Address2", "(111)-111-1102", "Student2@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(3), eMajor.CHEM, "Address3", "(111)-111-1103", "Student3@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(4), eMajor.COMPSCI, "Address4", "(111)-111-1104", "Student4@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(5), eMajor.COMPSCI, "Address5", "(111)-111-1105", "Student5@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(6), eMajor.PHYSICS, "Address6", "(111)-111-1106", "Student6@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(7), eMajor.PHYSICS, "Address7", "(111)-111-1107", "Student7@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(8), eMajor.NURSING, "Address8", "(111)-111-1108", "Student8@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(9), eMajor.NURSING, "Address9", "(111)-111-1109", "Student9@udel.edu"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		courseList = null;
		semesterList = null;
		sectionList = null;
		studentList = null;
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testEnrollment()
	{
		ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
		ArrayList<Double> studentGPAList = new ArrayList<Double>();
		ArrayList<Double> sectionGPAList = new ArrayList<Double>();

		for (int i = 0; i < studentList.size(); i++)
		{
			Student stu = studentList.get(i);

			for (int k = 0; k < sectionList.size(); k++)
			{
				Section sect = sectionList.get(k);
				Enrollment e = new Enrollment(stu.getStudentID(), sect.getSectionID());
				e.setGrade((i * 10) + 5);
				enrollmentList.add(e);
			}
		}

		for (int i = 0; i < enrollmentList.size(); i += 6)
		{
			double GPA = 0;
			for (int k = 0; k < 6; k++)
			{
				int element = i + k;
				GPA = GPA + enrollmentList.get(element).getGrade();
			}
			GPA = GPA / 6;
			studentGPAList.add(GPA);
		}

		assertTrue(studentGPAList.get(0).doubleValue() == 5);
		assertTrue(studentGPAList.get(1).doubleValue() == 15);
		assertTrue(studentGPAList.get(2).doubleValue() == 25);
		assertTrue(studentGPAList.get(3).doubleValue() == 35);
		assertTrue(studentGPAList.get(4).doubleValue() == 45);
		assertTrue(studentGPAList.get(5).doubleValue() == 55);
		assertTrue(studentGPAList.get(6).doubleValue() == 65);
		assertTrue(studentGPAList.get(7).doubleValue() == 75);
		assertTrue(studentGPAList.get(8).doubleValue() == 85);
		assertTrue(studentGPAList.get(9).doubleValue() == 95);

		for (int i = 0; i < 6; i++)
		{
			double GPA = 0;
			for (int k = 0; k < enrollmentList.size(); k += 6)
			{
				int element = i + k;
				GPA = GPA + enrollmentList.get(element).getGrade();
			}
			GPA = GPA / 10;
			sectionGPAList.add(GPA);
		}

		assertTrue(sectionGPAList.get(0).doubleValue() == 50);
		assertTrue(sectionGPAList.get(1).doubleValue() == 50);
		assertTrue(sectionGPAList.get(2).doubleValue() == 50);
		assertTrue(sectionGPAList.get(3).doubleValue() == 50);
		assertTrue(sectionGPAList.get(4).doubleValue() == 50);
		assertTrue(sectionGPAList.get(5).doubleValue() == 50);
	}

	@Test
	public void testChangeMajor()
	{
		studentList.get(0).setMajor(eMajor.CHEM);
		assertEquals(studentList.get(0).getMajor(), eMajor.CHEM);
	}

}