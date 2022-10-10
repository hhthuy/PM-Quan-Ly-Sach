package bookstore.Entity;

public class KhachHang {

    private String makhachhang;
    private String tenkhachhang;
    private String sdt;
    private String diachi;


	public String getMakhachhang() {
		return makhachhang;
	}


	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}


	public String getTenkhachhang() {
		return tenkhachhang;
	}


	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	@Override
    public String toString() {
        return this.tenkhachhang;
    }


}
