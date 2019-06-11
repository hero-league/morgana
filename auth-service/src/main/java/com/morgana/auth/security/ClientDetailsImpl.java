package com.morgana.auth.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@RefreshScope
@Component("clientDetails")
public class ClientDetailsImpl implements ClientDetails {

    private static final long serialVersionUID = 7992659824052153354L;

    @Value("${spring.security.oauth.clientId:}")
    private String clientId;

    @Value("${spring.security.oauth.secret:}")
    private String secret;

    private Set<String> authorizedGrantTypes;

    private Set<String> scope;

    private  Collection<GrantedAuthority> authorities;

    public ClientDetailsImpl() {
        Set<String> authorizedGrantTypes = new HashSet<>();
        authorizedGrantTypes.add("authorization_code");
        authorizedGrantTypes.add("password");
        authorizedGrantTypes.add("refresh_token");
        this.authorizedGrantTypes = authorizedGrantTypes;
        Set<String> scope = new HashSet<>();
        scope.add("all");
        this.scope = scope;
        this.authorities = new ArrayList<>();
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.secret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return this.scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
