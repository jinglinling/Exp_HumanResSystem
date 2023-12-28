package com.esms.controller;

import com.esms.entity.ThirdInsitution;
import com.esms.service.ThirdInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thirdInsitution")
public class ThirdInsitutionController {
    @Autowired
    private ThirdInsitutionService thirdInsitutionService;

    @GetMapping("/listThirdInsitution")
    public String listThirdInsitution(Model model) {
        List<ThirdInsitution> thirdInsitutions = thirdInsitutionService.listThirdInsitution();
        model.addAttribute("thirdInsitutions", thirdInsitutions);
        return "staffinfo";
    }
}
