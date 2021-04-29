package lsoft.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import lsoft.springframework.sfgdi.Repository.EnglishGreetingRepository;
import lsoft.springframework.sfgdi.Repository.EnglishGreetingRepositoryImpl;
import lsoft.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() { return new PetServiceFactory(); }

    @Bean
    @Profile({"dog","default"})
    PetService dogPetService(){
        return petServiceFactory().getPetService("dog");
    }

    @Bean
    @Profile({"cat"})
    PetService catPetService(){
        return petServiceFactory().getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishService(){
        return new I18nSpanishGreetingService();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    // @Bean -- Configurado en el XML
    //ConstructorGreetingService constructorGreetingService() {
    //    return new ConstructorGreetingService();
    //}

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new  SetterInjectedGreetingService();
    }

}
