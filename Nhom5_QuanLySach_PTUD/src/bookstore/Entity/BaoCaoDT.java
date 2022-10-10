/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Entity;

/**
 *
 * @author Nhom5
 */
public class BaoCaoDT {

    private String maSach;
    private String tieuDe;
    private String tenNXB;
    private int soLuongTon;
    private int slNhap;
    private int slXuat;
    private int tienNhap;
    private int tienBan;

	public int getTienNhap() {
		return tienNhap;
	}

	public void setTienNhap(int tienNhap) {
		this.tienNhap = tienNhap;
	}

	public int getTienBan() {
		return tienBan;
	}

	public void setTienBan(int tienBan) {
		this.tienBan = tienBan;
	}

	public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getSlNhap() {
        return slNhap;
    }

    public void setSlNhap(int slNhap) {
        this.slNhap = slNhap;
    }

    public int getSlXuat() {
        return slXuat;
    }

    public void setSlXuat(int slXuat) {
        this.slXuat = slXuat;
    }

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
    
}
