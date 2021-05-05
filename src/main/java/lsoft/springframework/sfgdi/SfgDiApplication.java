package lsoft.springframework.sfgdi;

import lsoft.springframework.sfgdi.config.SfgConfiguration;
import lsoft.springframework.sfgdi.config.SfgConstructorConfig;
import lsoft.springframework.sfgdi.controllers.*;
import lsoft.springframework.sfgdi.datasource.FakeDataSource;
import lsoft.springframework.sfgdi.services.PrototypeBean;
import lsoft.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"lsoft.springframework.sfgdi","com.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController",PetController.class);
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myCtrl = (MyController) ctx.getBean("myController");

		System.out.println(myCtrl.sayHello());

		System.out.println("----------property----------------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------setter-----");
		SetterInjectedController setterInjectedController = (SetterInjectedController)ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---------constructor-----");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("---------Bean Scope-----");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("URL: " + fakeDataSource.getJdbcurl());
		System.out.println("user: " + fakeDataSource.getUsername());
		System.out.println("password: " + fakeDataSource.getPassword());

		System.out.println("---------Config Bind-----");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getJdbcurl());
		System.out.println(sfgConfiguration.getUsername());

		System.out.println("---------Config Constructor-----");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getJdbcurl());
		System.out.println(sfgConstructorConfig.getUsername());



	}

}
