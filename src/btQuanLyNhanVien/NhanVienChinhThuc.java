package btQuanLyNhanVien;

import java.text.ParseException;
import java.util.Date;

public class NhanVienChinhThuc extends NhanVien {
	private int salaryPlus;

	public NhanVienChinhThuc() {
	}

	public NhanVienChinhThuc(int id, String name, String departerment, String position, Date birthday, String email,
			String phoneNmber, String address, double salaryRate, int salaryPlus) {
		super(id, name, departerment, position, birthday, email, phoneNmber, address, salaryRate);
		this.salaryPlus = salaryPlus;
	}
	
	public int getSalaryPlus() {
		return salaryPlus;
	}

	public void setSalaryPlus(int salaryPlus) {
		this.salaryPlus = salaryPlus;
	}

	@Override
	public double salary(int days) {

		return days * getSalaryRate() + salaryPlus;
	}

	@Override
	public void nhapNhanVien() {
		try {
			super.nhapNhanVien();
		} catch (ParseException e) {
		}
		System.out.println("nhap luong thuong: ");
		int salaryPlus = Integer.valueOf(QuanLy.input());
		setSalaryPlus(salaryPlus);
	}

	@Override
	public void xuatNhanVien() {
		super.xuatNhanVien();
		System.out.println("Luong thuong: "+getSalaryPlus());
	}

	
}
