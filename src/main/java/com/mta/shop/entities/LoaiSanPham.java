package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Entity
@Table(name = "LOAISANPHAM")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class LoaiSanPham {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "TENLOAISANPHAM")
        private String tenLoaiSanPham;

//     @JsonIgnore
//    @OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.LAZY, targetEntity = SanPhamEntity.class)
//    @JsonManagedReference
//    private List<SanPhamEntity> list =new ArrayList<>();


        @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
        // MapopedBy trỏ tới tên biến Address ở trong Person.
//        @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
//        @ToString.Exclude // Khoonhg sử dụng trong toString()
//        @JsonManagedReference
//        @EqualsAndHashCode.Exclude
//        @ToString.Exclude

        @JsonBackReference
//        @JsonIgnore
        private Collection<SanPhamEntity> persons;

}
