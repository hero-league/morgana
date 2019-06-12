package com.morgana.account.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.morgana.account.domain.Account;
import com.morgana.account.mapper.AccountMapper;
import com.morgana.account.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.IdUtils;
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
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private IdUtils idUtils;

    @Override
    @LcnTransaction
    @Transactional
    public Account create(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        account.setId(idUtils.create());
        this.save(account);
        if (StringUtils.isBlank(accountDTO.getCreateId())){
            throw new BaseException("0000");
        }
        return account;
    }
}
