package com.esms.controller;

import com.esms.entity.PrimaryInsitution;
import com.esms.entity.SecondInsitution;
import com.esms.entity.Staff;
import com.esms.entity.ThirdInsitution;
import com.esms.service.PrimaryInsitutionService;
import com.esms.service.SecondInsitutionService;
import com.esms.service.StaffService;
import com.esms.service.ThirdInsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private PrimaryInsitutionService primaryInsitutionService;
    @Autowired
    private SecondInsitutionService secondInsitutionService;
    @Autowired
    private ThirdInsitutionService thirdInsitutionService;

    @GetMapping("/listStaff")
    public String listStaff(@RequestParam(value = "fileNo", required = false) Long fileNo, Model model){
        if(fileNo != null){//查找指定员工信息
            Staff staff = staffService.getStaff(fileNo);
            model.addAttribute("staffs", Arrays.asList(staff));
        }else {//查找所有员工信息
            List<Staff> staffs = staffService.listStaff();
            model.addAttribute("staffs", staffs);
        }
        return "staffinfo";
    }

    @GetMapping("/getStaff/{fileNo}")
    public String getStaff(@PathVariable long fileNo, Model model) {
        Staff staff = staffService.getStaff(fileNo);
        model.addAttribute("staff", staff);
        return "staffDetail";
    }

    @RequestMapping("/addStaff")
    public String addStaff(Staff staff) {//添加员工信息
        // 获取当前年份
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

        // 获取一级机构编号，二级机构编号和三级机构编号
        String primaryInsitutionNum = String.format("%02d", staff.getPrimaryInsitutionNum());
        String secondInsitutionNum = String.format("%02d", staff.getSecondInsitutionNum());
        String thirdInsitutionNum = String.format("%02d", staff.getThirdInsitutionNum());

        // 生成一个唯一的编号，使用数据库中的最大员工ID+1
        String uniqueNum = String.format("%02d", staffService.getMaxId() + 1);

        // 拼接档案编号
        String fileNoStr = year + primaryInsitutionNum + secondInsitutionNum + thirdInsitutionNum + uniqueNum;
        try {
            // 尝试将字符串转换为long类型
            long fileNo = Long.parseLong(fileNoStr);

            // 设置档案编号
            staff.setFileNo(fileNo);
        } catch (NumberFormatException e) {
            System.err.println("无法将档案编号转换为long类型: " + fileNoStr);
            return "error";
        }

        Date date = new Date();
        staff.setRegistrationTime(date);
        staff.setState("待审核");
        staffService.addStaff(staff);
        return "redirect:/staff/listProcessStaff";
    }

    @RequestMapping("/AddStaff")
    public String showAddStaffPage(Model model) {
        // 获取一级机构、二级机构和三级机构的列表
        List<PrimaryInsitution> primaryInsitutions = primaryInsitutionService.listPrimaryInsitution();
        List<SecondInsitution> secondInsitutions = secondInsitutionService.listSecondInsitution();
        List<ThirdInsitution> thirdInsitutions = thirdInsitutionService.listThirdInsitution();

        // 将这些列表添加到模型中
        model.addAttribute("primaryInsitutions", primaryInsitutions);
        model.addAttribute("secondInsitutions", secondInsitutions);
        model.addAttribute("thirdInsitutions", thirdInsitutions);

        // 返回视图名称
        return "addStaff";
    }

    @GetMapping("/listProcessStaff")
    public String listProcessStaff(@RequestParam(value = "fileNo", required = false) Long fileNo, Model model){
        if(fileNo != null){//查找指定员工信息
            Staff staff = staffService.getProcessStaff(fileNo);
            model.addAttribute("staffs", Arrays.asList(staff));
        }else {//查找所有待审核员工信息
            List<Staff> staffs = staffService.listProcessStaff();
            model.addAttribute("staffs", staffs);
        }
        return "processStaffinfo";
    }

    @PostMapping("/processStaff")
    public String processStaff(Staff staff) {//审核员工信息
        staff.setState("已审核");
        staffService.updateStaff(staff);
        return "redirect:/staff/listProcessStaff";
    }

    @GetMapping("/ProcessStaff/{fileNo}")
    public String showProcessForm(@PathVariable("fileNo") long fileNo, Model model) {//跳转到审核档案页面
        Staff staff = staffService.getProcessStaff(fileNo);
        model.addAttribute("staff", staff);
        return "processStaff";
    }

    @GetMapping("/listDeleteStaff")
    public String listDeleteStaff(@RequestParam(value = "fileNo", required = false) Long fileNo, Model model){
        if(fileNo != null){//查找指定员工信息
            Staff staff = staffService.getDeleteStaff(fileNo);
            model.addAttribute("staffs", Arrays.asList(staff));
        }else {//查找所有已删除员工信息
            List<Staff> staffs = staffService.listDeleteStaff();
            model.addAttribute("staffs", staffs);
        }
        return "deleteStaffinfo";
    }

    @PostMapping("/deleteStaff")
    public String deleteStaff(@ModelAttribute Staff staff) {//已删除员工信息
        staff.setState("已审核");
        staffService.updateStaff(staff);
        return "redirect:/staff/listDeleteStaff";
    }

    @GetMapping("/DeleteStaff/{fileNo}")
    public String showDeleteForm(@PathVariable("fileNo") long fileNo, Model model) {//跳转到已删除档案页面
        Staff staff = staffService.getDeleteStaff(fileNo);
        model.addAttribute("staff", staff);
        return "deleteStaff";
    }

    @PostMapping("/updateStaff")
    public String updateStaff(Staff staff) {//修改员工信息
        staff.setState("待审核");
        staffService.updateStaff(staff);
        return "redirect:/staff/listStaff";
    }

    @GetMapping("/updateStaff")
    public String showUpdateForm(@RequestParam("fileNo") long fileNo, Model model) {//跳转到更改档案页面
        Staff staff = staffService.getStaff(fileNo);
        model.addAttribute("staff", staff);
        return "updateStaff";
    }

    @PostMapping("/changeStaff")
    public String changeStaff(@RequestParam long fileNo) {//修改员工状态
        Staff staff = staffService.getStaff(fileNo);
        if (staff != null) {
            staff.setState("已删除");
            staffService.changeStaff(staff);
        }
        return "redirect:/staff/listStaff";
    }

    @GetMapping("/addStaff")
    public String showAddForm() {//跳转到添加档案页面
        return "addStaff";
    }

    @GetMapping("/processStaff")
    public String showProcessForm() {//跳转到添加档案页面
        return "processStaff";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
            }
        });
    }
}
