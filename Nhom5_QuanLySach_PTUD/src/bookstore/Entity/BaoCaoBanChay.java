package bookstore.Entity;

public class BaoCaoBanChay {
	private Sach sach;
	private int soLuongBan;
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public BaoCaoBanChay() {
		super();
	}
	public BaoCaoBanChay(Sach sach, int soLuongBan) {
		this.sach = sach;
		this.soLuongBan = soLuongBan;
	}
}
