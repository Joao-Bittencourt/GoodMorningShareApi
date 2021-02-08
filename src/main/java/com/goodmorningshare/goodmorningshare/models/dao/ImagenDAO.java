/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodmorningshare.goodmorningshare.models.dao;

import com.goodmorningshare.goodmorningshare.models.dao.entity.Imagen;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 *
 * @author joao
 */
@Component
public class ImagenDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    ImagenRepository ImagenRepository;

    private Imagen CriaObjeto(SqlRowSet rowSet) {
        Imagen imagensEntidade = new Imagen();
        imagensEntidade.setNome(rowSet.getString("nome"));
        imagensEntidade.setId(rowSet.getInt("id"));
        imagensEntidade.setUrl(rowSet.getString("url"));

        return imagensEntidade;
    }

    public Imagen teste() {

        return null;

    }

    public List<Imagen> listar() {
//        ArrayList<Imagen> ListaImagen = new ArrayList<>();
//        SqlRowSet rowSetImagen = jdbcTemplate.queryForRowSet("select * from imagens");
//        jdbcTemplate.execute("select * from imagens");
//        while (rowSetImagen.next()) {
//
//            ListaImagen.add(CriaObjeto(rowSetImagen));
//        }
        return ImagenRepository.findAll();
//        return ListaImagen;
    }

    public Imagen inserir(Imagen Imagen) {
        jdbcTemplate.update("INSERT INTO imagens(nome,url,status)VALUES(?,?,?)",
                            Imagen.getNome(), Imagen.getUrl(), Imagen.getStatus());
        
        //busca o ultimo id para saber que foi incerido com sucesso
        int ID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        Imagen.setId(ID);
        return Imagen;
    }
}
