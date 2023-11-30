package com.esms.controller;

import com.esms.entity.PrimaryInsitution;
import com.esms.entity.SecondInsitution;
import com.esms.entity.ThirdInsitution;
import com.esms.service.PrimaryInsitutionService;
import com.esms.service.SecondInsitutionService;
import com.esms.service.ThirdInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/institution")
public class InsitutionController {
    @Autowired
    private PrimaryInsitutionService primaryInsitutionService;
    @Autowired
    private SecondInsitutionService secondInsitutionService;
    @Autowired
    private ThirdInsitutionService thirdInsitutionService;

    @RequestMapping("addThirdInsitution")
    public String addThirdInsitution(ThirdInsitution thirdInsitution) {//添加三级机构
        thirdInsitution.setThirdInsitutionNum(thirdInsitutionService.getMaxThirdInsitutionId() + 1);
        thirdInsitutionService.addThirdInsitution(thirdInsitution);
        return "redirect:/staff/listStaff";
    }

    @GetMapping("/addThirdInsitution")
    public String showAddThirdInsitutionPage(Model model) {
        List<PrimaryInsitution> primaryInsitutions = primaryInsitutionService.listPrimaryInsitution();
        model.addAttribute("primaryInsitutions", primaryInsitutions);
        return "addThirdInsitution";
    }

    @GetMapping("/getInsitutionInfo")
    @ResponseBody
    public ResponseEntity<List<SecondInsitution>> getInsitutionInfo(@RequestParam("primaryInsitutionNum") Integer primaryInsitutionNum) {
        List<SecondInsitution> secondInsitutions = secondInsitutionService.listSecondInsitutionByPrimaryInsitutionNum(primaryInsitutionNum);
        return new ResponseEntity<>(secondInsitutions, HttpStatus.OK);
    }
}
