package ru.netology.controller;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import javax.validation.Valid;

import java.util.List;

import ru.netology.service.AuthorizationService;
import ru.netology.authority.Authorities;
import ru.netology.model.Account;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
    AuthorizationService service;

	AuthorizationController(AuthorizationService service) {
		this.service = service;
	}
    
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Account  account) {
    //public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(account);
    }
}
