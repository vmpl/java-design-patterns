package pl.vm.javaguild.designpatterns;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.DemoApp;

@SpringBootApplication
public class JavaDesignPatternsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaDesignPatternsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("##############################################################\n");
        System.out.println("      This is a simple example of factory-method pattern\n");
        System.out.println("##############################################################\n");
        DemoApp demoApp = new DemoApp();
        demoApp.runDemoApp();
    }
}
