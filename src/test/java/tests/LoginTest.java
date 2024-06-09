package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import site.pages.LoginPage;

import java.util.stream.Stream;

public class LoginTest extends TestRunner
{
    private static final String BASE_PASSWORD = "secret_sauce";

    private static Stream<Arguments> loginsAndPasswords() {
        return Stream.of(
                Arguments.of("username", BASE_PASSWORD),
                Arguments.of("username", "password"),
                Arguments.of("standard_user", ""),
                Arguments.of("locked_out_user", BASE_PASSWORD)
        );
    }

    @ValueSource( strings = {"standard_user","problem_user","performance_glitch_user"})
    @ParameterizedTest
    public void validLoginTest(String username)
    {
        LoginPage login = new LoginPage(driver);

        login.setUserName(username);
        login.setPassword(BASE_PASSWORD);

        Assertions.assertDoesNotThrow(login::loginBtnClick);

    }

    @MethodSource("loginsAndPasswords")
    @ParameterizedTest
    public void invalidLoginTest(String username, String password)
    {
        LoginPage login = new LoginPage(driver);

        login.setUserName(username);
        login.setPassword(password);

        Assertions.assertThrows(RuntimeException.class,login::loginBtnClick);

    }


}
