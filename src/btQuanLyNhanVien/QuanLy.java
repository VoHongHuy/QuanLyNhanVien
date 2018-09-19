package btQuanLyNhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuanLy {
	private static final String FILE_NHANVIEN1 = "DSNVTen.txt";
	private static final String FILE_NHANVIEN2 = "DSNVNgaySinh.txt";
	private static Map<Integer, NhanVien> nhanViens = new HashMap<Integer, NhanVien>();
	static Scanner sc;

	public static void main(String[] args) throws IOException {
		docFile(FILE_NHANVIEN1);
		while (true) {
			menu();
			System.out.println("Moi ban chon chuc nang: ");
			int chucNang = Integer.valueOf(input());
			switch (chucNang) {
			case 1:
				themNhanVien();
				break;
			case 2:
				xemNhanVien();
				break;
			case 3:
				timNhanVien();
				break;
			case 4:
				xoaNhanVien();
				break;
			case 5:
				thayDoiNhanVien();

				break;
			case 6:
				inDanhSachAlphabet();
				break;
			case 7:
				String ngaySinh = "";
				inDanhSachTheoNgaySinh(ngaySinh);
				break;
			case 0:
				return;
			default:
				break;
			}

		}

	}

	private static void docFile(String path) throws IOException {
		BufferedReader bufferread = null;
		NhanVien nv = null;
		try {
			Reader read = new FileReader(path);
			bufferread = new BufferedReader(read);
			int id;
			while( (id = Integer.valueOf(bufferread.readLine()))!=-1) {
				
				
				String name = bufferread.readLine();
				String departerment = bufferread.readLine();
				String position = bufferread.readLine();
				Date birthday =null;
				try {
					 birthday = new SimpleDateFormat("dd/MM/yyyy").parse(bufferread.readLine());
				} catch (ParseException e) {
				}
				String email = bufferread.readLine();
				String phoneNumber = bufferread.readLine();
				String address = bufferread.readLine();
				double salaryRate = Double.valueOf(bufferread.readLine());
				int salaryPlus =0;
				salaryPlus=Integer.valueOf(bufferread.readLine());
				
				if(salaryPlus!=0) {
					 nv = new NhanVienChinhThuc(id, name, departerment, position, birthday, email, phoneNumber, address, salaryRate, salaryPlus);
					 nhanViens.put(nv.getId(), nv);
					 bufferread.readLine();
				}
				else {
					 nv = new NhanVienHopDong(id, name, departerment, position, birthday, email, phoneNumber, address, salaryRate);
					 nhanViens.put(nv.getId(), nv);
					 continue;
					}
				
				}
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void inDanhSachTheoNgaySinh(String ngaySinh) throws IOException {
		List<NhanVien> listNhanVien = sortListNhanVienNgaySinh();
		inRaFile(listNhanVien, FILE_NHANVIEN2);
	}

	private static void inDanhSachAlphabet() throws FileNotFoundException, IOException {
		List<NhanVien> listNhanVien = sortListNhanVienTen();
		inRaFile(listNhanVien, FILE_NHANVIEN1);
	}

	private static void thayDoiNhanVien() {
		System.out.println("Nhap id nhan vien can thay doi");
		int id = Integer.valueOf(input());
		int chon;
		while (true) {
			System.out.println("Ban muon thay doi: ");
			System.out.println("1.Ho ten:");
			System.out.println("2.Phong ban:");
			System.out.println("3.Chuc vu:");
			System.out.println("4.Ngay sinh:");
			System.out.println("5.Email:");
			System.out.println("6.So dien thoai:");
			System.out.println("7.Dia chi:");
			System.out.println("8.He so luong:");
			System.out.println("0.Thoat");
			System.out.println("Moi ban chon: ");
			chon = Integer.valueOf(input());
			switch (chon) {
			case 0:
				return;

			case 1:
				System.out.println("Nhap ten moi");
				nhanViens.get(id).setName(input());
				break;
			case 2:
				System.out.println("Nhap phong ban moi");
				nhanViens.get(id).setDeparterment(input());
				break;
			case 3:
				System.out.println("Nhap chuc vu moi");
				nhanViens.get(id).setPosition(input());
				break;
			case 4:
				System.out.println("Nhap ngay sinh moi");
				try {
					new SimpleDateFormat("dd/MM/yyyy").parse(input());
				} catch (ParseException e) {
					System.out.println("Nhap sai dinh dang");
				}
				;
				break;
			case 5:
				System.out.println("Nhap email moi");
				nhanViens.get(id).setEmail(input());
				break;
			case 6:
				System.out.println("Nhap sdt moi");
				nhanViens.get(id).setPhoneNmber(input());
				break;
			case 7:
				System.out.println("Nhap dia chi moi");
				nhanViens.get(id).setAddress(input());
				break;
			case 8:
				System.out.println("Nhap he so luong moi");
				nhanViens.get(id).setSalaryRate(Integer.valueOf(input()));
				break;

			default:
				break;
			}
		}
	}

	private static void xoaNhanVien() {
		System.out.println("Nhap id nhan vien muon xoa");
		int id = Integer.valueOf(input());
		nhanViens.remove(id);
	}

	private static void timNhanVien() {
		System.out.println("Nhap ten nhan vien muon tim:");
		String name = input();
		int count = 0;
		for (Integer key : nhanViens.keySet()) {
			NhanVien nv = nhanViens.get(key);
			if (nv.getName().equals(name))
				nv.xuatNhanVien();
			count++;
		}
		System.out.println("tim thay " + count + " ket qua");

	}

	private static void xemNhanVien() {
		System.out.println("Nhap id nhan vien muon xem");
		int id = Integer.valueOf(input());
		NhanVien nv = nhanViens.get(id);
		if (nv != null)
			nv.xuatNhanVien();
		else
			System.out.println("khong ton tai nhan vien co id " + id);
	}

	private static void themNhanVien() {
		System.out.println("Nhap so luong nhan vien: ");
		int soLuong = Integer.valueOf(input());
		for (int i = 0; i < soLuong; i++) {
			NhanVien nv;
			System.out.println("Nhap nhan vien thu " + i);
			System.out.println("Nhap loai nhan vien(1: chinh thuc / 2: hop dong): ");
			if (input().equals("1"))
				nv = new NhanVienChinhThuc();
			else
				nv = new NhanVienHopDong();

			try {
				nv.nhapNhanVien();
			} catch (ParseException e) {
			}
			if (!nhanViens.containsKey(nv.getId()))
				nhanViens.put(nv.getId(), nv);
			else
				System.out.println("ID nhan vien da ton tai");
		}
	}

	public static String input() {
		sc = new Scanner(System.in);
		String input = sc.nextLine();

		return input;
	}

	private static void menu() {
		System.out.println("*******************MENU******************");
		System.out.println("1.Them nhan vien");
		System.out.println("2.Xem nhan vien");
		System.out.println("3.Tim kiem nhan vien theo ten");
		System.out.println("4.Xoa nhan vien");
		System.out.println("5.Thay doi thong tin nhan vien");
		System.out.println("6.In file danh sach nhan vien theo alphabet");
		System.out.println("7.In file danh sach nhan vien sinh ngay:...");
		System.out.println("0.Ket thuc");
	}

	private static List<NhanVien> sortListNhanVienTen() {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		for (int id : nhanViens.keySet()) {
			listNhanVien.add(nhanViens.get(id));
		}
		listNhanVien.sort(new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return (o1.getName().compareToIgnoreCase(o2.getName()));
			}

		});
		return listNhanVien;
	}

	private static List<NhanVien> sortListNhanVienNgaySinh() {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		for (int id : nhanViens.keySet()) {
			listNhanVien.add(nhanViens.get(id));
		}
		listNhanVien.sort(new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return (o1.getBirthDay().compareTo(o2.getBirthDay()));
			}

		});
		return listNhanVien;
	}

	private static void inRaFile(List<NhanVien> list, String path) throws IOException {
		BufferedWriter bufferedWriter = null;

		try {
			Writer writer = new FileWriter(path);
			bufferedWriter = new BufferedWriter(writer);
			for (NhanVien nhanVien : list) {
				bufferedWriter.write(nhanVien.getId()+"\n");
				bufferedWriter.write(nhanVien.getName()+"\n");
				bufferedWriter.write(nhanVien.getDeparterment()+"\n");
				bufferedWriter.write(nhanVien.getPosition()+"\n");
				bufferedWriter.write(new SimpleDateFormat("dd/MM/yyyy").format(nhanVien.getBirthDay())+"\n");
				bufferedWriter.write(nhanVien.getEmail()+"\n");
				bufferedWriter.write(nhanVien.getPhoneNmber()+"\n");
				bufferedWriter.write(nhanVien.getAddress()+"\n");
				bufferedWriter.write(""+nhanVien.getSalaryRate()+"\n");
				if(nhanVien instanceof NhanVienChinhThuc) {
					bufferedWriter.write(((NhanVienChinhThuc) nhanVien).getSalaryPlus()+"\n");
				}
				bufferedWriter.write("0"+"\n");
			}
			bufferedWriter.write("-1");
		} finally {
			if (bufferedWriter != null)
				bufferedWriter.close();
		}

	}

}
