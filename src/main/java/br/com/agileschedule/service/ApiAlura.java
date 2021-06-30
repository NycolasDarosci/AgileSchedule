package br.com.agileschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.agileschedule.entity.CourseProgress;

@Service
public class ApiAlura {

    @Autowired
    private WebClient webClient;

    @Autowired
    private UserService userService;

    // chamada para os dados da alura
    public CourseProgress obterJson() {
        userService.findByToken();

        this.webClient.method(HttpMethod.GET).uri("/api/dashboard/{token}")
    }
}
