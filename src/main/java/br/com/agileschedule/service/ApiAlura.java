/*
 * package br.com.agileschedule.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.reactive.function.client.WebClient;
 * 
 * import br.com.agileschedule.entity.CourseProgress; import
 * br.com.agileschedule.repository.UserRepository;
 * 
 * @Service public class ApiAlura {
 * 
 * @Autowired private WebClient webClient;
 * 
 * @Autowired private UserRepository repo;
 * 
 * // chamada para os dados da alura public CourseProgress obterJson() {
 * 
 * // pegar o token colocado pelo usuario repo.findByToken();
 * 
 * // continuar...
 * this.webClient.method(HttpMethod.GET).uri("/api/dashboard/{token}") } }
 */
