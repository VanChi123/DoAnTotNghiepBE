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

}
