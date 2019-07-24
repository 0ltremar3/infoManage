package com.zryx.company.mapper;

import com.zryx.company.mapper.NewsMapper;
import com.zryx.company.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsMapperTest {

    /**
     * @Autowired:自动注入所需的对象
     */
    @Autowired
    private NewsMapper newsMapper;

    @Test
    public void getAllNewsTest(){
        List<News> news = newsMapper.getAllNews();
        for (News n : news){
            System.out.println(n);
        }
    }
}
