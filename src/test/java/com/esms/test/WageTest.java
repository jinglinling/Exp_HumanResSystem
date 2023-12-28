package com.esms.test;

import com.esms.entity.list;
import com.esms.mapper.listMapper;
import com.esms.entity.record_;
import com.esms.mapper.record_Mapper;
import com.esms.mapper.recordamountMapper;
import com.esms.entity.recordamount;
import com.esms.entity.recorddetailed;
import com.esms.mapper.recorddetailedMapper;
import com.esms.mapper.standardMapper;
import com.esms.entity.standard;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WageTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        standardMapper m=context.getBean(standardMapper.class);
        standard n=new standard("sb","test1",
                "2003-01-01","zsx",2000,0,5000,"mjy");
        m.addstandard(n);
        System.out.println(m.getallstandard().get(0).toString());
        System.out.println(m.getstandardbyDate("2001-01-01","2004-02-01").get(0).toString());
        System.out.println(m.getstandardbyNo("test1").toString());
        System.out.println(m.getstandardbykeyword("%zs%").get(0).toString());
        n.setCheck(1);
        m.updatestandard(n);
        System.out.println(m.getstandardbyNo("test1").toString());
        m.deletestandard("test1");
    }
}
