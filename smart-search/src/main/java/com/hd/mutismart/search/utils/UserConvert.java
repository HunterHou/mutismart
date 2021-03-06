package com.hd.mutismart.search.utils;

import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.service.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static EsUser convert(User user) {
        EsUser result = new EsUser();
        BeanUtils.copyProperties(user, result);
        return result;
    }

    public static List<EsUser> convert(List<User> users) {
        List<EsUser> result = new ArrayList<>();
        for (User user : users) {
            EsUser esUser = new EsUser();
            BeanUtils.copyProperties(user, esUser);
            result.add(esUser);
        }
        return result;
    }
}
