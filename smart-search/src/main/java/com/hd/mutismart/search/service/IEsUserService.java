package com.hd.mutismart.search.service;

import java.util.List;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;

public interface IEsUserService {
    ReqResult save(EsUser user);

    ReqResult save(List<EsUser> users);

    ReqResult update(EsUser user);

    ReqResult delete(EsUser user);

    ReqResult search(EsUser user);

    ReqResult clear();

    ReqResult sync();
}
