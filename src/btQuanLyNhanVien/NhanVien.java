package btQuanLyNhanVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NhanVien {
	private int id;
	private String name;
	private String departerment;
	private String position;
	private Date birthDay;
	private String email;
	private String phoneNmber;
	private String address;
	private double salaryRate;

	public NhanVien() {
	}

	public NhanVien(int id, String name, String departerment, String position, Date birthDay, String email,
			String phoneNmber, String address, double salaryRate) {
		super();
		this.id = id;
		this.name = name;
		this.departerment = departerment;
		this.position = position;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNmber = phoneNmber;
		this.address = address;
		this.salaryRate = salaryRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeparterment() {
		return departerment;
	}

	public void setDeparterment(String departerment) {
		this.departerment = departerment;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNmber() {
		return phoneNmber;
	}

	public void setPhoneNmber(String phoneNmber) {
		this.phoneNmber = phoneNmber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}

	public abstract double salary(int days);
	public  void nhapNhanVien() throws ParseException {
		System.out.println("Nhap id:");
		int id = Integer.valueOf(QuanLy.input());
		setId(id);
		System.out.println("Nhap ho ten:");
		String name = QuanLy.input();
		setName(name);
		System.out.println("Nhap phong ban:");
		String departerment = QuanLy.input();
		setDeparterment(departerment);
		System.out.println("Nhap chuc vu:");
		String position = QuanLy.input();
		setPosition(position);
		System.out.println("Nhap ngay sinh:");
		Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900");
		try {
			birthday = new SimpleDateFormat("dd/MM/yyyy").parse(QuanLy.input());
		} catch (Exception e) {
		}
		setBirthDay(birthday);
		System.out.println("Nhap email:");
		String email = QuanLy.input();
		setEmail(email);
		System.out.println("Nhap so dien thoai:");
		String phoneNumber = QuanLy.input();
		setPhoneNmber(phoneNumber);
		System.out.println("Nhap dia chi:");
		String address = QuanLy.input();
		setAddress(address);
		System.out.println("Nhap he so luong:");
		double salaryRate = Double.valueOf(QuanLy.input());
		setSalaryRate(salaryRate);
	}
	public void xuatNhanVien() {
		System.out.println("ID: "+getId());
		System.out.println("Ho ten: "+getName());
		System.out.println("Phong ban: "+getDeparterment());
		System.out.println("Chuc vu: "+getPosition());
		System.out.println("Ngay sinh: "+new SimpleDateFormat("dd/MM/yyyy").format(getBirthDay()));
		System.out.println("Email: "+getEmail());
		System.out.println("So dien thoai: "+getPhoneNmber());
		System.out.println("Dia chi: "+getAddress());
		System.out.println("He so luong: "+getSalaryRate());
	}
	
}
