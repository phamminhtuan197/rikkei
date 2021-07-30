package com.rikkei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Entity			//đánh dấu class này là 1 entity để thao tác với database sử dụng entity này
@Table(name = "Account", catalog = "TestingSystem")  //mapping với bảng Account trong DB tên là TestingSystem
public class Account implements Serializable {   // Serializable class là cơ chế chuyển đổi trạng thái của đối tượng thành chuỗi byte để trao đổi dữ liệu

	private static final long serialVersionUID = 1L;  // ghi nhớ phiên bản của Serializable class  
	
	@Column(name = "AccountID")   //kết nối với cột AccountID trong bảng Account của DB
	@Id   // xác định đây là cột primary key trong DB
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // tự động tăng
	private short accountID;
	
	@Column(name = "Email", length = 50, nullable = false, unique = true)  // mapping với côt email, độ dài kí tự là 50, không null, không trùng
	private String email;
	
	@Column(name = "Username", length = 50, nullable = false, unique = true)  // tương tự trên
	private String userName;
	
	@Column(name = "FullName", length = 50, nullable = false)     //tương tự trên
	private String fullName;
	
	@ManyToOne(fetch = FetchType.LAZY)      //thể hiện mối quan hệ 1 department có nhiều account
	@JoinColumn(name = "DepartmentID", nullable = false)   // định nghĩa cột foreign key trong bảng Account, tức là trường department này nối với cột departmentID trong bảng Account của db
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)      //tương tự trên
	@JoinColumn(name = "PositionID", nullable = false)  // tương tự trên
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Position position;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)     // xác định kiểu dữ liệu thời gian, vì db để kiểu Date tương ứng trong java là TIMESTAMP 
	@CreationTimestamp         //mặc định là thời gian hiện tại
	private Date createDate;

	@Column(name = "Password", length = 800)
	private String password;

	@Enumerated(EnumType.ORDINAL)  //JPA sẽ sử dụng số thứ tự của enum làm giá trị
	@Column(name = "`status`", nullable = false)
	private AccountStatus status = AccountStatus.NOT_ACTIVE;   //lưu trạng thái kích hoạt của tài khoản

	@Column(name = "PathImage", length = 50, unique = true, updatable = true)
	private String PathImage;    //trường này lưu tên ảnh xuống db

	@Column(name = "`Role`", nullable = false)
	@Enumerated(EnumType.STRING)   // chuyển đổi giá trị của enum sang string để lưu xuống db
	private AccountRole role = AccountRole.User;

	public Account(String email, String userName, String fullName, Department department, Position position) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
	}

	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getPathImage() {
		return PathImage;
	}

	public void setPathImage(String pathImage) {
		PathImage = pathImage;
	}

	public AccountRole getRole() {
		return role;
	}

	public void setRole(AccountRole role) {
		this.role = role;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department.getDepartmentName() + ", position="
				+ position.getPositionName() + ", createDate=" + createDate + "]";
	}

}
