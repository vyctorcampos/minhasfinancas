package com.example.minhasfinancas.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minhasfinancas.exception.ErroAutenticacao;
import com.example.minhasfinancas.exception.RegraNegocioException;
import com.example.minhasfinancas.model.repository.UsuarioRepository;
import com.example.minhasfinancas.service.UsuarioService;
import com.jvyctor.minhasfinancas.model.entity.Usuario;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{ 
	
	private UsuarioRepository repository; // dependencia
	
	@Autowired 
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();									//receber a dependencia via contrutor
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		repository.findByEmail(email);
		
		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuario não encontrado para o email informado");
		}
		
		if(usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException ("Já existe um usuário cadastrado com este email");
		}
		
	}

}
