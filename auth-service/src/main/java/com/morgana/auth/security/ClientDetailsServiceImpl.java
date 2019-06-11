package com.morgana.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientDetailsImpl clientDetails;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if (!clientDetails.getClientId().equals(clientId)){
            throw new ClientRegistrationException("invalid clientId");
        }
        return clientDetails;
    }
}
