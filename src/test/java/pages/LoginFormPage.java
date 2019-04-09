package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

public class LoginFormPage extends BasePage {
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin(String login) {
        // Identificando o formulário de Login
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage digitarSenha(String senha) {
        // Identificando o formulário de Password
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);

        return this;
    }

    public SecretaPage clicarNoSignIn() {
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String senha) {
        digitarLogin(login);
        digitarSenha(senha);
        clicarNoSignIn();

        return new SecretaPage(navegador);
    }
}