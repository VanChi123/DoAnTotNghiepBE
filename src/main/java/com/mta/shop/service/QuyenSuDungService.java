package com.mta.shop.service;

import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.repository.QuyenSuDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyenSuDungService {

    @Autowired
    private QuyenSuDungRepository quyenSuDungRepository;

    public QuyenSuDungEntity findById(int id){
        return quyenSuDungRepository.findById(id).isPresent() ? quyenSuDungRepository.findById(id).get() : null ;
    }

    public Page<QuyenSuDungEntity> findAll(Integer pageNumber){
        return quyenSuDungRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public List<QuyenSuDungEntity> findAll(){
        return quyenSuDungRepository.findAll();
    }

    public QuyenSuDungEntity add(QuyenSuDungEntity quyenSuDungEntity){
        return quyenSuDungRepository.save(quyenSuDungEntity);
    }

    public void delete(Integer id){
        quyenSuDungRepository.deleteById(id);
    }

}
