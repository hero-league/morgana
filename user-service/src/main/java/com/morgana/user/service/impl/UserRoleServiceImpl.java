package com.morgana.user.service.impl;

import com.morgana.user.domain.UserRole;
import com.morgana.user.mapper.UserRoleMapper;
import com.morgana.user.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
