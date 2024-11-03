package com.sacavix.hellospringwebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
public class TestController {

    private final PhoneRestClientReactive phoneRestClientReactive;
    private final PhoneRestClientBlocking phoneRestClientBlocking;

    public TestController(PhoneRestClientReactive phoneRestClientReactive,
                          PhoneRestClientBlocking phoneRestClientBlocking) {
        this.phoneRestClientReactive = phoneRestClientReactive;
        this.phoneRestClientBlocking = phoneRestClientBlocking;
    }

    @GetMapping("/phones-reactive")
    public Mono<List<Phone>> getPhonesReactive() {
            return phoneRestClientReactive.getPhones();
    }

    @GetMapping("/phones-blocking")
    public Mono<List<Phone>> getPhonesBlocking() {
        return phoneRestClientBlocking.getPhones();
    }

}
