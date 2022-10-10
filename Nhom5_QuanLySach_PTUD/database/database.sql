USE [master]
GO
/****** Object:  Database [BookShop]    Script Date: 11/10/2021 04:35:40 PM ******/
CREATE DATABASE [BookShop]
 /******CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\BookShop.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BookShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\BookShop_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BookShop] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookShop].[dbo].[sp_fulltext_database] @action = 'enable'
end******/
GO
ALTER DATABASE [BookShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookShop] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [BookShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookShop] SET  MULTI_USER 
GO
ALTER DATABASE [BookShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookShop] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [BookShop]
GO
/****** Object:  Table [dbo].[tb_CTPN]    Script Date: 12/4/2021 8:16:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_CTPN](
	[maCTPN] [nvarchar](50) NOT NULL,
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maSach] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [bigint] NOT NULL,
	[thanhTien] [bigint] NOT NULL,
 CONSTRAINT [PK_tb_CTPN] PRIMARY KEY CLUSTERED 
(
	[maCTPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_CTPX]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_CTPX](
	[maCTPX] [nvarchar](50) NOT NULL,
	[maPhieuXuat] [nvarchar](50) NOT NULL,
	[maSach] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thanhTien] [bigint] NOT NULL,
 CONSTRAINT [PK_tb_CTPX] PRIMARY KEY CLUSTERED 
(
	[maCTPX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_GianHang]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_GianHang](
	[maGianHang] [nvarchar](50) NOT NULL,
	[tenGianHang] [nvarchar](50) NULL,
	[moTa] [ntext] NOT NULL,
 CONSTRAINT [PK_tb_GianHang] PRIMARY KEY CLUSTERED 
(
	[maGianHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_KhachHang]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_KhachHang](
	[maKH] [nvarchar](50) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[sdt] [char](10) NULL,
	[diachi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_NguoiDung]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_NguoiDung](
	[TaiKhoan] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tb_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_NhanVien]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[sdt] [char](10) NULL,
	[diachi] [nvarchar](50) NOT NULL,
	[chucVu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tb_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_NXB]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_NXB](
	[maNXB] [nvarchar](50) NOT NULL,
	[tenNXB] [nvarchar](50) NULL,
	[diaChi] [ntext] NOT NULL,
	[dienThoai] [ntext] NOT NULL,
	[email] [ntext] NOT NULL,
 CONSTRAINT [PK_tb_NXB] PRIMARY KEY CLUSTERED 
(
	[maNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_PhieuNhap]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_PhieuNhap](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maNXB] [nvarchar](50) NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[thanhTien] [bigint] NOT NULL,
 CONSTRAINT [PK_tb_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_PhieuXuat]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_PhieuXuat](
	[maPhieuXuat] [nvarchar](50) NOT NULL,
	[ngayXuat] [date] NOT NULL,
	[thanhTien] [bigint] NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tb_PhieuXuat] PRIMARY KEY CLUSTERED 
(
	[maPhieuXuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_Sach]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Sach](
	[maSach] [nvarchar](50) NOT NULL,
	[tieuDe] [nvarchar](50) NULL,
	[tacGia] [nvarchar](50) NULL,
	[namXuatBan] [int] NOT NULL,
	[giaBia] [int] NOT NULL,
	[maNXB] [nvarchar](50) NOT NULL,
	[soLuongTon] [int] NOT NULL,
	[maGianHang] [nvarchar](50) NULL,
 CONSTRAINT [PK_tb_Sach] PRIMARY KEY CLUSTERED 
(
	[maSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_TacGia]    Script Date: 12/25/2021 9:46:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_TacGia](
	[maTacGia] [nvarchar](50) NOT NULL,
	[tenTacGia] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tb_TacGia] PRIMARY KEY CLUSTERED 
(
	[maTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN1', N'PN1', N'TDDV', 5, 15000, 1111)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN22', N'PN11', N'TCC2', 3, 17000, 51000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN24', N'PN12', N'TCC2', 1, 20000, 20000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN28', N'PN14', N'TCC2', 1, 19000, 19000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN31', N'PN14', N'HSK1', 1, 13000, 13000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN32', N'PN15', N'TDDV', 1, 23000, 23000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN33', N'PN16', N'TCC2', 10, 85000, 850000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN34', N'PN17', N'PTUD', 4, 95000, 380000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN35', N'PN18', N'TCC2', 2, 19000, 38000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN37', N'PN18', N'HSK1', 1, 13000, 13000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN38', N'PN19', N'TDDV', 5, 23000, 115000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN39', N'PN20', N'MTR', 3, 20000, 60000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN40', N'PN21', N'CSDL', 2, 99000, 198000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN41', N'PN22', N'TDDV', 11, 23000, 253000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN42', N'PN23', N'TCC2', 5, 85000, 425000)
INSERT [dbo].[tb_CTPN] ([maCTPN], [maPhieuNhap], [maSach], [soLuong], [donGia], [thanhTien]) VALUES (N'CTPN43', N'PN23', N'NGK', 1, 99000, 99000)
GO
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX12', N'PX9', N'TCC2', 4, 340000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX18', N'PX13', N'PTUD', 2, 190000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX19', N'PX14', N'TCC2', 3, 255000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX20', N'PX15', N'CSDL', 2, 594000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX21', N'PX16', N'TCC2', 3, 255000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX22', N'PX16', N'CSDL', 1, 99000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX23', N'PX17', N'TCC2', 10, 850000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX29', N'PX17', N'TCC2', 1, 85000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX30', N'PX18', N'TCC2', 3, 255000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX31', N'PX20', N'TCC2', 4, 340000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX32', N'PX20', N'TDDV', 1, 23000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX33', N'PX21', N'CSDL', 2, 198000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX34', N'PX22', N'NGK', 10, 990000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX35', N'PX23', N'PTUD', 2, 950000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX36', N'PX24', N'DNT', 3, 75000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX37', N'PX25', N'HSK1', 3, 267000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX38', N'PX26', N'DNT', 1, 25000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX39', N'PX26', N'TCC2', 2, 170000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX40', N'PX26', N'TDDV', 3, 69000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX41', N'PX27', N'PTUD', 2, 190000)
INSERT [dbo].[tb_CTPX] ([maCTPX], [maPhieuXuat], [maSach], [soLuong], [thanhTien]) VALUES (N'CTPX42', N'PX28', N'TCC2', 1, 85000)
GO
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'BANCHAY', N'Sách bán chạy', N'Sách bán chạy')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'CONGNGHE', N'Sách lập trình', N'Sách lập trình C/C++')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'GIAOTRINH', N'Sách đại học', N'Sách dành cho sinh viên năm 2')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'KHOAHOC', N'Sách khoa học', N'Sách khoa học viễn tưởng')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'KINHTE', N'Sách kinh tế', N'Sách kinh tế học')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'LICHSU', N'Sách lịch sử', N'Sách lịch sử Việt Nam')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'PHAPLUAT', N'Sách luật', N'Sách luật dân sự')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'TINHOC', N'Sách tin học', N'Sách tin học 10')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'TRUYEN', N'Truyện tranh', N'Truyện Tấm Cám')
INSERT [dbo].[tb_GianHang] ([maGianHang], [tenGianHang], [moTa]) VALUES (N'VANHOC', N'Sách văn học', N'Sách ngữ văn')
GO
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH1', N'Võ Trung Tín', N'0169722265', N'4 Nguyễn Văn Bảo, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH10', N'Nguyễn Duy Khánh', N'0443472234', N'125 Công xã Paris, Bến Nghé, Quận 1')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH11', N'Trần Minh Khang', N'0256980241', N'416 Dương Quảng Hàm, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH12', N'Lê Anh Quân', N'0327768436', N'Nguyễn Thái Sơn, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH13', N'Nguyễn Khả Hân', N'0491234531', N'125 Công xã Paris, Bến Nghé, Quận 1')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH14', N'Đoàn Phương Nam', N'0327767820', N'Nguyễn Thái Sơn, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH15', N'Nguyễn Quang Khải', N'0432622349', N'125 Công xã Paris, Bến Nghé, Quận 1')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH16', N'Trần Trung Nam', N'0837727267', N'Đồng Tháp')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH17', N'Trần Thị Yến Linh', N'0738738325', N'Đồng Tháp')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH2', N'Hồ Thị Hồng Thủy', N'0256989388', N'416 Dương Quảng Hàm, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH3', N'Đoàn Ngọc Quốc Bảo', N'0327760239', N'Nguyễn Thái Sơn, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH4', N'Nguyễn Thái Học', N'0493472018', N'125 Công xã Paris, Bến Nghé, Quận 1')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH5', N'Trần Văn Anh', N'0367263782', N'123 Đông Anh, Hà Nội')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH6', N'Hồ Hoài An', N'0256987022', N'416 Dương Quảng Hàm, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH7', N'Lê Cát Tường', N'0327765821', N'Nguyễn Thái Sơn, Gò Vấp, TPHCM')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH8', N'Nguyễn Khả Hân', N'0491232943', N'125 Công xã Paris, Bến Nghé, Quận 1')
INSERT [dbo].[tb_KhachHang] ([maKH], [tenKH], [sdt], [diachi]) VALUES (N'KH9', N'Đoàn Ngọc Quốc Bảo', N'0327765329', N'Nguyễn Thái Sơn, Gò Vấp, TPHCM')
GO
INSERT [dbo].[tb_NguoiDung] ([TaiKhoan], [MatKhau]) VALUES (N'@root:admin', N'admin')
INSERT [dbo].[tb_NguoiDung] ([TaiKhoan], [MatKhau]) VALUES (N'admin', N'admin')
GO
INSERT [dbo].[tb_NhanVien] ([maNhanVien], [tenNhanVien], [sdt], [diachi], [chucVu]) VALUES (N'NV1', N'Võ Trung Tín', N'0388055011', N'Dong Thap', N'Nhan Vien')
INSERT [dbo].[tb_NhanVien] ([maNhanVien], [tenNhanVien], [sdt], [diachi], [chucVu]) VALUES (N'NV2', N'Hồng Thủy', N'0384858644', N'TP.HCM', N'Nhan Vien')
INSERT [dbo].[tb_NhanVien] ([maNhanVien], [tenNhanVien], [sdt], [diachi], [chucVu]) VALUES (N'NV3', N'Bảo', N'0638494832', N'Dong Nai', N'Nhan Vien')
GO
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'BACHKHOA', N'NXB Bách Khoa', N'Gõ Vấp - TP.HCM', N'0988754852', N'nxbbachkhoa@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'GIAODUC', N'NXB Giáo dục', N'Quận 1 - TP.HCM', N'0999999999', N'giaoduc@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'KIMDONG', N'NXB Kim Đồng', N'Hai Bà Trưng', N'01685245157', N'nxbkimdong@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'LAODONG', N'NXB Lao động', N'Nguyễn Du, Hà Nội', N'01649346164', N'nxbtuoitre@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'TONGHOP', N'NXB Tổng hợp', N' Quận 1, TP.HCM', N'038222726', N'nxbtonghop@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'TRUYENTHONG', N'NXB Truyền thông', N'Bình Thạnh - TP.HCM', N'062632078', N'nxbtuoitre@gmail.com')
INSERT [dbo].[tb_NXB] ([maNXB], [tenNXB], [diaChi], [dienThoai], [email]) VALUES (N'TUOITRE', N'NXB Tuổi Trẻ', N'Hà Nội', N'01649346164', N'nxbtuoitre@gmail.com')
GO
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN1', N'KIMDONG', CAST(N'2015-03-04' AS Date), 1111)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN11', N'TUOITRE', CAST(N'2016-12-16' AS Date), 74000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN12', N'GIAODUC', CAST(N'2016-12-16' AS Date), 50000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN14', N'GIAODUC', CAST(N'2016-12-16' AS Date), 42000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN15', N'KIMDONG', CAST(N'2021-12-01' AS Date), 23000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN16', N'GIAODUC', CAST(N'2021-12-01' AS Date), 850000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN17', N'GIAODUC', CAST(N'2021-12-01' AS Date), 380000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN18', N'GIAODUC', CAST(N'2021-12-04' AS Date), 61000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN19', N'KIMDONG', CAST(N'2021-12-04' AS Date), 115000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN20', N'LAODONG', CAST(N'2021-12-24' AS Date), 60000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN21', N'GIAODUC', CAST(N'2021-12-24' AS Date), 198000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN22', N'KIMDONG', CAST(N'2021-12-25' AS Date), 253000)
INSERT [dbo].[tb_PhieuNhap] ([maPhieuNhap], [maNXB], [ngayNhap], [thanhTien]) VALUES (N'PN23', N'GIAODUC', CAST(N'2021-12-25' AS Date), 524000)
GO
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX13', CAST(N'2021-12-01' AS Date), 190000, N'KH1')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX14', CAST(N'2021-12-01' AS Date), 255000, N'KH2')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX15', CAST(N'2021-12-01' AS Date), 594000, N'KH1')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX16', CAST(N'2021-12-01' AS Date), 354000, N'KH4')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX17', CAST(N'2021-12-02' AS Date), 958000, N'KH5')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX18', CAST(N'2021-12-21' AS Date), 255000, N'KH1')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX20', CAST(N'2021-12-23' AS Date), 363000, N'KH4')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX21', CAST(N'2021-12-23' AS Date), 198000, N'KH4')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX22', CAST(N'2021-12-23' AS Date), 990000, N'KH4')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX23', CAST(N'2021-12-23' AS Date), 950000, N'KH4')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX24', CAST(N'2021-12-23' AS Date), 75000, N'KH11')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX25', CAST(N'2021-12-23' AS Date), 267000, N'KH10')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX26', CAST(N'2021-12-23' AS Date), 264000, N'KH8')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX27', CAST(N'2021-12-24' AS Date), 190000, N'KH8')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX28', CAST(N'2021-12-24' AS Date), 85000, N'KH3')
INSERT [dbo].[tb_PhieuXuat] ([maPhieuXuat], [ngayXuat], [thanhTien], [maKH]) VALUES (N'PX9', CAST(N'2021-11-27' AS Date), 340000, N'KH6')
GO
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'CSDL', N'Hệ cơ sở dữ liệu', N'Nguyễn Trúc Ly', 2018, 99000, N'GIAODUC', 50, N'CONGNGHE')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'DNT', N'Đắc nhân tâm', N'Nguyễn Thị Lý', 2012, 25000, N'BACHKHOA', 16, N'VANHOC')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'HSK1', N'Hướng sự kiện java', N'Nguyễn Thị Hoàng Khánh', 2020, 89000, N'GIAODUC', 44, N'TINHOC')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'MTR', N'Mùa tuyết rơi', N'Trang Trang', 2020, 20000, N'LAODONG', 3, N'VANHOC')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'NGK', N'Chí Phèo', N'Nam Cao', 2018, 99000, N'GIAODUC', 40, N'TRUYEN')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'PTUD', N'Phát triển ứng dụng', N'Đặng Minh Châu', 2020, 95000, N'GIAODUC', 61, N'TINHOC')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'TCC2', N'Cánh Đồng Bất Tận', N'Nguyễn Ngọc Tư', 2015, 85000, N'GIAODUC', 20, N'TINHOC')
INSERT [dbo].[tb_Sach] ([maSach], [tieuDe], [tacGia], [namXuatBan], [giaBia], [maNXB], [soLuongTon], [maGianHang]) VALUES (N'TDDV', N'Tắt Đèn', N'Ngô Tất Tố', 1996, 23000, N'KIMDONG', 35, N'VANHOC')
GO
ALTER TABLE [dbo].[tb_CTPN]  WITH CHECK ADD  CONSTRAINT [FK_tb_CTPN_tb_PhieuNhap] FOREIGN KEY([maPhieuNhap])
REFERENCES [dbo].[tb_PhieuNhap] ([maPhieuNhap])
GO
ALTER TABLE [dbo].[tb_CTPN] CHECK CONSTRAINT [FK_tb_CTPN_tb_PhieuNhap]
GO
ALTER TABLE [dbo].[tb_CTPX]  WITH CHECK ADD  CONSTRAINT [FK_tb_CTPX_tb_PhieuXuat] FOREIGN KEY([maPhieuXuat])
REFERENCES [dbo].[tb_PhieuXuat] ([maPhieuXuat])
GO
ALTER TABLE [dbo].[tb_CTPX] CHECK CONSTRAINT [FK_tb_CTPX_tb_PhieuXuat]
GO
ALTER TABLE [dbo].[tb_PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_tb_PhieuNhap_tb_NXB] FOREIGN KEY([maNXB])
REFERENCES [dbo].[tb_NXB] ([maNXB])
GO
ALTER TABLE [dbo].[tb_PhieuNhap] CHECK CONSTRAINT [FK_tb_PhieuNhap_tb_NXB]
GO
ALTER TABLE [dbo].[tb_PhieuXuat]  WITH CHECK ADD  CONSTRAINT [fk_maKH] FOREIGN KEY([maKH])
REFERENCES [dbo].[tb_KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[tb_PhieuXuat] CHECK CONSTRAINT [fk_maKH]
GO
ALTER TABLE [dbo].[tb_Sach]  WITH CHECK ADD  CONSTRAINT [FK_tb_Sach_tb_NXB] FOREIGN KEY([maNXB])
REFERENCES [dbo].[tb_NXB] ([maNXB])
GO
ALTER TABLE [dbo].[tb_Sach] CHECK CONSTRAINT [FK_tb_Sach_tb_NXB]
GO
