package dlithe.internship.CampusConnect;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@Entity
public class Candidates implements Serializable
{
	@Id
	@Digits(fraction=0,integer=12)
	private Long regno;
	@Digits(fraction=0,integer=12)
	private Long mobile;
	@Pattern(regexp="[^0-9]*")
	private String name;
	@NotNull
	private String department;
	@NotNull
	private String skills;
	@NotNull
	private String certifications;
	@NotNull
	private String career;
	@Nullable
	private String status;
	@NotNull
	private String email;
	private Double cgpa,hsc,diploma,sslc;
	public Long getRegno() {
		return regno;
	}
	public void setRegno(Long regno) {
		this.regno = regno;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public Double getHsc() {
		return hsc;
	}
	public void setHsc(Double hsc) {
		this.hsc = hsc;
	}
	public Double getDiploma() {
		return diploma;
	}
	public void setDiploma(Double diploma) {
		this.diploma = diploma;
	}
	public Double getSslc() {
		return sslc;
	}
	public void setSslc(Double sslc) {
		this.sslc = sslc;
	}
	public Candidates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidates(Long regno, Long mobile, String name, String department, String skills, String certifications,
			String career, String status, String email, Double cgpa, Double hsc, Double diploma, Double sslc) {
		super();
		this.regno = regno;
		this.mobile = mobile;
		this.name = name;
		this.department = department;
		this.skills = skills;
		this.certifications = certifications;
		this.career = career;
		this.status = status;
		this.email = email;
		this.cgpa = cgpa;
		this.hsc = hsc;
		this.diploma = diploma;
		this.sslc = sslc;
	}
	@Override
	public String toString() {
		return "Candidates [regno=" + regno + ", mobile=" + mobile + ", name=" + name + ", department=" + department
				+ ", skills=" + skills + ", certifications=" + certifications + ", career=" + career + ", status="
				+ status + ", email=" + email + ", cgpa=" + cgpa + ", hsc=" + hsc + ", diploma=" + diploma + ", sslc="
				+ sslc + "]";
	}
}
