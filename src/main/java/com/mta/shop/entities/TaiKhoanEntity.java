package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@Table(name = "TAIKHOAN")
public class TaiKhoanEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TENDANGNHAP")
    private String tenDangNhap;

    @Column(name = "MATKHAU")
    private String matKhau;

    @Column(name = "EMAIL")
    private String email;

    public TaiKhoanEntity(){
    }

    public TaiKhoanEntity( String tenDangNhap,  String matKhau,  String email){
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
    }

//    @Getter
//    @Setter
//    @ManyToMany
//            // @Transient
//    Set<QuyenSuDungEntity> quyenSuDungEntitySet = new HashSet<QuyenSuDungEntity>();

//    @ManyToMany
//    @JoinTable(
//            name = "PHANQUYEN",
//            joinColumns = {@JoinColumn(name = "IDTAIKHOAN")},
//            inverseJoinColumns = {@JoinColumn(name = "IDQUYEN")})


//    @JoinTable(name = "PHANQUYEN",
//            joinColumns = { @JoinColumn(name = "IDTAIKHOAN") },
//            inverseJoinColumns = {@JoinColumn(name = "IDQUYEN") })

//    @Getter
//    @Setter
//    @ElementCollection

//    @Getter
//    @Setter
//    @JsonIgnore
//    @OneToMany(mappedBy = "taiKhoanEntity", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<PhanQuyenEntity> phanQuyenEntities =new ArrayList<>();


//    Set<QuyenSuDungEntity> quyenSuDungEntitySet = new HashSet<>();

//    public Set<QuyenSuDungEntity> getQuyenSuDungEntitySet() {
//        return quyenSuDungEntitySet;
//    }
//
//    public void setQuyenSuDungEntitySet(Set<QuyenSuDungEntity> quyenSuDungEntitySet) {
//        this.quyenSuDungEntitySet = quyenSuDungEntitySet;
//    }


    @ManyToMany
        @JoinTable(
            name = "PHANQUYEN",
            joinColumns = {@JoinColumn(name = "IDTAIKHOAN")},
            inverseJoinColumns = {@JoinColumn(name = "IDQUYEN")})
    // @JsonBackReference
    private Collection<QuyenSuDungEntity> quyenSuDungEntities;

//    @OneToOne(mappedBy = "taiKhoanEntity")
//    private KhachHangEntity khachHangEntity;


    @OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonIgnore
//    @JsonBackReference
    private Collection<BinhLuan> binhLuans;

//    @OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
//    private Collection<Favorite> favorites;

//    @ManyToMany
    @ManyToMany(mappedBy = "taiKhoanEntities")
//    @JoinTable(
//            name = "FAVORITE",
//            joinColumns = {@JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true)},
//            inverseJoinColumns = {@JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true)})

    @JsonIgnore

//    @JsonBackReference  // chỉ được sử dụng JsonBack 1 lần trong entity này ko báo lỗi many backreference
    private List<SanPhamEntity> sanPhamEntities;

    @Override
    public String toString() {
        return "TaiKhoanEntity{" +
                "id=" + id +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
