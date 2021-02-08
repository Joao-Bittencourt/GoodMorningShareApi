/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodmorningshare.goodmorningshare.models.dao;

import com.goodmorningshare.goodmorningshare.models.dao.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joao
 */
public interface ImagenRepository extends JpaRepository<Imagen, Long>{
    
}
