/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodmorningshare.goodmorningshare.controllers;

import com.goodmorningshare.goodmorningshare.models.dao.ImagenDAO;
import com.goodmorningshare.goodmorningshare.models.dao.entity.Imagen;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author joao
 */
@Controller
@ResponseBody
public class Imagens {
    @Autowired
    ImagenDAO ImagenDAO;
    
    @GetMapping("/listar")
//    @RequestMapping(path = "/listar", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
    public List<Imagen> listar() {
        return ImagenDAO.listar();
    }
    
    @RequestMapping(path = "/inserir", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Imagen inserir(@RequestBody Imagen Imagen) {
        return ImagenDAO.inserir(Imagen);
    }
}
