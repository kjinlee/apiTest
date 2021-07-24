package com.my.shop.fruit.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 서버에 접근 가능한 client 설정
        clients.inMemory()
                .withClient("client")
                .secret("{noop}secret")
                .authorizedGrantTypes("authorization_code", "implicit","password", "client_credentials","refresh_token") //암시적
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(240)
                .scopes("read").redirectUris("http://localhost:8090/showList").autoApprove(true);
    }

    //(2)
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //@formatter:off
        endpoints
                .authenticationManager(authenticationManager) // Bean 등록은 SecurityConfig 에서 등록
        ;
        //@formatter:on
    }
}
