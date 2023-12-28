package com.esms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

//员工档案
public class Staff {
    private Long fileNo;
    private String name;
    private String gender;
    private String email;
    private String position;
    private String title;
    private String phone;
    private String mobile;
    private String address;
    private String zipCode;
    private String nationality;
    private String birthPlace;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String QQ;
    private String nation;
    private String religion;
    private String politics;
    private String ID;
    private String SSN;
    private int age;
    private String education;
    private int educationYear;
    private String major;
    private BigDecimal salary;
    private String bank;
    private String account;
    private String speciality;
    private String hobby;
    private String resume;
    private String family;
    private String note;
    private Integer thirdInsitutionNum;
    private Integer secondInsitutionNum;
    private Integer primaryInsitutionNum;
    private String registrant;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registrationTime;
    private String state;
    private String primaryInsitutionName;
    private String secondInsitutionName;
    private String thirdInsitutionName;

    public Staff(Long fileNo, String name, String gender, String email, String position, String title, String phone, String mobile, String address, String zipCode, String nationality, String birthPlace, Date birthday, String QQ, String nation, String religion, String politics, String ID, String SSN, int age, String education, int educationYear, String major, BigDecimal salary, String bank, String account, String speciality, String hobby, String resume, String family, String note, Integer thirdInsitutionNum, Integer secondInsitutionNum, Integer primaryInsitutionNum, String registrant, Date registrationTime, String state) {
        this.fileNo = fileNo;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.position = position;
        this.title = title;
        this.phone = phone;
        this.mobile = mobile;
        this.address = address;
        this.zipCode = zipCode;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
        this.birthday = birthday;
        this.QQ = QQ;
        this.nation = nation;
        this.religion = religion;
        this.politics = politics;
        this.ID = ID;
        this.SSN = SSN;
        this.age = age;
        this.education = education;
        this.educationYear = educationYear;
        this.major = major;
        this.salary = salary;
        this.bank = bank;
        this.account = account;
        this.speciality = speciality;
        this.hobby = hobby;
        this.resume = resume;
        this.family = family;
        this.note = note;
        this.thirdInsitutionNum = thirdInsitutionNum;
        this.secondInsitutionNum = secondInsitutionNum;
        this.primaryInsitutionNum = primaryInsitutionNum;
        this.registrant = registrant;
        this.registrationTime = registrationTime;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fileNo=" + fileNo +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthday=" + birthday +
                ", QQ='" + QQ + '\'' +
                ", nation='" + nation + '\'' +
                ", religion='" + religion + '\'' +
                ", politics='" + politics + '\'' +
                ", ID='" + ID + '\'' +
                ", SSN='" + SSN + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", educationYear=" + educationYear +
                ", major='" + major + '\'' +
                ", salary=" + salary +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", speciality='" + speciality + '\'' +
                ", hobby='" + hobby + '\'' +
                ", resume='" + resume + '\'' +
                ", family='" + family + '\'' +
                ", note='" + note + '\'' +
                ", thirdInsitutionNum=" + thirdInsitutionNum +
                ", secondInsitutionNum=" + secondInsitutionNum +
                ", primaryInsitutionNum=" + primaryInsitutionNum +
                ", registrant='" + registrant + '\'' +
                ", registrationTime=" + registrationTime +
                ", state='" + state + '\'' +
                ", primaryInsitutionName='" + primaryInsitutionName + '\'' +
                ", secondInsitutionName='" + secondInsitutionName + '\'' +
                ", thirdInsitutionName='" + thirdInsitutionName + '\'' +
                '}';
    }

    public Long getFileNo() {
        return fileNo;
    }

    public void setFileNo(Long fileNo) {
        this.fileNo = fileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getThirdInsitutionNum() {
        return thirdInsitutionNum;
    }

    public void setThirdInsitutionNum(Integer thirdInsitutionNum) {
        this.thirdInsitutionNum = thirdInsitutionNum;
    }

    public Integer getSecondInsitutionNum() {
        return secondInsitutionNum;
    }

    public void setSecondInsitutionNum(Integer secondInsitutionNum) {
        this.secondInsitutionNum = secondInsitutionNum;
    }

    public Integer getPrimaryInsitutionNum() {
        return primaryInsitutionNum;
    }

    public void setPrimaryInsitutionNum(Integer primaryInsitutionNum) {
        this.primaryInsitutionNum = primaryInsitutionNum;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrimaryInsitutionName() {
        return primaryInsitutionName;
    }

    public void setPrimaryInsitutionName(String primaryInsitutionName) {
        this.primaryInsitutionName = primaryInsitutionName;
    }

    public String getSecondInsitutionName() {
        return secondInsitutionName;
    }

    public void setSecondInsitutionName(String secondInsitutionName) {
        this.secondInsitutionName = secondInsitutionName;
    }

    public String getThirdInsitutionName() {
        return thirdInsitutionName;
    }

    public void setThirdInsitutionName(String thirdInsitutionName) {
        this.thirdInsitutionName = thirdInsitutionName;
    }
}
