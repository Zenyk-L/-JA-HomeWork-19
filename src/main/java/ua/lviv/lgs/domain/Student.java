package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Integer age;

	@OneToOne(mappedBy = "student")
	private PhotoFile photoFile;

	public Student() {
	}
	
	public Student(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Student(String firstName, String lastName, Integer age, PhotoFile photoFile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.photoFile = photoFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public PhotoFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(PhotoFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", photoFile=" + photoFile + "]";
	}
	
	
}
