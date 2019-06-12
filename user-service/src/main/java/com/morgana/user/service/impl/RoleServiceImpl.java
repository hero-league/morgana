package com.morgana.user.service.impl;

import com.morgana.user.domain.Role;
import com.morgana.user.mapper.RoleMapper;
import com.morgana.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
