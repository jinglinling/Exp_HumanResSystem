package com.esms.test;

import com.esms.entity.SecondInsitution;
import com.esms.mapper.SecondInsitutionMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SecondInsitutionTest {
    @Test
    public void listSecondInsitutionTest(){//查找二级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        List<SecondInsitution> listSecondInsitution = secondInsitutionMapper.listSecondInsitution();
        System.out.println(listSecondInsitution);
    }

    @Test
    public void getSecondInsitutionTest() {//查找二级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        SecondInsitution secondInsitution = secondInsitutionMapper.getSecondInsitution(1);
        System.out.println(secondInsitution);
    }

    @Test
    public void addSecondInsitutionTest() {//添加二级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        SecondInsitution secondInsitution = new SecondInsitution(2,"bbbb",1);
        secondInsitutionMapper.addSecondInsitution(secondInsitution);
    }

    @Test
    public void updateSecondInsitutionTest() {//修改二级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        SecondInsitution secondInsitution = secondInsitutionMapper.getSecondInsitution(2);
        secondInsitution.setSecondInsitutionName("eeee");
        secondInsitutionMapper.updateSecondInsitution(secondInsitution);
    }

    @Test
    public void deleteSecondInsitutionTest() {//删除二级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        secondInsitutionMapper.deleteSecondInsitution(2);
    }

    @Test
    public void Test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SecondInsitutionMapper secondInsitutionMapper = applicationContext.getBean(SecondInsitutionMapper.class);
        List<SecondInsitution> secondInsitutions = secondInsitutionMapper.listSecondInsitutionByPrimaryInsitutionNum(1);
        for (SecondInsitution secondInsitution : secondInsitutions) {
            System.out.println(secondInsitution);
        }
    }
}
