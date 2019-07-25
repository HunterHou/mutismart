package com.hd.mutismart.main.service;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.main.entity.EmailMessage;

/**
 * @author hunter
 */
public interface IEmailService {

    ReqResult sendEmail(EmailMessage msg);
}
