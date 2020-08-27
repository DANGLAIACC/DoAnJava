package model;

public class CauHoi {
	// dapAn0 = đáp án đúng
	public String mach,noiDung,dapAn0,dapAn1,dapAn2,dapAn3,dapAnDung;
	public byte capDo;

	
	public CauHoi() {
		mach = "";
		noiDung = "";
		dapAn0 = "";
		dapAn1 = "";
		dapAn2 = "";
		dapAn3 = "";
		dapAnDung = "";
		capDo = 1;
	}
	
	public String toString() {
		return mach;
	}
	

}
