package com.imooc.service;

import com.imooc.dataobject.TPicture;

import java.util.List;

public interface PictureService {
    /**
     * 删
     * @param id
     */
    void deletePicture(Integer id);

    /**
     * 改
     * @param TPicture
     */
    void updatePicture(TPicture TPicture);

    /**
     * 查
     * @param id
     * @return
     */
    TPicture getPicture(Integer id);

    /**
     * 增
     * @param TPicture
     */
    void insertPicture(TPicture TPicture);

    /**
     * 全
     * @return
     */
    List<TPicture> getAllPictures();

    
}
