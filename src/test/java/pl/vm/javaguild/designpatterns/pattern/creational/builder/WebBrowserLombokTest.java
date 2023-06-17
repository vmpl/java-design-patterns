package pl.vm.javaguild.designpatterns.pattern.creational.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Builder functionality tests")
class WebBrowserLombokTest {

  private static final String NAME_BRAVE = "Brave";
  private static final String ENGINE_CHROMIUM = "Chromium";
  private static final String VERSION_BRAVE_LATEST = "1.47.186";

  @Test
  void shouldBuildObject_givenAllFieldsProvided() {
    //given + when
    final var braveBrowser = WebBrowserLombok.builder()
        .name(NAME_BRAVE)
        .engine(ENGINE_CHROMIUM)
        .version(VERSION_BRAVE_LATEST)
        .build();

    //then
    assertThat(braveBrowser).isNotNull();
    assertThat(braveBrowser.getName()).isEqualTo(NAME_BRAVE);
    assertThat(braveBrowser.getEngine()).isEqualTo(ENGINE_CHROMIUM);
    assertThat(braveBrowser.getVersion()).isEqualTo(VERSION_BRAVE_LATEST);
  }

  @Test
  void shouldBuildObject_givenSomeFieldsProvided() {
    //given + when
    final var braveBrowser = WebBrowserLombok.builder()
        .name(NAME_BRAVE)
        .engine(ENGINE_CHROMIUM)
        .build();

    //then
    assertThat(braveBrowser).isNotNull();
    assertThat(braveBrowser.getName()).isEqualTo(NAME_BRAVE);
    assertThat(braveBrowser.getEngine()).isEqualTo(ENGINE_CHROMIUM);
    assertThat(braveBrowser.getVersion()).isNull();
  }


}
