package br.com.fabio.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.fabio.Arquivo;
import br.com.fabio.model.Usuario;
@Service
public class UsuarioService {

	Map<Integer, Usuario> usuarios= new HashMap<>();
	Integer proximoId = 1;
	
	public Usuario cadastrarCarregamento(Usuario usuario)
	{
		
		usuario.setId(proximoId);
		
		proximoId++;
		
		usuarios.put(usuario.getId(), usuario);
		        
		return usuario;
	}
	
	public Usuario cadastrar(Usuario usuario)
	{
		
		usuario.setId(proximoId);
		
		proximoId++;
		
		usuarios.put(usuario.getId(), usuario);
		
		String arq = "nomes.txt";
		//GRAVAÇÃO
	    String texto = usuario.getNome();
	    
	    if(Arquivo.Write(arq, texto))
	        System.out.println("Arquivo salvo com sucesso!");
	    else
	        System.out.println("Erro ao salvar o arquivo!");
		return usuario;
	}
	
	public Collection<Usuario> buscarTodos() {
	
		return usuarios.values();
	}
}
