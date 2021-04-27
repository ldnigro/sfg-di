package lsoft.springframework.sfgdi.Repository;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String geetGreeting() {
        return "Hello World - English";
    }
}
