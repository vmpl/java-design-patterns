package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.adapter.GiftFactoryAdapter;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.adapter.GiftStoreAdapter;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.exception.GiftNotCreatedException;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.Gift;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.GiftType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GiftStoreAdapterTest {

    @ParameterizedTest(name = "{index}: GiftType: {0} ")
    @EnumSource(value = GiftType.class, names = {"TICKET"}, mode = EnumSource.Mode.EXCLUDE)
    void should_create_proper_gift_based_on_given_type(GiftType giftType) {
        // given
        GiftStore giftStore = createGiftStore();

        // when
        Gift gift = giftStore.buyGift(giftType);

        // then
        assertThat(gift).isNotNull();
        assertThat(giftStore.getFactory())
                .isNotNull()
                .isInstanceOf(GiftFactoryAdapter.class);
    }

    private static GiftStore createGiftStore() {
        return new GiftStoreAdapter(
                new GiftFactoryAdapter()
        );
    }

    @ParameterizedTest(name = "{index}: GiftType: {0} ")
    @EnumSource(value = GiftType.class, names = {"TICKET"}, mode = EnumSource.Mode.INCLUDE)
    void should_fail_create_proper_gift_based_on_given_type_was_not_found_in_factory(GiftType giftType) {
        // given
        GiftStore giftStore = createGiftStore();

        // when & then
        GiftNotCreatedException exception = assertThrows(
                GiftNotCreatedException.class,
                () -> giftStore.buyGift(giftType)
        );
        assertThat(exception).hasMessage("Gift with type %s could not be created.", giftType);
    }

    @Test
    void should_fail_create_proper_gift_based_on_given_type_if_type_was_null() {
        // given
        GiftStore giftStore = createGiftStore();
        GiftType giftType = null;

        // when & then
        assertThrows(
                NullPointerException.class,
                () -> giftStore.buyGift(giftType)
        );
    }
}
