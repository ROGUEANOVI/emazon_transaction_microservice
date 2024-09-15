package com.pragma.emazon.transaction_microservice.infrastructure.out.security.adapter;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.emazon.transaction_microservice.infrastructure.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static com.pragma.emazon.transaction_microservice.infrastructure.constant.SecurityMessages.USER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserContextAdapterTest {

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private DecodedJWT decodedJWT;

    @Mock
    private Claim claim;

    @InjectMocks
    private UserContextAdapter userContextAdapter;

    private String validToken = "validToken";
    private Long expectedUserId = 123L;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
    }

    @Test
    void getAuthenticatedUserIdShouldReturnUserIdWhenTokenIsValid() {

        when(authentication.getDetails()).thenReturn(validToken);
        when(jwtUtil.validateToken(validToken)).thenReturn(decodedJWT);

        when(jwtUtil.extactSpecifiedClaim(decodedJWT, USER_ID)).thenReturn(claim);

        when(claim.asLong()).thenReturn(expectedUserId);

        Long actualUserId = userContextAdapter.getAuthenticatedUserId();
        assertEquals(expectedUserId, actualUserId);

        verify(jwtUtil, times(1)).validateToken(validToken);
        verify(jwtUtil, times(1)).extactSpecifiedClaim(decodedJWT, USER_ID);
        verify(claim, times(1)).asLong();
    }


    @Test
    void getAuthenticatedUserIdShouldThrowExceptionWhenTokenIsInvalid() {

        String invalidToken = "invalidToken";
        when(authentication.getDetails()).thenReturn(invalidToken);
        when(jwtUtil.validateToken(invalidToken)).thenThrow(new IllegalArgumentException("Invalid token"));

        assertThrows(IllegalArgumentException.class, () -> userContextAdapter.getAuthenticatedUserId());

        verify(jwtUtil, times(1)).validateToken(invalidToken);
        verify(jwtUtil, never()).extactSpecifiedClaim(any(), anyString());
    }

    @Test
    void getAuthenticatedUserIdShouldThrowExceptionWhenNoAuthenticationPresent() {

        SecurityContextHolder.clearContext();

        assertThrows(NullPointerException.class, () -> userContextAdapter.getAuthenticatedUserId());

        verify(jwtUtil, never()).validateToken(anyString());
    }
}
