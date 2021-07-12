package br.com.agileschedule.config;
/*
 * package br.com.agileschedule.config;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import br.com.agileschedule.entity.User; import
 * br.com.agileschedule.repository.UserRepository;
 * 
 * public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
 * 
 * @Autowired private TokenService tokenService;
 * 
 * @Autowired private UserRepository clienteRepository;
 * 
 * public AutenticacaoViaTokenFilter(TokenService service, UserRepository
 * repository) { this.tokenService = service; this.clienteRepository =
 * repository; }
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException { String token = recuperaToken(request);
 * boolean valido = tokenService.isTokenValido(token); if (valido) {
 * autenticarCliente(token); } }
 * 
 * private void autenticarCliente(String token) {
 * 
 * Long idUsuario = tokenService.getIdCliente(token); User cliente =
 * clienteRepository.findById(idUsuario).get();
 * UsernamePasswordAuthenticationToken authentication = new
 * UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
 * SecurityContextHolder.getContext().setAuthentication(authentication); }
 * 
 * private String recuperaToken(HttpServletRequest request) { String token =
 * request.getHeader("Authorization"); if (token == null || token.isEmpty() ||
 * !token.startsWith("Bearer ")) { return null; } return token.substring(7,
 * token.length()); }
 * 
 * }
 */