package com.esms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esms.entity.*;
import com.esms.service.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Wage")
public class WageController {
    private static int count=0;
    @Autowired
    private listService listService;
    @Autowired
    private record_Service record_service;
    @Autowired
    private recordamountService recordamountService;
    @Autowired
    private recorddetailedService recorddetailedService;
    @Autowired
    private standardService standardService;
    public static String generate(){
        count++;
        return String.format("%04d",count);
    }
    @RequestMapping("/wageindex")
    public String wageindex(){
        return "wageindex";
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<list> m=listService.getWage();
        model.addAttribute("list",m);
        return "list";
    }
@RequestMapping("/addlist")
    public String addlist(list m){
    listService.addWage(m);
    return "redirect:/Wage/list";
}
@RequestMapping("/deletelist")
    public String deletelist(String wname){
        listService.deleteWage(wname);
        return "redirect:/Wage/list";
}
@RequestMapping("/standard")
public String standard(Model model){
    List<list>n=listService.getWage();
    Date date =new Date();
    SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
    String d= formatter.format(date);
    model.addAttribute("Wagename",n);
    model.addAttribute("time",d);
    List<standard>a=standardService.getallstandard();
    String max="0000";
    if(!a.isEmpty()) {
        max = a.get(0).getStandardNo();

        for (int i = 0; i < a.size(); i++) {
            if (Integer.parseInt(a.get(i).getStandardNo()) > Integer.parseInt(max)) {
                max = a.get(i).getStandardNo();
            }
        }
        count=Integer.parseInt(max);
    }
    String p=generate();
    model.addAttribute("No",p);
        return "standard";
}
@RequestMapping("/addstandard")
    public String addstandard(standard m){
        standardService.addstandard(m);
        return "redirect:/Wage/uncheck";
}
@RequestMapping("/uncheck")
    public String uncheck(Model model){
        List<standard>m=standardService.getallstandard();
        List<standard>n=new ArrayList<>();
        int j=0;
        for(int i=0;i<m.size();i++){
         if(m.get(i).getCheck()==0){
             n.add(m.get(i));
         }
        }
        model.addAttribute("uncheck",n);
        return "uncheck";
}
@RequestMapping("/check")
public String check(String No,Model model){
        standard m=standardService.getstandardbyNo(No);
        List<list>n=listService.getWage();
        model.addAttribute("Wage",n);
        model.addAttribute("standard",m);
        return "check";
}
@RequestMapping("/updatecheck")
    public String updatecheck(standard m){
        standardService.updatestandard(m);
        return "redirect:/Wage/uncheck";
}
@RequestMapping("/requeststandard")
public String requeststandard(){
        return "requeststandard";
}
@RequestMapping("/getstandard")
    public String getstandard(String No,String keyword,String before,String after,Model model){
        standard a = null;
        List<standard>b=new ArrayList<>();
        List<standard>c=new ArrayList<>();
        List<standard>result=new ArrayList<>();
        if(!No.equals("")){
            a=standardService.getstandardbyNo(No);
            if(a!=null) {
                if (a.getCheck() == 0) {
                    No = "";
                }
            }
        }
    if(!keyword.equals("")){
        String temp="%";
       keyword=temp.concat(keyword);
       keyword=keyword.concat("%");
       List<standard>m=standardService.getstandardbykeyword(keyword);
       for(int i=0;i<m.size();i++){
           if(m.get(i).getCheck()!=0) {
               b.add(m.get(i));
           }
       }
    }
    if(!before.equals("")&&!after.equals("")){
        List<standard>n=standardService.getstandardbyDate(before,after);
        for(int i=0;i<n.size();i++){
            if(n.get(i).getCheck()!=0){
            c.add(n.get(i));}
        }
    }
    if(!No.equals("")){
        if(a!=null) {
            if(!b.isEmpty()) {
                if(!c.isEmpty()){
                if (!keyword.equals("") && (!before.equals("") && !after.equals(""))) {
                    boolean k = false;
                    boolean d = false;
                    for (int i = 0; i < b.size(); i++) {
                        if (a.getStandardNo().equals(b.get(i).getStandardNo())) {
                            k = true;
                        }
                    }
                    for (int j = 0; j < b.size(); j++) {
                        if (a.getStandardNo().equals(c.get(j).getStandardNo())) {
                            d = true;
                        }
                    }
                    if (k && d) {
                        result.add(a);
                        model.addAttribute("standardresult", result);
                    }else{
                        model.addAttribute("query",0);
                        model.addAttribute("standardresult",result);
                    }
                }
                }
                if (!keyword.equals("") && (before.equals("") && after.equals(""))) {
                    boolean k = false;
                    for (int i = 0; i < b.size(); i++) {
                        if (a.getStandardNo().equals(b.get(i).getStandardNo())) {
                            k = true;
                        }
                    }
                    if (k) {
                        result.add(a);
                        model.addAttribute("standardresult", result);
                    }else{
                        model.addAttribute("query",0);
                        model.addAttribute("standardresult",result);
                    }
                }
            }
            if(!c.isEmpty()) {
                if (keyword.equals("") && (!before.equals("") && !after.equals(""))) {
                    boolean d = false;
                    for (int i = 0; i < c.size(); i++) {
                        if (a.getStandardNo().equals(c.get(i).getStandardNo())) {
                            d = true;
                        }
                    }
                    if (d) {
                        result.add(a);
                        model.addAttribute("standardresult", result);
                    }else{
                        model.addAttribute("query",0);
                        model.addAttribute("standardresult",result);
                    }
                }
            }
            if (keyword.equals("") && (before.equals("") && after.equals(""))) {
                result.add(a);
                model.addAttribute("standardresult", result);
            }
        }else{
            model.addAttribute("query",0);
            model.addAttribute("standardresult",result);
        }
    }else{
        if(!keyword.equals("")){
            if(!b.isEmpty()) {
                if ((!before.equals("") && !after.equals(""))) {
                    if (!c.isEmpty()) {
                        boolean k = false;
                        for (int i = 0; i < c.size(); i++) {
                            for (int j = 0; j < b.size(); j++) {
                                if (b.get(j).getStandardNo().equals(c.get(i).getStandardNo())) {
                                    k = true;
                                    result.add(c.get(i));
                                }
                            }
                        }
                        if (k) {
                            model.addAttribute("standardresult", result);
                        }else{
                            model.addAttribute("query",0);
                            model.addAttribute("standardresult",result);
                        }
                    } else {
                        model.addAttribute("query",0);
                        model.addAttribute("standardresult",result);
                    }
                }else{
                    for (int i = 0; i < b.size(); i++) {
                        result.add(b.get(i));
                    }
                    model.addAttribute("standardresult", result);
                }
            }
        }else{
            if((!before.equals("")&&!after.equals(""))&&!c.isEmpty()){
                for (int i=0;i<c.size();i++){
                    result.add(c.get(i));
                }
                model.addAttribute("standardresult",result);
            }else{
                model.addAttribute("query",0);
                model.addAttribute("standardresult",result);
            }
        }
    }
    if(a==null&&b.isEmpty()&&c.isEmpty()){
        model.addAttribute("query",0);
        model.addAttribute("standardresult",result);
    }
        return "getstandard";
}
@RequestMapping("/creatrecord")
    public String creatrecord(Model model){
        List<record_> a=record_service.getallrecord();
        model.addAttribute("record",a);
        return"creatrecord";
}
@RequestMapping("/registrantrecord")
    public String registrantrecord(String No,Model model){
        List<recorddetailed> m=recorddetailedService.getalldetailedbyNo(No);
        List<record_> p=record_service.getallrecord();
        record_ re=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNo().equals(No)){
                re=p.get(i);
                model.addAttribute("record1",re);
            }
        }
        model.addAttribute("recordNo",m);
        for(int i=0;i<m.size();i++) {
            List<recordamount> n=recordamountService.getWagebyid(No,m.get(i).getName());
            model.addAttribute(m.get(i).getName(),n);
        }
        return"registrantrecord";
}
@RequestMapping("/addreward")
    public String addreward(String[] No,String[] Name,String[] wagename,Integer[]amount,int m,String n,int c){
        List<record_> p=record_service.getallrecord();
        record_ re=null;
        for(int i=0;i<p.size();i++){
        if(p.get(i).getNo().equals(n)){
            re=p.get(i);
        }
    }
        re.setTotal(m);
        re.setCheck(c);
    record_service.updaterecord(re);
        for(int i=0;i<No.length;i++) {
            recordamount l = new recordamount(No[i], Name[i], wagename[i], amount[i]);
            recordamountService.addWage(l);
        }
        return "redirect:/Wage/creatrecord";
}
@RequestMapping("/checkrecord")
    public String checkrecord(Model model){
    List<record_> a=record_service.getallrecord();
    List<record_>b=new ArrayList<>();
    for(int i=0;i<a.size();i++){
    if(a.get(i).getCheck()==2){
        b.add(a.get(i));
    }
    }
    model.addAttribute("uncheckrecord",b);
    return"uncheckrecord";
}
@RequestMapping("/uncheckrecord")
    public String uncheckrecord(String No,Model model){
    List<recorddetailed> m=recorddetailedService.getalldetailedbyNo(No);
    List<record_> p=record_service.getallrecord();
    recordamount q=null;
    recordamount w=null;
    record_ re=null;
    for(int i=0;i<p.size();i++){
        if(p.get(i).getNo().equals(No)){
            re=p.get(i);
            model.addAttribute("record2",re);
        }
    }
    model.addAttribute("recordNo1",m);
    for(int i=0;i<m.size();i++) {
        List<recordamount> n=recordamountService.getWagebyid(No,m.get(i).getName());
        model.addAttribute(m.get(i).getName(),n);
    }
    return"uncheckrecord";
}
}
