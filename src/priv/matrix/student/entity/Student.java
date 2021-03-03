package priv.matrix.student.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	private SimpleStringProperty id = new SimpleStringProperty("");
	private SimpleStringProperty sname = new SimpleStringProperty("");
	private SimpleStringProperty gender = new SimpleStringProperty("");
	private SimpleStringProperty address = new SimpleStringProperty("");
	private SimpleStringProperty mobile = new SimpleStringProperty("");
	private SimpleStringProperty dorm = new SimpleStringProperty("");
	private SimpleDoubleProperty credit = new SimpleDoubleProperty();
	
	public Student() {}
	
	public Student(String id, String sname, String gender, String address, String moblie, String dorm, double credit)
	{
		this.setId(id);
		this.setSname(sname);
		this.setGender(gender);
		this.setAddress(address);
		this.setMobile(moblie);
		this.setDorm(dorm);
		this.setCredit(credit);
	}
	
	public String getId() {
		return id.get();
	}
	
	public SimpleStringProperty idProperty()
	{
		return id;
	}
	
	public void setId(String id) {
		this.id.set(id);
	}
	
	public String getSname() {
		return sname.get();
	}
	
	public SimpleStringProperty snameProperty()
	{
		return sname;
	}

	public void setSname(String sname) {
		this.sname.set(sname);
	}
	
	public String getGender() {
		return gender.get();
	}
	
	public SimpleStringProperty genderProperty()
	{
		return gender;
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}
	
	public String getAddress() {
		return address.get();
	}
	
	public SimpleStringProperty addressProperty()
	{
		return address;
	}

	public void setAddress(String address) {
		this.address.set(address);
	}
	
	public String getDorm() {
		return dorm.get();
	}
	
	public SimpleStringProperty dormProperty()
	{
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm.set(dorm);
	}
	
	public double getCredit() {
		return credit.get();
	}
	
	public SimpleDoubleProperty creditProperty()
	{
		return credit;
	}

	public void setCredit(double credit) {
		this.credit.set(credit);
	}

	public String getMobile() {
		return mobile.get();
	}

	public SimpleStringProperty mobileProperty()
	{
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile.set(mobile);
	}
	
}
