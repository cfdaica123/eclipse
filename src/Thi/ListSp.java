package Thi;

public class ListSp {
private String madt;
private String tendt;
private String maudt;
private float giadt;


public ListSp() {
}


public ListSp(String madt, String tendt, String maudt, float giadt) {
	this.madt = madt;
	this.tendt = tendt;
	this.maudt = maudt;
	this.giadt = giadt;
}


public ListSp(String tendt, String maudt, float giadt) {
	this.tendt = tendt;
	this.maudt = maudt;
	this.giadt = giadt;
}


public String getMadt() {
	return madt;
}


public void setMadt(String madt) {
	this.madt = madt;
}


public String getTendt() {
	return tendt;
}


public void setTendt(String tendt) {
	this.tendt = tendt;
}


public String getMaudt() {
	return maudt;
}


public void setMaudt(String maudt) {
	this.maudt = maudt;
}


public float getGiadt() {
	return giadt;
}


public void setGiadt(float giadt) {
	this.giadt = giadt;
}



}
