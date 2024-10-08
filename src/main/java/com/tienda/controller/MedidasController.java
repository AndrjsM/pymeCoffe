package com.tienda.controller;

import com.tienda.service.MedidasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/medidas")
public class MedidasController {
    @Autowired
    private MedidasService medidasService; 
    
    @GetMapping
    public String inicio(Model model) {
        var medidas = medidasService.getMedidas();
        model.addAttribute("medidas", medidas);
        return "/inventario/listado";
    }
    
}
