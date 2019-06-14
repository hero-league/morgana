package com.morgana.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.IdUtils;
import com.morgana.user.client.AccountClinet;
import com.morgana.user.domain.User;
import com.morgana.user.mapper.UserMapper;
import com.morgana.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private IdUtils idUtils;

    @Autowired
    private AccountClinet accountClinet;

    @Override
    public User create(AuthUser authUser) throws BaseException {
        User user = new User();
        if (StringUtils.isBlank(authUser.getCode())){
            throw new BaseException("参数错误");
        }
        if (StringUtils.isBlank(authUser.getPwd())){
            throw new BaseException("参数错误");
        }
        user.setCode(authUser.getCode());
        user.setMobile(authUser.getCode());
        user.setId(idUtils.create());
        this.save(user);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(user.getId());
        accountDTO.setAccount(new BigDecimal(0));
        accountDTO.setLockAccount(new BigDecimal(0));
        accountClinet.create(accountDTO);
        return user;
    }
}
