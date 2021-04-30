package lsoft.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Create singleton bean!!");

    }

    public String getMyScope(){
        return "I'm a singleton";
    }

}
