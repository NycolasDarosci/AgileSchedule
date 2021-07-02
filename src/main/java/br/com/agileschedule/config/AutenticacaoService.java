/*
 * package br.com.agileschedule.config;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import br.com.agileschedule.entity.User; import
 * br.com.agileschedule.repository.UserRepository;
 * 
 * 
 * @Service public class AutenticacaoService implements UserDetailsService {
 * 
 * @Autowired private UserRepository clienteR;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * Optional<User> cliente = clienteR.findByEmail(username);
 * if(cliente.isPresent()) { return cliente.get(); }
 * 
 * throw new UsernameNotFoundException("Dados Inválidos!"); }
 * 
 * }
 */
