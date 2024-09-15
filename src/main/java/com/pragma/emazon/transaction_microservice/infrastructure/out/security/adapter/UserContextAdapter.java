package com.pragma.emazon.transaction_microservice.infrastructure.out.security.adapter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IUserContextPort;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.SecurityMessages;
import com.pragma.emazon.transaction_microservice.infrastructure.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserContextAdapter implements IUserContextPort {

    private final JwtUtil jwtUtil;

    @Override
    public Long getAuthenticatedUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = (String) authentication.getDetails();
        DecodedJWT decodedToken = jwtUtil.validateToken(token);

        return jwtUtil.extactSpecifiedClaim(decodedToken, SecurityMessages.USER_ID).asLong();
    }
}
