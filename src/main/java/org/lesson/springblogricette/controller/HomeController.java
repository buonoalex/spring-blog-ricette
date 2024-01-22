package org.lesson.springblogricette.controller;

import org.lesson.springblogricette.model.Categoria;
import org.lesson.springblogricette.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping
    public String index(Model model){
        List<Categoria> categoriaList = categoriaRepository.findAll();
        model.addAttribute("categoriaList",categoriaList);
        return "home/index";
    }
}
