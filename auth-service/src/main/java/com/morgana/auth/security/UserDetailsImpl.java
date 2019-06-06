package com.morgana.auth.security;

import com.morgana.common.domain.user.AuthUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: security 用户对象
 */
@Data
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = -2636609458742965698L;

    private String id;
    private String username;
    private String password;
    private String status;
    private List<AuthUser.UserRole> userRoles;

    public UserDetailsImpl(AuthUser authUser) {
        this.id = authUser.getId();
        this.username = authUser.getCode();
        this.password = authUser.getPwd();
        this.status = authUser.getStatus();
        this.userRoles = authUser.getUserRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        userRoles.forEach(role ->{
            authorityList.add(new SimpleGrantedAuthority(role.getCode()));
        });
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }
}
