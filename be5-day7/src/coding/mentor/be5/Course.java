package coding.mentor.be5;

import java.util.Date; 
import java.util.ArrayList;

public class Course {
	private String name;
	private Date begin;
	private Date end;
	private double fee;
	private ArrayList<Mentor> mentors;
	
	public Course(String name, Date beginDate, Date endDate, ArrayList<Mentor> mentors, boolean isRegistered, double fee) {
		this.name = name;
		this.begin = beginDate;
		this.end = endDate;
		this.mentors = mentors;
		this.fee = fee;
	}
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBegin() {
		return begin;
	}



	public void setBegin(Date begin) {
		this.begin = begin;
	}



	public Date getEnd() {
		return end;
	}



	public void setEnd(Date end) {
		this.end = end;
	}



	public double getFee() {
		return fee;
	}



	public void setFee(double fee) {
		this.fee = fee;
	}



	public ArrayList<Mentor> getMentors() {
		return mentors;
	}



	public void setMentors(ArrayList<Mentor> mentors) {
		this.mentors = mentors;
	}
	
	
	public ArrayList<Mentor> findCourseMentors() {
		return this.getMentors();
	}
}
