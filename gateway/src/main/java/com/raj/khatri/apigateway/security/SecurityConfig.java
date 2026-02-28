package com.raj.khatri.apigateway.security;


import com.raj.khatri.apigateway.applicationConstants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.ReferrerPolicyServerHttpHeadersWriter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Configuration
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(
                                "/signup",
                                "/login",
                                "/",
                                "/home",
                                "/NewUser",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/logout",
                                "/actuator/**"
                        ).permitAll()
                        .pathMatchers("/User/**").authenticated()
                        .anyExchange().authenticated()
                )
                .headers(headers -> headers.contentTypeOptions(Customizer.withDefaults())
                        .referrerPolicy(ref -> ref.policy(ReferrerPolicyServerHttpHeadersWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN))
                        .hsts(hsts -> hsts.maxAge(Duration.ofDays(31536000)).includeSubdomains(true)))
                //    .contentSecurityPolicy(csp -> csp
                //          .policyDirectives("script-src 'self'; img-src 'self'; frame-src 'self';")))
                .httpBasic(httpBasicSpec -> httpBasicSpec.disable())
                .formLogin(formLoginSpec -> formLoginSpec.disable())

                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));


        return http.build();
    }

    @Bean
    public ReactiveJwtDecoder reactiveJwtDecoder() {

        SecretKey key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), ApplicationConstants.withAlgorithm);
        return NimbusReactiveJwtDecoder.withSecretKey(key).build();
    }


}


