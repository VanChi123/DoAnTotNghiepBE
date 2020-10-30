package com.mta.shop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LOAISANPHAM")
@Getter
@Setter
public class LoaiSanPham {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "TENLOAISANPHAM")
        private String tenLoaiSanPham;

        @Override
        public String toString() {
                return "LoaiSanPham{" +
                        "id=" + id +
                        ", tenLoaiSanPham='" + tenLoaiSanPham + '\'' +
                        '}';
        }
}
