package com.esms.controller;

import com.esms.entity.PrimaryInsitution;
import com.esms.service.PrimaryInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/primaryInsitution")
public class PrimaryInsitutionController {
    @Autowired
    private PrimaryInsitutionService primaryInsitutionService;

    @GetMapping("/listPrimaryInsitution")
    public String listPrimaryInsitution(Model model) {//查找所有一级机构信息
        List<PrimaryInsitution> primaryInsitutions = primaryInsitutionService.listPrimaryInsitution();
        model.addAttribute("primaryInsitutions", primaryInsitutions);
        return "staffinfo";
    }

    @GetMapping("/getPrimaryInsitution/{primaryInsitutionNum}")
    public PrimaryInsitution getPrimaryInsitution(@PathVariable int primaryInsitutionNum) {//查找指定机构编号的一级机构信息
        return primaryInsitutionService.getPrimaryInsitution(primaryInsitutionNum);
    }

    @PostMapping("/addPrimaryInsitution")
    public void addPrimaryInsitution() {//添加一级机构信息
        PrimaryInsitution primaryInsitution = new PrimaryInsitution(2,"cccc");
        primaryInsitutionService.addPrimaryInsitution(primaryInsitution);
    }

    @PostMapping("/updatePrimaryInsitution")
    public void updatePrimaryInsitution() {//修改一级机构信息
        PrimaryInsitution primaryInsitution = primaryInsitutionService.getPrimaryInsitution(2);
        primaryInsitution.setPrimaryInsitutionName("dddd");
        primaryInsitutionService.updatePrimaryInsitution(primaryInsitution);
    }

    @PostMapping("/deletePrimaryInsitution/{primaryInsitutionNum}")
    public void deletePrimaryInsitution(@PathVariable int primaryInsitutionNum) {//删除一级机构信息
        primaryInsitutionService.deletePrimaryInsitution(primaryInsitutionNum);
    }
}
