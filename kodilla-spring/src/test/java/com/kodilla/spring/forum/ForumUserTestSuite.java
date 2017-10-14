package com.kodilla.spring.forum;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite {

    @Autowired
    private ForumUser forumUser;

    @Test
    public void Should_getUserName() {
        //Given
        //
        //When
        String actualName = forumUser.getUsername();
        //Then
        Assert.assertEquals("John Smith", actualName);
    }


}
