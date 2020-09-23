package model;

public class CauHoi {
    // dapAn0 = đáp án đúng
<<<<<<< HEAD
=======

    public String mach, noiDung, dapAnDung;
    public String dapAn0, dapAn1, dapAn2, dapAn3;

    public byte capDo;
    
    public CauHoi() {
        mach = "";
        noiDung = "";
        dapAn0 = dapAn1 = dapAn2 = dapAn3 = "";
        
    }

    @Override
    public String toString() {
        return mach;
    }
>>>>>>> e2a1f38e6bd887b45ea7ec3f4a8e2ec7248eaab0

    public String mach, noiDung, dapAnDung, dapAn0, dapAn1, dapAn2, dapAn3;
    public byte capDo;

    public CauHoi() {
        mach = noiDung = dapAnDung = dapAn0 = dapAn1 = dapAn2 = dapAn3 = "";
        capDo = 1;
    }

    @Override
    public String toString() {
        return mach;
    }
}
