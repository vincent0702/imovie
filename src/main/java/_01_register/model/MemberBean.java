package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="Member")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="seqNo")
	Integer pkey;
	String memberId;
	String name;
	String password;
	@Transient
	String password1;
	String address;
	String email;
	String tel;
	String userType;
	Timestamp registerTime;
	Double totalAmt;
	Blob memberImage;
	String fileName;
	Clob comment;
	String gender;
	String birth;
	String invalidCredentials;
	Double unpaid_amount;
	String login;
	String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInvalidCredentials() {
		return invalidCredentials;
	}

	public void setInvalidCredentials(String invalidCredentials) {
		this.invalidCredentials = invalidCredentials;
	}

	@Transient
	MultipartFile memberMultipartFile;
	              
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}              
	public void setPkey(Integer pkey) {
		this.pkey = pkey;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public MemberBean(Integer pkey, String memberId, String name, String password, String password1, String address,
			String email, String tel, String userType, Timestamp registerTime, Double totalAmt, Blob memberImage,
			String fileName, Clob comment,String gender, String birth, Double unpaid_amount, MultipartFile memberMultipartFile) {
		super();
		this.pkey = pkey;
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.password1 = password1;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.userType = userType;
		this.registerTime = registerTime;
		this.totalAmt = totalAmt;
		this.memberImage = memberImage;
		this.fileName = fileName;
		this.comment = comment;
		this.gender = gender;
		this.birth = birth ;
		this.unpaid_amount = unpaid_amount;
		this.memberMultipartFile = memberMultipartFile;
	}


	public MemberBean(Integer pkey, String memberId, String name, String password, String address, String email,
			String tel, String userType, Timestamp registerTime, Double totalAmt,String gender,String birth, Double unpaid_amount,
			Blob memberImage, String fileName) {
		System.out.println("Constructor=>" + memberImage);
		this.pkey = pkey;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.userType = userType;
		this.registerTime = registerTime;
		this.totalAmt = totalAmt;
		this.gender = gender;
		this.birth = birth ;
		this.unpaid_amount = unpaid_amount;
		this.fileName = fileName;
		this.memberImage = memberImage;
	}


	public MemberBean() {
	}
	
	public MemberBean(String email , String tel) {
		this.email = email;
		this.tel = tel;
	}

	public Integer getPkey() {
		return pkey;
	}
	
	public void setPkey(int pKey) {
		System.out.println("pKey=>" + pKey);
		this.pkey = pKey;
	}

	public Blob getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(Blob memberImage) {
		System.out.println("setMemberImage=>" + memberImage);
		this.memberImage = memberImage;
	}

	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setTs(Timestamp ts) {
		this.registerTime = ts;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [pkey=");
		builder.append(pkey);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", password1=");
		builder.append(password1);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", registerTime=");
		builder.append(registerTime);
		builder.append(", totalAmt=");
		builder.append(totalAmt);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", unpaid_amount=");
		builder.append(unpaid_amount);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", birth");
		builder.append(birth);
		builder.append("]");
		return builder.toString();
	}


	public String getUserType() {
		return userType;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public Double getUnpaid_amount() {
		return unpaid_amount;
	}

	public void setUnpaid_amount(Double unpaid_amount) {
		this.unpaid_amount = unpaid_amount;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}


	public MultipartFile getMemberMultipartFile() {
		return memberMultipartFile;
	}

	public void setMemberMultipartFile(MultipartFile memberMultipartFile) {
		System.out.println("memberMultipartFile=>" + memberMultipartFile);
		this.memberMultipartFile = memberMultipartFile;
	}
	
}
