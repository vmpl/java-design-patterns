package pl.vm.javaguild.designpatterns;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JavaDesignPatternsApplicationTests {

    @Test
    void contextLoads() {
        // given
        var message = "Java guild in vm.pl";

        // when
        message += " is awesome!";

        // then
        assertThat(message).isEqualTo("Java guild in vm.pl is awesome!");
    }
}
