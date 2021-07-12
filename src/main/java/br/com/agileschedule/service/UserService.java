package br.com.agileschedule.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.config.annotation.AlreadyBuiltException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import br.com.agileschedule.dto.UserDTO;
import br.com.agileschedule.form.CreateUserForm;
import br.com.agileschedule.form.UpdateUserForm;
import br.com.agileschedule.model.User;
import br.com.agileschedule.repository.PerfilRepository;
import br.com.agileschedule.repository.UserRepository;
import javassist.NotFoundException;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PerfilRepository perfilRepository;

	@Autowired
	JavaMailSender jMailSender;

	public UserDTO newUserService(CreateUserForm createUserForm, String url)
			throws NotFoundException, UnsupportedEncodingException, MessagingException {
		
		User user = createUserForm.toUser();

		//Defindo o perfil do usuário como um Cliente (padrão)
		user.getPerfis().add(perfilRepository.findByDescricao("Cliente")
		.orElseThrow(() -> new NotFoundException("Perfil cliente não encontrado,"
		+ " verifique o insert inicial.")));
		
		//Definindo o código de verificação que será enviado ao email
		user.setTokenEmail(RandomString.make(32));

		userRepository.save(user);

		enviarEmailVerificacao(user, url);

		return user.toDTO();
	}

	public void enviarEmailVerificacao(User user, String url) throws UnsupportedEncodingException, MessagingException {
		String remetente = "Equipe AgileSchedule";
		String assunto = "Verificar seu registro AgileSchedule";
		String urlVerificacao = url + "/cadastro/verificarEmail?token=" + user.getTokenEmail();
		String corpoEmail = user.getNome() + ",</p>";
		corpoEmail += "<p>Para verificar seu cadastro na Agile Schedule, clique no link abaixo</p>";
		
		corpoEmail += "<h3><a href=\"" + urlVerificacao + "\">VERIFICAR</a></h3>";
		
		corpoEmail += "<p>Qualquer dúvida entre em contato com o nosso suporte enviando uma mensagem em nosso " +
		"<a href=\"https://twitter.com/ScheduleAgile\">Twitter</a>, " +	
		" ou entre em nosso servidor do " +	
		"<a href=\"https://discord.gg/9b69GWKnR3\">Discord</a></p>";
		
		corpoEmail += "<p>Atenciosamente,<br>Equipe AgileSchedule.</p>.";

		MimeMessage mimeMessage= jMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		helper.setFrom("bolsistaestagiario@gmail.com", remetente);
		helper.setTo(user.getEmail());
		helper.setSubject(assunto);
		helper.setText(corpoEmail, true);

		jMailSender.send(mimeMessage);
	}

	public boolean verificarEmailService(String token) {
		Optional<User> user = userRepository.findByTokenEmail(token);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("Usuario não localizado");
		}
		if(user.get().getAtivo()) {
			throw new IllegalStateException("Usuário já verificado");
		}
		user.get().setAtivo(true);
		return true;
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
