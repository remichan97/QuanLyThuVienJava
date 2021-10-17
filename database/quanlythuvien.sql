-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2021 at 11:14 AM
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
(1, 'tin hoc', 1),
(2, 'van hoc', 1),
(3, 'sach giao khoa', 1),
(4, 'tap chi', 1),
(5, 'truyen tranh', 0),
(6, 'truyen tranh', 0),
(7, 'sach tham khao', 1),
(8, 'tu truyen', 1),
(9, 'sang tac', 1);

-- --------------------------------------------------------

--
-- Table structure for table `muc_phat_muon`
--

CREATE TABLE `muc_phat_muon` (
  `muc_phat` int(1) NOT NULL,
  `tien_phat` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `muon_sach`
--

CREATE TABLE `muon_sach` (
  `id_muon_sach` int(4) NOT NULL,
  `id_sinh_vien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `id_sach_muon` int(3) NOT NULL,
  `ngay_muon` date NOT NULL,
  `ngay_tra` date NOT NULL,
  `ngay_tra_thuc_te` date NOT NULL,
  `so_luong_muon` int(2) NOT NULL,
  `tien_phat_muon` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_dung_he_thong`
--

CREATE TABLE `nguoi_dung_he_thong` (
  `ten_dang_nhap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role` enum('Admin','NguoiDung') COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoi_dung_he_thong`
--

INSERT INTO `nguoi_dung_he_thong` (`ten_dang_nhap`, `mat_khau`, `role`, `status`) VALUES
('admin', '96549e1e8ed56cbc3488058e98a5c3bc', 'Admin', 1);

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
(1, 'nxb giao duc', 1),
(2, 'nvb van hoc', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nop_phat`
--

CREATE TABLE `nop_phat` (
  `id_muon_sach` int(4) NOT NULL,
  `id_sach_muon` int(3) NOT NULL,
  `id_sinh_vien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `muc_phat` int(1) NOT NULL,
  `ghi_chu` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sinh_vien`
--

CREATE TABLE `sinh_vien` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(1, 'a', 1),
(2, 'b', 1),
(3, 'c', 1),
(4, 'd', 1),
(5, 'e', 1),
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
(1, 'vnexpress', 1, 1, 5, 0, 1, '', '', 1),
(2, 'dantri', 2, 2, 3, 0, 1, '', '', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_muc_sach`
--
ALTER TABLE `danh_muc_sach`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `muc_phat_muon`
--
ALTER TABLE `muc_phat_muon`
  ADD PRIMARY KEY (`muc_phat`);

--
-- Indexes for table `muon_sach`
--
ALTER TABLE `muon_sach`
  ADD PRIMARY KEY (`id_muon_sach`),
  ADD KEY `fk_sachmuon` (`id_sach_muon`),
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
-- Indexes for table `nop_phat`
--
ALTER TABLE `nop_phat`
  ADD KEY `fk_idmuonsach` (`id_muon_sach`),
  ADD KEY `fk_sinhvienmuonsach` (`id_sinh_vien`);

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
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `muc_phat_muon`
--
ALTER TABLE `muc_phat_muon`
  MODIFY `muc_phat` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nha_xuat_ban`
--
ALTER TABLE `nha_xuat_ban`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tac_gia`
--
ALTER TABLE `tac_gia`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `thong_tin_sach`
--
ALTER TABLE `thong_tin_sach`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `muon_sach`
--
ALTER TABLE `muon_sach`
  ADD CONSTRAINT `fk_sachmuon` FOREIGN KEY (`id_sach_muon`) REFERENCES `thong_tin_sach` (`id`),
  ADD CONSTRAINT `fk_sinhvien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinh_vien` (`ID`);

--
-- Constraints for table `nop_phat`
--
ALTER TABLE `nop_phat`
  ADD CONSTRAINT `fk_idmuonsach` FOREIGN KEY (`id_muon_sach`) REFERENCES `muon_sach` (`id_muon_sach`),
  ADD CONSTRAINT `fk_sinhvienmuonsach` FOREIGN KEY (`id_sinh_vien`) REFERENCES `muon_sach` (`id_sinh_vien`);

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
