-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2021 at 03:49 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_sach`
--

CREATE TABLE `danh_muc_sach` (
  `id` int(2) NOT NULL,
  `ten` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc_sach`
--

INSERT INTO `danh_muc_sach` (`id`, `ten`, `status`) VALUES
(1, 'Sách giáo khoa', 1),
(2, 'Tự truyện', 1),
(3, 'Sách tham khảo', 1),
(4, 'Tạp chí', 1),
(5, 'truyen tranh', 0),
(7, 'sach tham khao', 0),
(8, 'tu truyen', 0),
(9, 'sang tac', 0),
(10, 'Truyện chữ', 1),
(11, 'Văn học nước ngoài', 1);

-- --------------------------------------------------------

--
-- Table structure for table `muon_sach`
--

CREATE TABLE `muon_sach` (
  `id` int(11) NOT NULL,
  `id_sinh_vien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `id_sach` int(3) NOT NULL,
  `ngay_muon` date NOT NULL,
  `ngay_tra` date NOT NULL,
  `ngay_tra_thuc_te` date DEFAULT NULL,
  `status` int(1) NOT NULL,
  `le_phi_phat` int(6) DEFAULT NULL,
  `ghi_chu` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `muon_sach`
--

INSERT INTO `muon_sach` (`id`, `id_sinh_vien`, `id_sach`, `ngay_muon`, `ngay_tra`, `ngay_tra_thuc_te`, `status`, `le_phi_phat`, `ghi_chu`) VALUES
(1, '2', 6, '2021-11-02', '2021-11-09', '2021-11-15', 1, 60000, 'Không có'),
(2, '3', 5, '2021-11-15', '2021-11-22', '2021-12-30', 3, 300000, 'Sinh viên pawer trả muộn quyển Nhật Ky Anne Frank quá 30 ngày, phạt300000 đồng, và bị thu hồi quyền mượn sách tại thư viện');

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_dung_he_thong`
--

CREATE TABLE `nguoi_dung_he_thong` (
  `full_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `ten_dang_nhap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT 0,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoi_dung_he_thong`
--

INSERT INTO `nguoi_dung_he_thong` (`full_name`, `ten_dang_nhap`, `mat_khau`, `admin`, `status`) VALUES
('Quản Trị Viên', 'admin', '96549e1e8ed56cbc3488058e98a5c3bc', 1, 1),
('User1', 'not_an_adm', '634ae794de02301ecf4d477d86a32fc1', 0, 1),
('User2', 'test', '5d9c68c6c50ed3d02a2fcf54f63993b6', 0, 1),
('test user', 'user', '25d55ad283aa400af464c76d713c07ad', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `nha_xuat_ban`
--

CREATE TABLE `nha_xuat_ban` (
  `id` int(3) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nha_xuat_ban`
--

INSERT INTO `nha_xuat_ban` (`id`, `ten`, `status`) VALUES
(1, 'NXB Giáo Dục', 1),
(2, 'NXB Văn Học', 1),
(3, 'NXB Kim Đồng', 1),
(4, 'NXB Hội Nhà Văn', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sinh_vien`
--

CREATE TABLE `sinh_vien` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` int(1) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `anh` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sinh_vien`
--

INSERT INTO `sinh_vien` (`id`, `ten`, `so_dien_thoai`, `gioi_tinh`, `email`, `anh`, `status`) VALUES
('2', 'Lại Hoàng Lê', '0888999655', 0, 'laile@gmail.com', '216361233248.jpg', 1),
('3', 'Vũ Xuân Hoa', '0845566256', 1, 'hoavx@outlook.com', '316361233964.png', 1),
('SV001', 'Nguyễn Văn Hiếu', '0912378516', 0, 'hieunv@gmail.com', '', 0),
('SV005', 'Nguyễn Văn Thắng', '0912355875', 0, 'thangnguyen@gmail.com', '516361234267.png', 1),
('SV007', 'Đặng Hoàng Vĩnh', '03486158909', 0, 'vinhdang@gmail.com', '716361234453.jpg', 1),
('SV008', 'Lê An Khang', '0348641890', 0, 'khang.le@gmail.com', '', 0),
('SV009', 'Lại Minh Hằng', '0653322256', 1, 'hang.lai@gmail.com', '916361234839.jpg', 1),
('SV010', 'Trương Vũ Thu Thảo', '0133225544', 1, 'thaotruong@outlook.com', '', 0),
('SV015', 'Đặng Anh Thắng', '01234567890', 0, 'thangdang@gmail.com', '', 0),
('SV085', 'Nguyễn Minh Trang', '0912355647', 1, 'trangnguyen@gmail.com', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tac_gia`
--

CREATE TABLE `tac_gia` (
  `id` int(3) NOT NULL,
  `ten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tac_gia`
--

INSERT INTO `tac_gia` (`id`, `ten`, `status`) VALUES
(1, 'Tô Hoài', 1),
(2, 'Hector Malot', 1),
(3, 'Đặng Thùy Trâm', 1),
(4, 'Victor Hugo', 1),
(5, 'Anne Frank', 1),
(6, 'f', 0);

-- --------------------------------------------------------

--
-- Table structure for table `thong_tin_sach`
--

CREATE TABLE `thong_tin_sach` (
  `id` int(3) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `id_tac_gia` int(3) NOT NULL,
  `id_danh_muc` int(2) NOT NULL,
  `so_luong` int(2) NOT NULL,
  `so_luong_da_muon` int(2) NOT NULL DEFAULT 0,
  `id_nha_xuat_ban` int(3) NOT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci NOT NULL,
  `anh` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thong_tin_sach`
--

INSERT INTO `thong_tin_sach` (`id`, `ten`, `id_tac_gia`, `id_danh_muc`, `so_luong`, `so_luong_da_muon`, `id_nha_xuat_ban`, `mo_ta`, `anh`, `status`) VALUES
(1, 'Dế Mèn Phiêu Lưu Ký', 1, 10, 5, 0, 3, 'Tác phẩm dành cho thiếu nhi', 'DeMenPhieuLuuKy-16358437360.jpg', 1),
(2, 'Không Gia Đình', 2, 11, 5, 0, 3, 'Tác phẩm kể về hành trình của một cậu bé đi tìm lại gia đình mình', 'KhongGiaĐinh-16358282099.jpg', 1),
(3, 'Thằng gù Nhà Thờ Đức Bà', 4, 11, 10, 0, 2, 'Một tiểu thuyết có tính chất lịch sử lấy bối cảnh Paris thời Trung cổ', 'ThangguNhaThoĐucBa-16358291745.jpg', 1),
(4, 'Nhật Ký Đặng Thùy Trâm', 3, 2, 10, 0, 4, 'Những ghi chép hằng ngày của một nữ bác sỹ nơi chiến tuyến', 'NhatKyĐangThuyTram-16358284124.jpg', 1),
(5, 'Nhật Ky Anne Frank', 5, 11, 10, 0, 2, 'Cuộc sống của một cô bé người Do Thái dưới ách thông trị của Đức Quốc Xã', 'NhatKyAnneFrank-16358288387.jpg', 1),
(6, 'Những Người Khốn Khổ', 4, 11, 10, 0, 1, 'Bài hát ca ngợi về tình yêu và sự tự do của một con người tái sinh trong đau khổ và tuyệt vọng', 'NhungNguoiKhonKho-16358285835.jpg', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_muc_sach`
--
ALTER TABLE `danh_muc_sach`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `muon_sach`
--
ALTER TABLE `muon_sach`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sachmuon` (`id_sach`),
  ADD KEY `fk_sinhvien` (`id_sinh_vien`);

--
-- Indexes for table `nguoi_dung_he_thong`
--
ALTER TABLE `nguoi_dung_he_thong`
  ADD PRIMARY KEY (`ten_dang_nhap`);

--
-- Indexes for table `nha_xuat_ban`
--
ALTER TABLE `nha_xuat_ban`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sinh_vien`
--
ALTER TABLE `sinh_vien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tac_gia`
--
ALTER TABLE `tac_gia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thong_tin_sach`
--
ALTER TABLE `thong_tin_sach`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_danhmucsach` (`id_danh_muc`),
  ADD KEY `fk_tacgia` (`id_tac_gia`),
  ADD KEY `fk_nhaxuatban` (`id_nha_xuat_ban`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc_sach`
--
ALTER TABLE `danh_muc_sach`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `muon_sach`
--
ALTER TABLE `muon_sach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nha_xuat_ban`
--
ALTER TABLE `nha_xuat_ban`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tac_gia`
--
ALTER TABLE `tac_gia`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `thong_tin_sach`
--
ALTER TABLE `thong_tin_sach`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `muon_sach`
--
ALTER TABLE `muon_sach`
  ADD CONSTRAINT `fk_sachmuon` FOREIGN KEY (`id_sach`) REFERENCES `thong_tin_sach` (`id`),
  ADD CONSTRAINT `fk_sinhvien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinh_vien` (`id`);

--
-- Constraints for table `thong_tin_sach`
--
ALTER TABLE `thong_tin_sach`
  ADD CONSTRAINT `fk_danhmucsach` FOREIGN KEY (`id_danh_muc`) REFERENCES `danh_muc_sach` (`id`),
  ADD CONSTRAINT `fk_nhaxuatban` FOREIGN KEY (`id_nha_xuat_ban`) REFERENCES `nha_xuat_ban` (`id`),
  ADD CONSTRAINT `fk_tacgia` FOREIGN KEY (`id_tac_gia`) REFERENCES `tac_gia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
