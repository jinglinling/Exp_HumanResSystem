package com.esms.test;

import com.esms.entity.PrimaryInsitution;
import com.esms.mapper.PrimaryInsitutionMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PrimaryInsitutionTest {
    @Test
    public void listPrimaryInsitution(){//查找一级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        PrimaryInsitutionMapper primaryInsitutionMapper = applicationContext.getBean(PrimaryInsitutionMapper.class);
        List<PrimaryInsitution> listPrimaryInsitution = primaryInsitutionMapper.listPrimaryInsitution();
        for (PrimaryInsitution primaryInsitution : listPrimaryInsitution) {
            System.out.println(primaryInsitution);
        }
    }

    @Test
    public void getPrimaryInsitutionTest() {//根据一级机构编号查找机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        PrimaryInsitutionMapper primaryInsitutionMapper = applicationContext.getBean(PrimaryInsitutionMapper.class);
        PrimaryInsitution primaryInsitution = primaryInsitutionMapper.getPrimaryInsitution(1);
        System.out.println(primaryInsitution);
    }

    @Test
    public void addPrimaryInsitutionTest() {//添加一级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        PrimaryInsitutionMapper primaryInsitutionMapper = applicationContext.getBean(PrimaryInsitutionMapper.class);
        PrimaryInsitution primaryInsitution = new PrimaryInsitution(2,"cccc");
        primaryInsitutionMapper.addPrimaryInsitution(primaryInsitution);
    }

    @Test
    public void updatePrimaryInsitutionTest() {//修改一级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        PrimaryInsitutionMapper primaryInsitutionMapper = applicationContext.getBean(PrimaryInsitutionMapper.class);
        PrimaryInsitution primaryInsitution = primaryInsitutionMapper.getPrimaryInsitution(2);
        primaryInsitution.setPrimaryInsitutionName("ddd");
        primaryInsitutionMapper.updatePrimaryInsitution(primaryInsitution);
    }

    @Test
    public void deletePrimaryInsitutionTest() {//删除一级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        PrimaryInsitutionMapper primaryInsitutionMapper = applicationContext.getBean(PrimaryInsitutionMapper.class);
        primaryInsitutionMapper.deletePrimaryInsitution(2);
    }
}
