package model;

public class SinhVien {
	// Kết quả thi
	private String user;
	private String pass;
	private String hoTen;
	private String maMonHoc;
	private float diem;
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
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public SinhVien(String user, String pass, String maMonHoc, float diem) {
		super();
		this.user = user;
		this.pass = pass;
		this.maMonHoc = maMonHoc;
		this.diem = diem;
	}
	
	
}
