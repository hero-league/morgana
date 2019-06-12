package com.morgana.user.service;

import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.exception.BaseException;
import com.morgana.user.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
public interface UserService extends IService<User> {

    User create(AuthUser authUser) throws BaseException;

}
