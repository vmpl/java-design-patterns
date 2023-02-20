package pl.vm.javaguild.designpatterns.pattern.creational.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Builder functionality tests")
class WebBrowserTest {

  private static final String NAME_BRAVE = "Brave";
  private static final String ENGINE_CHROMIUM = "Chromium";
  private static final String VERSION_BRAVE_LATEST = "1.47.186";

  @Test
  void shouldBuildObject_givenAllFieldsProvided() {
    //arrange + act
    final var braveBrowser = WebBrowser.builder().name(NAME_BRAVE).engine(ENGINE_CHROMIUM)
        .version(VERSION_BRAVE_LATEST).build();

    //assert
    assertThat(braveBrowser).isNotNull();
    assertThat(braveBrowser.getName()).isEqualTo(NAME_BRAVE);
    assertThat(braveBrowser.getEngine()).isEqualTo(ENGINE_CHROMIUM);
    assertThat(braveBrowser.getVersion()).isEqualTo(VERSION_BRAVE_LATEST);
  }

  @Test
  void shouldBuildObject_givenOnlyMandatoryFieldsProvided() {
    //arrange + act
    final var braveBrowser = WebBrowser.builder().name(NAME_BRAVE).engine(ENGINE_CHROMIUM)
        .build();

    //assert
    assertThat(braveBrowser).isNotNull();
    assertThat(braveBrowser.getName()).isEqualTo(NAME_BRAVE);
    assertThat(braveBrowser.getEngine()).isEqualTo(ENGINE_CHROMIUM);
    assertThat(braveBrowser.getVersion()).isNull();
  }

  @Test
  void shouldThrowAnException_givenMissingMandatoryField() {
    //arrange + act + assert
    assertThrows(IllegalArgumentException.class,
        () -> WebBrowser.builder().name(NAME_BRAVE).build());
  }

  @Test
  void shouldThrowAnException_givenNullAsMandatoryFieldArgument() {
    //arrange + act + assert
    assertThrows(NullPointerException.class,
        () -> WebBrowser.builder().name(null).build());
  }

}
