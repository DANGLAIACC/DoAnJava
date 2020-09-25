package model;

public class MonHoc {
    private String  maMH,tenMH;

    public MonHoc(String maMH, String tenMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
    }

    public MonHoc(){
        maMH = tenMH = "";
    }

    @Override
    public String toString() {
        return maMH+" - "+tenMH;
    }
    
    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }
    
}
