package com.sacavix.hellospringwebflux;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

//https://api.restful-api.dev/objects

@Component
public class PhoneRestClientReactive {

        private final WebClient webClient;

        public PhoneRestClientReactive() {
            this.webClient = WebClient.builder().baseUrl("https://api.restful-api.dev").build();
        }

        public Mono<List<Phone>> getPhones() {
            Mono<List<Phone>> response = webClient.get()
                    .uri("/objects")
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Phone>>() {}).
            doOnNext(list -> list.sort(Comparator.comparing(Phone::getName))).log();

            SleepUtils.sleep();
            return response;
        }

}
