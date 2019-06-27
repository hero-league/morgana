package com.morgana.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.morgana.account.domain.Account;
import com.morgana.account.mapper.AccountMapper;
import com.morgana.account.service.AccountService;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private IdUtils idUtils;

    @Override
    @LcnTransaction
    @Transactional
    public Account create(AccountDTO accountDTO) throws RuntimeException{
        log.info("groupId : {} ", TracingContext.tracing().groupId());
        if (true){
            throw new RuntimeException("create account error");
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        account.setId(idUtils.create());
        this.save(account);
        return account;
    }
}
