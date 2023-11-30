package com.esms.test;

import com.esms.entity.Staff;
import com.esms.mapper.StaffMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StaffTest {
    @Test
    public void listStaffTest() {//查找所有员工
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StaffMapper staffMapper = applicationContext.getBean(StaffMapper.class);
        List<Staff> listStaff = staffMapper.listStaff();
        for (Staff staff : listStaff) {
            System.out.println(staff);
        }
    }

    @Test
    public void getStaffTest(){//根据档案编号查找员工
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StaffMapper staffMapper = applicationContext.getBean(StaffMapper.class);
        Staff staff = staffMapper.getStaff(1L);
        System.out.println(staff);
    }

    @Test
    public void addStaffTest() {//添加员工信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StaffMapper staffMapper = applicationContext.getBean(StaffMapper.class);
        Staff staff = new Staff(2L,"赵四","女","114514@163.com","软件测试工程师","初级","0753-220","114514","梅州","114514","中国","五华",new Date(),"1122334455","汉","无","共青团员","441424200304220797","11223344",19,"本科",14,"物联网工程",new BigDecimal("9000"),"中国银行","114514","测试","打篮球","无","无","无",1,1,1,"admin",new Date(),"已审核");
        staffMapper.addStaff(staff);
    }

    @Test
    public void updateStaffTest() {//修改员工信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StaffMapper staffMapper = applicationContext.getBean(StaffMapper.class);
        Staff staff = staffMapper.getStaff(2L);
        staff.setEmail("114514@qq.com");
        staff.setTitle("中级");
        staff.setPhone("0753-114514");
        staff.setMobile("11451419");
        staff.setBirthPlace("梅州");
        staff.setBirthday(new Date());
        staffMapper.updateStaff(staff);
    }

    @Test
    public void changeStaffTest() {//修改员工状态
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StaffMapper staffMapper = applicationContext.getBean(StaffMapper.class);
        Staff staff = staffMapper.getStaff(2L);
        staff.setState("待审核");
        staffMapper.changeStaff(staff);
    }
}
