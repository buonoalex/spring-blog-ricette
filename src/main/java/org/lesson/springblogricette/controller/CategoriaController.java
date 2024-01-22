package org.lesson.springblogricette.controller;

import org.lesson.springblogricette.model.Categoria;
import org.lesson.springblogricette.model.Ricetta;
import org.lesson.springblogricette.repository.CategoriaRepository;
import org.lesson.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private RicettaRepository ricettaRepository;

    @GetMapping
    public String index(Model model){
        List<Categoria> categoriaList = categoriaRepository.findAll();
        model.addAttribute("categoriaList",categoriaList);
       return "categoria/index";
    }

    @GetMapping("/{id}")
    public String showCategory(@PathVariable int id,Model model){
        //Questo per nav bar
        List<Categoria> categoriaList = categoriaRepository.findAll();
        model.addAttribute("categoriaList",categoriaList);
        //Passo categoria al template
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        model.addAttribute("categoria",categoria.get());
        return "categoria/show";
    }
}
