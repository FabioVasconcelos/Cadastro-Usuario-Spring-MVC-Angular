package br.com.fabio.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fabio.model.*;
import br.com.fabio.service.UsuarioService;

@Controller
public class HomeController {
	@Autowired
	UsuarioService usuarioService;
	@RequestMapping("/")
	public String irParaHome(){
		System.out.println("Chamou /");

		Collection<Usuario> lista;
		lista =  usuarioService.buscarTodos();
		
		if (lista.size() == 0 || lista.isEmpty())
		{
			carregar();
		}
		
		return "index";
	}
	
	public  void carregar()
	{
		String arquivo = "nomes.txt";
		
	    try {
	        FileReader arq = new FileReader(arquivo);
	        BufferedReader lerArq = new BufferedReader(arq);
	        String linha="";
	        try {
	            
	           while(linha != null ){
	           Usuario usuario = new Usuario();
	                linha = lerArq.readLine();
	                
	                if (linha != null)
	                {
	             
	                usuario.setNome(linha);
	                usuarioService.cadastrarCarregamento(usuario);
	                }
	            }
	            arq.close();
	          
	        } catch (IOException ex) {
	            System.out.println("Erro: Não foi possível ler o arquivo!");
	         
	        }
	    } catch (FileNotFoundException ex) {
	        System.out.println("Erro: Arquivo não encontrado!");
	      
	    }
	}
}
