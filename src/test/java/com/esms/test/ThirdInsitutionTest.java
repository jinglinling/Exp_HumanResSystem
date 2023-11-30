package com.esms.test;

import com.esms.entity.ThirdInsitution;
import com.esms.mapper.ThirdInsitutionMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ThirdInsitutionTest {
    @Test
    public void listThirdInsitutionTest(){//查找三级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ThirdInsitutionMapper thirdInsitutionMapper = applicationContext.getBean(ThirdInsitutionMapper.class);
        List<ThirdInsitution> listThirdInsitution = thirdInsitutionMapper.listThirdInsitution();
        for (ThirdInsitution thirdInsitution : listThirdInsitution) {
            System.out.println(thirdInsitution);
        }
    }

    @Test
    public void getThirdInsitutionTest(){//根据机构编号查找三级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ThirdInsitutionMapper thirdInsitutionMapper = applicationContext.getBean(ThirdInsitutionMapper.class);
        ThirdInsitution thirdInsitution = thirdInsitutionMapper.getThirdInsitution(1);
        System.out.println(thirdInsitution);
    }

    @Test
    public void addThirdInsitutionTest() {//添加三级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ThirdInsitutionMapper thirdInsitutionMapper = applicationContext.getBean(ThirdInsitutionMapper.class);
        ThirdInsitution thirdInsitution = new ThirdInsitution(2,"aaaa",1);
        thirdInsitutionMapper.addThirdInsitution(thirdInsitution);
    }

    @Test
    public void updateThirdInsitutionTest() {//修改三级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ThirdInsitutionMapper thirdInsitutionMapper = applicationContext.getBean(ThirdInsitutionMapper.class);
        ThirdInsitution thirdInsitution = thirdInsitutionMapper.getThirdInsitution(2);
        thirdInsitution.setThirdInsitutionName("ffff");
        thirdInsitutionMapper.updateThirdInsitution(thirdInsitution);
    }

    @Test
    public void deleteThirdInsitutionTest() {//删除三级机构信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ThirdInsitutionMapper thirdInsitutionMapper = applicationContext.getBean(ThirdInsitutionMapper.class);
        thirdInsitutionMapper.deleteThirdInsitution(2);
    }
}
