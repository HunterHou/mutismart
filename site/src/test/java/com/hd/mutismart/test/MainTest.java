package com.hd.mutismart.test;

import com.hd.mutismart.base.annotation.Log;
import com.hd.mutismart.main.entity.EmailMessage;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainTest.class)
public class MainTest {

    @Resource
    private Configuration configuration;

    @Test
    @Log
    public void test() {
        try {
            EmailMessage mailMessage = new EmailMessage();
            mailMessage.setTo("tooo");
            mailMessage.setText("exsdsg");
            String result = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("template/mail-template.ftl"),
                                                                              mailMessage);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
