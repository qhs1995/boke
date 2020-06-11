package com.hongshen.boke;

import com.hongshen.boke.dao.jianli.object.SkillDO;
import com.hongshen.boke.dao.object.ArticleDO;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.net.URLDecoder;
import  java.util.Objects;
/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/1/15 11:04
 * @Desc:
 */
public class Test extends TestCase {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public void test() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date(1560415272722L));
        System.out.println(date);

    }

    public void  testMail(){
        ArticleDO articleDO = new ArticleDO();
        articleDO.setTitle("aaaaa");
        ArticleDO articleDO2 = new ArticleDO();
        articleDO2.setTitle("aaaaa");
        ArticleDO articleDO3 = new ArticleDO();
        articleDO3.setTitle("cccc");
        List<ArticleDO> objects = new ArrayList<>();
        objects.add(articleDO);
        objects.add(articleDO2);
        objects.add(articleDO3);
        boolean gggggg = objects.stream().filter(w->String.valueOf(w.getTitle()).equals("aaaaa")).findFirst().isPresent();
       // boolean gggggg = objects.stream().filter(w ->String.valueOf( w.getTitle()).equals("bbbb")).findAny().isPresent();
        System.out.println(gggggg);

        //
        boolean equals = Objects.equals("a", "f");
    }


    public void testOther(){
        Integer a=14;
        Integer b=14;

        Integer c=300;
        Integer d=300;

        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(c==d);
        System.out.println(c.intValue()==d.intValue());
        System.out.println(c.equals(d));
    }
}
