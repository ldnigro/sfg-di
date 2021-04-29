package lsoft.springframework.sfgdi.Repository;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String getGreeting() {
        return "Hello World - English";
    }
}
