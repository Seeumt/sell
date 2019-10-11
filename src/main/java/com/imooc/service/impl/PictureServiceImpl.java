package com.imooc.service.impl;

import com.imooc.dataobject.TPicture;
import com.imooc.repository.PictureDao;
import com.imooc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public void deletePicture(Integer id) {
        pictureDao.delete(id);
    }

    @Override
    public void updatePicture(TPicture picture) {
        pictureDao.save(picture);
    }

    @Override
    public TPicture getPicture(Integer id) {
        return pictureDao.getOne(id);
    }

    @Override
    public void insertPicture(TPicture picture) {
        pictureDao.save(picture);
    }

    @Override
    public List<TPicture> getAllPictures() {
        return pictureDao.findAll();
    }

        }
