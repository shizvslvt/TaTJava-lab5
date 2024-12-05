package com.example.tatjavalab5.controllers;

import com.example.tatjavalab5.serivce.EstateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estates")
@AllArgsConstructor
public class EstateController {

    private final EstateService estateService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("estates", estateService.getAllEstates());
        return "estates";
    }

    @GetMapping("/user-estates")
    public String list(@RequestParam Long id, Model model) {
        model.addAttribute("sellerEstates", estateService.getAllEstatesBySellerId(id));
        model.addAttribute("realtorEstates", estateService.getAllEstatesByRealtorId(id));
        return "user-estates";
    }
}
