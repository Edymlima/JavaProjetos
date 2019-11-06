package br.com.agenda.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean
public class Hello {
	@PostConstruct
    public void init(){
        System.out.println(" Bean executado! ");
    }
     
    public String getMessage(){
        return "Hello World JSF!";
    }	
}
