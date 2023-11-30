package com.esms.controller;

import com.esms.entity.SecondInsitution;
import com.esms.service.SecondInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/secondInsitution")
public class SecondInsitutionController {
    @Autowired
    private SecondInsitutionService secondInsitutionService;

    @GetMapping("/listSecondInsitution")
    public String listSecondInsitution(Model model) {
        List<SecondInsitution> secondInsitutions = secondInsitutionService.listSecondInsitution();
        model.addAttribute("secondInsitutions", secondInsitutions);
        return "staffinfo";
    }
}
