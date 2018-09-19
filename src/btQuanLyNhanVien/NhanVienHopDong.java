package btQuanLyNhanVien;

import java.util.Date;

public class NhanVienHopDong extends NhanVien{
	public NhanVienHopDong() {
	}
	
	public NhanVienHopDong(int id, String name, String departerment, String position, Date birthDay, String email,
			String phoneNmber, String address, double salaryRate) {
		super(id, name, departerment, position, birthDay, email, phoneNmber, address, salaryRate);
	}

	@Override
	public double salary(int days) {
		return days*getSalaryRate();
	}
}
