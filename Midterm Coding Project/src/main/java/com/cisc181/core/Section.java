package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	private Section() {
		this.SectionID = UUID.randomUUID();
	}
	

	public Section(UUID courseID, UUID semesterID) {
		this();
		this.CourseID = courseID;
		this.SemesterID = semesterID;
	}


	public Section(UUID courseID, UUID semesterID, int roomID) {
		this();
		this.CourseID = courseID;
		this.SemesterID = semesterID;
		this.RoomID = roomID;
	}
	
	//return CourseID
	public UUID getCourseID() {
		return this.CourseID;
	}


	public UUID getSemesterID() {
		return this.SemesterID;
	}

	//return section ID
	public UUID getSectionID() {
		return this.SectionID;
	}

	public int getRoomID() {
		return this.RoomID;
	}


	public void setRoomID(int roomID) {
		this.RoomID = roomID;
	}
}