package com.mta.shop.service;

import com.mta.shop.controllers.message.TaiKhoan.AddAccountManyRoleRequest;
import com.mta.shop.controllers.message.TaiKhoan.DeleteAccountManyRoleRequest;
import com.mta.shop.controllers.message.TaiKhoan.GetAccountListRequest;
import com.mta.shop.controllers.message.UpdatePassword;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private QuyenSuDungService quyenSuDungService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private KhachHangService khachHangService;

    public TaiKhoanEntity updatePassword(UpdatePassword request){
        TaiKhoanEntity taiKhoanEntityUpdate = null;
        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanRepository.findByTenDangNhap(request.getUserName());

        if (taiKhoanEntity.isPresent()){
            taiKhoanEntityUpdate = taiKhoanEntity.get();
            taiKhoanEntityUpdate.setMatKhau(request.getNewPassword());

            taiKhoanEntityUpdate = taiKhoanRepository.save(taiKhoanEntityUpdate);
        }

        return  taiKhoanEntityUpdate;
    }

    //ok: thêm mới tài khoản nhiều quyền
    @Transactional
    public TaiKhoanEntity addAcountManyRoles(AddAccountManyRoleRequest request){

        List<Integer> codeRole = request.getIdRoles();
        List<QuyenSuDungEntity> roles = new ArrayList<>();

        // duyệt mảng id để lấy các quyền cho tài khoản ( nếu mảng ko có phẩn tử nao thì sẽ ko vào và ko báo lỗi)
        codeRole.forEach(e -> {
            QuyenSuDungEntity temp = quyenSuDungService.findById(e);
            if (null != temp){
                roles.add(temp);
            }
        });

        // lấy tài khoản entity từ trong request và thêm list quyền cho nó, nếu ko có quyền nào thì chắc là ko set
        TaiKhoanEntity taiKhoanEntity = request.getNewTaiKhoanEntity();
        taiKhoanEntity.setQuyenSuDungEntities(roles);

        taiKhoanEntity = taiKhoanRepository.save(taiKhoanEntity);

        return taiKhoanEntity;
    }

    //ok: cập nhât tài khoản nhiều quyền
    @Transactional
    public TaiKhoanEntity updateAcountManyRoles(AddAccountManyRoleRequest request){

        Optional<TaiKhoanEntity> taiKhoanEntityOpt = taiKhoanRepository.findById(request.getId());
        TaiKhoanEntity taiKhoanEntity = null;
        if (taiKhoanEntityOpt.isEmpty()){
            return  taiKhoanEntity;
        }

        taiKhoanEntity = taiKhoanEntityOpt.get();
        System.out.println("tai khoản lấy theo id truyền lên " + taiKhoanEntity);

        List<Integer> codeRole = request.getIdRoles();
        List<QuyenSuDungEntity> roles = new ArrayList<>();

        // duyệt mảng id để lấy các quyền cho tài khoản ( nếu mảng ko có phẩn tử nao thì sẽ ko vào và ko báo lỗi)
        codeRole.forEach(e -> {
            QuyenSuDungEntity temp = quyenSuDungService.findById(e);
            if (null != temp){
                roles.add(temp);
            }
        });

        // cập nhật lại các giá trì cho tài khoản
        taiKhoanEntity.setTenDangNhap(request.getNewTaiKhoanEntity().getTenDangNhap());
        taiKhoanEntity.setMatKhau(request.getNewTaiKhoanEntity().getMatKhau());
        taiKhoanEntity.setEmail(request.getNewTaiKhoanEntity().getEmail());
        taiKhoanEntity.setQuyenSuDungEntities(roles);

        taiKhoanEntity = taiKhoanRepository.save(taiKhoanEntity);

        return taiKhoanEntity;
    }

    //ok: xóa tài khoản nhiều quyền
    @Transactional
    public Boolean deleteAcountManyRoles(DeleteAccountManyRoleRequest request){

        // dể xóa : đầu tiên ta tìm kiếm , sau đó xóa, sau đó tìm kiếm lại : 0 thấy thì là xóa thành công
        Optional<TaiKhoanEntity> taiKhoanEntityOpt = taiKhoanRepository.findById(request.getId());

        if (taiKhoanEntityOpt.isEmpty()){
            return false;
        }
        System.out.println("tồn tại taikhoan: "+ taiKhoanEntityOpt.get());

        // trước khi xóa , kiểm tra quyền để xem nó liên kết với bảng nào => xóa thằng con rồi mới xóa thằng cha
        // nhưng giờ mình sẽ set giá trị bảng con trỏ đến null và xóa chả thôi, vì xóa con sẽ ko lấy được dữ liệu thằng cũ
        TaiKhoanEntity taiKhoanEntity = taiKhoanEntityOpt.get();

        List<QuyenSuDungEntity> list = (List<QuyenSuDungEntity>) taiKhoanEntity.getQuyenSuDungEntities();

        final int[] typeAccount = {0}; // mặc định ko có quyền nào, 1 là quyền quản trị, 2 là quyền khách hàng
        if (list.size() > 0 ){

            list.forEach(e -> {
                // đã gán rồi thì ko gán lại thấp hơn đươc nữa
                if (e.getId() == 2 && typeAccount[0] == 0)
                {
                    typeAccount[0] = 2;
                }
                if (e.getId() == 1 || e.getId() == 3){
                    typeAccount[0] = 1;
                }

            });

//            int result = list.stream().map(e -> e.getId() == 1 || e.getId() == 3).collect(Collectors.toList()).size();
//            if (result > 0){
//                typeAccount[0] = 1;
//            }else
//                typeAccount[0] = 2;
        }

        // tìm đến bảng nhân viên và sét nhân viên có id tài khoản null
        if (typeAccount[0] == 1){
            // nếu ko tìm thấy nhân viên nào thì thôi
            Optional<NhanVienEntity> nhanVienEntityOpt = nhanVienService.findOneByIdTaiKhoan(taiKhoanEntity.getId());
            if (nhanVienEntityOpt.isEmpty()){
            }else {
                NhanVienEntity nhanVienEntity = nhanVienEntityOpt.get();
                nhanVienEntity.setIdTaiKhoan(null);
                nhanVienService.saveOne(nhanVienEntity);
                System.out.println("loai tài khoản :admin");
            }
        }

        if (typeAccount[0] == 2){
            System.out.println("loai tài khoản :khách hàng");

            KhachHangEntity khachHangEntity = khachHangService.findByIdTaiKhoan(taiKhoanEntity.getId());
            if (null == khachHangEntity){

            }else {
                khachHangEntity.setIdTaiKhoan(null);
                khachHangService.saveOne(khachHangEntity);
            }
        }

        taiKhoanRepository.deleteById(request.getId());

        Optional<TaiKhoanEntity> taiKhoanEntityOptCheck = taiKhoanRepository.findById(request.getId());
        // System.out.println("tồn tại taikhoan sau xóa: "+ taiKhoanEntityOptCheck.get());// không dược get truoc khi check empty

        if (taiKhoanEntityOptCheck.isEmpty()){
            return true;
        }
        return false;
    }

    //ok: lấy tất cả các tài khoản theo phân trang
    public Page<TaiKhoanEntity> getAllAccount(GetAccountListRequest request){
//        List<Integer> roleIdList = new ArrayList<>();
//        if (null == request.getQuyenSuDung() || request.getQuyenSuDung().size() <1){
//            roleIdList.add(1);
//            roleIdList.add(2);
//            roleIdList.add(3);
//        }else {
//
//            roleIdList = request.getQuyenSuDung();
//        }

//        List<QuyenSuDungEntity> q = new ArrayList<>();
//        q = quyenSuDungService.findAll();
        return taiKhoanRepository.searchAllAccount(PageRequest.of(request.getPageNumber(),request.getPageSize()), request.getTenDangNhap(), request.getEmail());
    }

//    // lấy 1 tài khoản theo id;
    public Optional<TaiKhoanEntity> getAccountByTenDangNhap(String tenDangnhap){
        return taiKhoanRepository.findByTenDangNhap(tenDangnhap);
    }
}
