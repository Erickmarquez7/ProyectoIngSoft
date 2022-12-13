/**
 * Clases para al autorizacion de los diferentes roles de cada usuario
 */
package com.example.demo.models.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.demo.models.service.IUsuarioService;
import com.example.demo.models.entity.Usuario;;



@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		//Donde extraeremos los datos del usario, primero lo encontramos por nombre		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		//luego extraemos cada uno de los atributos del usuario
		info.put("id", usuario.getId());
		info.put("nombre", usuario.getNombre());
		info.put("apellido paterno", usuario.getPaterno());
		info.put("apellido materno", usuario.getMaterno());
		info.put("apellido carrera", usuario.getCarrera());
		info.put("apellido celular", usuario.getCelular());
		info.put("email", usuario.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}

