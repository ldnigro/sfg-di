package lsoft.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

public class PropertyInjectedGreetingService implements GreetingService{

    public String sayGreeting() {
        return "Hello World!!! -- Property";
    }
}
