package bookstore.Entity;

public class BaoCaoKHTX {
	private KhachHang khachHang;
	private int soLuong;
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public BaoCaoKHTX() {
		super();
	}
	public BaoCaoKHTX(KhachHang khachHang, int soLuong) {
		this.khachHang = khachHang;
		this.soLuong = soLuong;
	}
	
}
