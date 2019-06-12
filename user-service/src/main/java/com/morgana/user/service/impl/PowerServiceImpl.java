package com.morgana.user.service.impl;

import com.morgana.user.domain.Power;
import com.morgana.user.mapper.PowerMapper;
import com.morgana.user.service.PowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {

}
