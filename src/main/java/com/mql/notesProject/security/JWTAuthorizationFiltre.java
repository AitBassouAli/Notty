package com.mql.notesProject.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFiltre extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// on va permtter a angular d'envoyer les requetes a partir d'un domaine
		// different
		System.out.println("*******************" + response.toString());
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,"
				+ "Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin," + "Authorization,Access-Control-Allow-Credentials");
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.addHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,"
					+ "Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");

		}
		String jwtToken = request.getHeader(SecurityConstants.HEADER_STRING);
		System.out.println("*************" + jwtToken);
		if (jwtToken == null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		// get the claimes from jwttoken
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

		// get username form claimes
		String username = claims.getSubject();
		System.out.println("***********************" + username);
		// get the roles
		ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
		// pour charge les roles a spring security il faut creer une collections des
		// GarnteAuthority
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		});

		UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username, null,
				authorities);
		// en va charge lutilisateur dans le context de spring security
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		filterChain.doFilter(request, response);

	}

}
