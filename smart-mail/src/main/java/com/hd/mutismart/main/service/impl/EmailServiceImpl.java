package com.hd.mutismart.main.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.main.entity.EmailMessage;
import com.hd.mutismart.main.service.IEmailService;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class EmailServiceImpl implements IEmailService {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private Configuration  freemarkerConfig;

    @Override
    public ReqResult sendEmail(EmailMessage msg) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("183598821@qq.com");
            helper.setTo("183598821@qq.com");
            helper.setSubject(msg.getSubject());
            Map<String, Object> model = new HashMap<>();
            model.put("userName", StringUtils.isEmpty(msg.getTo()) ? "oKong" : msg.getTo());
            model.put("text", StringUtils.isEmpty(msg.getTo()) ? "oKong" : msg.getText());
            String templateString = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate("mail.ftl"),
                                                                                      model);
            helper.setText(templateString, true);
            File file = new File("helloworld.png");
            helper.addInline("", file);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
        return ReqResult.success();
    }
}
