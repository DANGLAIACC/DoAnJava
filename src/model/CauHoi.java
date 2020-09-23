package model;

public class CauHoi {
    // dapAn0 = đáp án đúng

    public String mach, noiDung, dapAnDung, dapAn0, dapAn1, dapAn2, dapAn3;
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
}
