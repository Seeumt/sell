package com.imooc.repository;

import com.imooc.dataobject.TPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureDao extends JpaRepository<TPicture,Integer> {
}
