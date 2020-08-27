package model;

public class GiangVien {
	// Chủ yếu là tính lương
	private String user;
	private String pass;
	private String hoTen;
	private String chucVu;
	private int soNgayLam;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public int getSoNgayLam() {
		return soNgayLam;
	}
	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}
	
	public GiangVien() {}
	
	public GiangVien(String user, String pass, int soNgayLam) {
		super();
		this.user = user;
		this.pass = pass;
		this.soNgayLam = soNgayLam;
	}
	
}
