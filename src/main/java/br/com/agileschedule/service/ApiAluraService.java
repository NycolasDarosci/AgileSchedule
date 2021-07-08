package br.com.agileschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.agileschedule.entity.User;
import br.com.agileschedule.form.AluraForm;
import reactor.core.publisher.Mono;

@Service
public class ApiAluraService {

    @Autowired
    private WebClient webClientAlura;

    @Autowired
    private UserService userService;

    // chamada para os dados da alura
    public AluraForm tokenAlura() {
        
        // pegar o token colocado pelo usuario
        userService.findByToken();
       //User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        user.setTokenAlura("602d4fbb89b3f27bae02799e4ee06135dd705bd3d96bc141f8444b94f88e36c2");
        Mono<AluraForm> monoCourseProgress = this.webClientAlura
        		.method(HttpMethod.GET)
        		.uri("/dashboard/", user.getTokenAlura())
        		.retrieve()
        		.bodyToMono(AluraForm.class);
        AluraForm aluraF = monoCourseProgress.block();
        return aluraF;
      
    }
}
