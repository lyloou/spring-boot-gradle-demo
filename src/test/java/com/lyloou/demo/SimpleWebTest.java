package com.lyloou.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class)
public class SimpleWebTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void pageNotFound() throws InterruptedException {
        browser.get("http://localhost:" + port);
        System.out.println("============================");
        System.out.println(browser.findElementByTagName("span").getText());
        System.out.println("============================");

        TimeUnit.SECONDS.sleep(10);
    }


    private static FirefoxDriver browser;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/tools/geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts()
                .implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }
}
