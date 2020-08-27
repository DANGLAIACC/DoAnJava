package model;

public class DeThi {
	private String maDT,tenMH;
	private byte thoiGian;
	public DeThi() {}
	public DeThi(String maDT, String tenMH, byte thoiGian) {
		this.maDT = maDT;
		this.tenMH = tenMH;
		this.thoiGian=thoiGian;
	}
	
	public String toString() {
		return maDT+" - "+tenMH;
	}
	
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public void setThoiGian(byte thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getMaDT() {
		return maDT;
	}
	public byte getThoiGian() {
		return thoiGian;
	} 
}
