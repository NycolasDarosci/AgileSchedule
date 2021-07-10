package br.com.agileschedule.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agileschedule.api.dto.UserDTO;
import br.com.agileschedule.api.form.CreateUserForm;
import br.com.agileschedule.api.form.UpdateUserForm;
import br.com.agileschedule.api.model.User;
import br.com.agileschedule.api.repository.PerfilRepository;
import br.com.agileschedule.api.repository.UserRepository;
import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PerfilRepository perfilRepository;

	public UserDTO newUserService(CreateUserForm createUserForm) throws NotFoundException {
		
		//Dentro do User a senha será criptografada
		User user = createUserForm.toUser();
		
		//Defindo o perfil do usuário como um usuário comum
		user.getPerfis().add(perfilRepository.findByDescricao("comum").get());
		userRepository.save(user);
		return user.toDTO();
	}

	
	public UserDTO updateUserService(UpdateUserForm updUserForm) throws NotFoundException{

		//Pegando as informações do usuário logado
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		user.setId(1L);
		//Deixando o user no estado managed para poder atualizar
		user = userRepository.findById(user.getId()).orElseThrow(() -> new NotFoundException("Usuário inválido."));
		
		//Verificando se o usuário atualizou algum campo e atualizando
		String nome = updUserForm.getNome();
		String email = updUserForm.getEmail();
		String senha = updUserForm.getSenha();
		if(nome != null) {
			user.setNome(updUserForm.getNome());
		}
		if(email != null) {
			user.setEmail(email);
		}
		if(senha != null) {
			user.setSenha(senha);
		}
		return user.toDTO();
	}


	public void updateTokenAluraService(UpdateUserForm updUserForm) throws NotFoundException {

		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		user.setId(1L);

		user = userRepository.findById(user.getId()).orElseThrow(() -> new NotFoundException("Usuário inválido."));
		
		user.setTokenAlura(updUserForm.getTokenAlura());
	}


	public void disableUserService(Long id) throws NotFoundException {

		//Ao invés de apagar, o usuário será desativado.
		//Tal método é acessado apenas pelo Administrador

		//Deixando o user no estado managed para atualizar sua situação
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

		user.setAtivo(false);
	}
}
