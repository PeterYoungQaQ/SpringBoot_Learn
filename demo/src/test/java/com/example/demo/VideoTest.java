package com.example.demo;

/*
 * @Author: Haoran
 * @Date: 2021/1/22 20:01
 */

import com.example.demo.domain.Video;
import com.example.demo.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
@AutoConfigureMockMvc
public class VideoTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void videoVideoListApi() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();

        System.out.println(status);
        System.out.println(result);
    }

    @Test
    public void testVideoList(){

        List<Video> videoList = videoService.listVideo();

        Assert.assertTrue(videoList.size()>0);
    }

//    @Before
//    public void testBefore(){
//        System.out.println("测试之前要干的事");
//    }
//    @Test
//    public void test(){
//        System.out.println("这个是测试1");
//        TestCase.assertEquals(1,3);
//    }
//    @Test
//    public void test2(){
//        System.out.println("这个是测试2");
//    }
//    @After
//    public void testAfter(){
//        System.out.println("测试之后要干的事");
//    }
}
