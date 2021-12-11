//package net.devnguyen.config.security;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import net.devnguyen.axiemanagement.config.security.jwt.BasicJWTTokenProvider;
//import net.devnguyen.axiemanagement.constants.Const;
//import net.devnguyen.axiemanagement.dto.auth.BasicAuthority;
//import net.devnguyen.axiemanagement.exception.ErrorResponseWriter;
//import net.devnguyen.axiemanagement.exception.ResponseException;
//import net.devnguyen.axiemanagement.exception.errorcode.InternalServerError;
//import net.devnguyen.axiemanagement.service.UserService;
//import org.springframework.http.MediaType;
//import org.springframework.lang.NonNull;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Locale;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class CustomAuthenticationFilter extends OncePerRequestFilter {
//
//    private final ErrorResponseWriter errorResponseWriter;
//    private final BasicJWTTokenProvider basicJWTTokenProvider;
//    private final UserService userService;
//
//
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
//            throws ServletException, IOException {
//        log.warn("CustomAuthenticationFilter doFilterInternal");
//        String token = getJwtFromRequest(request);
//        if (!StringUtils.hasLength(token)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        try {
//            var claimsJwt = basicJWTTokenProvider.parseTokenToClaims(token);
//            var username = claimsJwt.getSubject();
//            var authority = getAuthority(username);
//
//            BasicAuthentication authentication = new BasicAuthentication(authority, claimsJwt);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            filterChain.doFilter(request, response);
//        } catch (ResponseException e) {
//            errorResponseWriter.writeErrorResponse(response, MediaType.APPLICATION_JSON_VALUE, e.getError());
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            errorResponseWriter.writeErrorResponse(response, MediaType.APPLICATION_JSON_VALUE, InternalServerError.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    /**
//     * query in db by username
//     *
//     * @param username
//     * @return
//     */
//    private BasicAuthority getAuthority(String username) {
//        return userService.getUserAuthority(username);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        // Kiểm tra xem header Authorization có chứa thông tin jwt không
//        if (StringUtils.hasText(bearerToken) && bearerToken.toLowerCase(Locale.ROOT).startsWith(Const.TOKEN_TYPE.toLowerCase(Locale.ROOT) + " ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) {
//        return false;
//    }
//}
