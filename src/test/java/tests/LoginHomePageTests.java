package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.provider.ValueSource;
import site.pages.LoginPage;

public class LoginHomePageTests extends TestRunner
{
    private final String PASSWORD = "secret_sauce" ;

    @ValueSource( strings = {"standard_user","locked_out_user","problem_user","performance_glitch_user"})
    @ParameterizedTest
    public void validLoginTest(String username)
    {
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);

        login.setUserName(username);
        login.setPassword(PASSWORD);

        Assertions.assertDoesNotThrow(login::loginBtnClick);

    }


}
