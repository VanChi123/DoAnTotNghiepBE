package com.mta.shop.service;

import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.repository.QuyenSuDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyenSuDungService {

    @Autowired
    private QuyenSuDungRepository quyenSuDungRepository;

    public QuyenSuDungEntity findById(int id){
        return quyenSuDungRepository.findById(id).isPresent() ? quyenSuDungRepository.findById(id).get() : null ;
    }

    public List<QuyenSuDungEntity> findAll(){
        return quyenSuDungRepository.findAll();
    }

}
