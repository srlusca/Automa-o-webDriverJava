package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clicarSignIn() {
        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        return new LoginFormPage(navegador);
    }

    public RegisterLoginPage clicarRegistrarSe() {
        // Clicar no elemento que possui o id "signup"
        navegador.findElement(By.id("signup")).click();

        return new RegisterLoginPage(navegador);
    }

}
