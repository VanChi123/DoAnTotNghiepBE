//package com.mta.shop.entities;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Table(name = "FAVORITE")
//@Entity // Đánh dấu đây là table trong db
//@Data // lombok giúp generate các hàm constructor, get, set v.v.
//@AllArgsConstructor
//@NoArgsConstructor
//public class Favorite {
////        @EmbeddedId
////        private FavoriteId id;
//
//
////@Id
////@GeneratedValue(strategy= GenerationType.IDENTITY)
////@Column(name = "ID")
////private Integer id;
//
////        @Column(name = "YEUTHICH")
////        private Boolean yeuThich;
//
////        @ManyToOne
////        @JoinColumn(name = "IDSANPHAM", insertable = false, updatable = false) // không set true vì ở bên kia id đã có ròi nó sẽ báo lỗi repeat
////        @JsonBackReference
////        private SanPhamEntity sanPham;
//
////        @ManyToOne
////        @JsonBackReference
////        @JoinColumn(name = "IDTAIKHOAN", insertable = false, updatable = false) //  không set true vì ở bên kia id đã có ròi nó sẽ báo lỗi repeat
////        private TaiKhoanEntity taiKhoan;
//
//
//}
