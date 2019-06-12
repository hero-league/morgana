package com.morgana.account.service;

import com.morgana.account.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.morgana.common.domain.account.AccountDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
public interface AccountService extends IService<Account> {

    Account create(AccountDTO accountDTO);

}
