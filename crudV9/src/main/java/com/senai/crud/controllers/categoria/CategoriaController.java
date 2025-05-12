package com.senai.crud.controllers.categoria;

import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;
}
