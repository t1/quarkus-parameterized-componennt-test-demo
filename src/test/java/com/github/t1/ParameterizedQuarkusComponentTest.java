package com.github.t1;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@QuarkusComponentTest
class ParameterizedQuarkusComponentTest {
    @Inject GreetingsRestController restController;

    @InjectMock GreetingsService greetings;

    @Test
    void hello() {
        given(greetings.greeting()).willReturn("Foo");

        var hello = restController.hello();

        then(hello).isEqualTo("Foo REST");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void hello(int number) {
        given(greetings.greeting()).willReturn(Integer.toString(number));

        var hello = restController.hello();

        then(hello).isEqualTo(number + " REST");
    }
}
