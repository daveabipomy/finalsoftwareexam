package edu.mum.cs.cs425.srs;

import edu.mum.cs.cs425.srs.service.IAccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiquidityTest {
    @Autowired
    IAccountService accountService;

    @Test
    public void contextLoads() {
        String actual=accountService.liquidity();
        Double expected=484596.21;
        Assert.assertEquals(expected.toString(),actual);
    }

}
