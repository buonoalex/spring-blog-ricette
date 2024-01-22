package org.lesson.springblogricette.controller;

import org.lesson.springblogricette.model.Ricetta;
import org.lesson.springblogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/details/{id}")
    public String detailsRicetta(@PathVariable int id,Model model){
        Optional<Ricetta> detailsRicetta = ricettaRepository.findById(id);
        model.addAttribute("ricetta",detailsRicetta.get());
        return "ricette/details";
    }

    @GetMapping("/create")
    public String createRicetta(Model model){
        Ricetta ricetta = new Ricetta();
        model.addAttribute("ricetta",ricetta);
        return "ricette/create";
    }

    @PostMapping("/create")
    public String saveRicetta(@Validated @ModelAttribute("ricetta")Ricetta formRicetta, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ricette/create";
        }else{
            ricettaRepository.save(formRicetta);
            return "redirect:/home/ricette";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteRicetta(@PathVariable int id){
        Optional<Ricetta> ricettaRecovery = ricettaRepository.findById(id);
        Ricetta ricettaDelete = ricettaRecovery.get();
        ricettaRepository.delete(ricettaDelete);
        return "ricette/index";
    }
}
