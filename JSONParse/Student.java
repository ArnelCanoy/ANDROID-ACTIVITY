package com.example.jsonparse;

public class Student {

	String idno,familyname,givenname,course,yearlevel,campus;

	public Student(String idno, String familyname, String givenname,
			String course, String yearlevel, String campus) {
		super();
		this.idno = idno;
		this.familyname = familyname;
		this.givenname = givenname;
		this.course = course;
		this.yearlevel = yearlevel;
		this.campus = campus;
	}
	public Student(){}
	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getGivenname() {
		return givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYearlevel() {
		return yearlevel;
	}

	public void setYearlevel(String yearlevel) {
		this.yearlevel = yearlevel;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}
	
}
