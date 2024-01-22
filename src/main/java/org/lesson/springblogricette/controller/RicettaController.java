package org.lesson.springblogricette.controller;

import org.lesson.springblogricette.model.Ricetta;
import org.lesson.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/ricette")
public class RicettaController {

    @Autowired
    private RicettaRepository ricettaRepository;

    @GetMapping
    public String index(Model model){
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("ricettaList",ricettaList);
        return "ricette/index";
    }
}
