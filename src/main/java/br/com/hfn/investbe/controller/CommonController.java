package br.com.hfn.investbe.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.hfn.investbe.config.dto.UsuarioAuthDTO;

@CrossOrigin
@Controller
public class CommonController {

	public UsuarioAuthDTO getAuth(){
        return (UsuarioAuthDTO) SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isAuthenticated(){
        return getAuth().isAuthenticated();
    }
}
