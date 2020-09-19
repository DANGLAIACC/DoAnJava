package model;

public class CauHoi {
	// dapAn0 = đáp án đúng
	public String mach,noiDung,dapAnDung;
        public String[] arrDapAn;
	
	public CauHoi() {
		mach = "";
		noiDung = "";
                arrDapAn[0] = arrDapAn[1]=arrDapAn[2]=arrDapAn[3]="";
                dapAnDung = arrDapAn[0];
	}
	
        @Override
	public String toString() {
		return mach;
	}
	

}
