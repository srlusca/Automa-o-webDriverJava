package pages;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Generator;
import support.Screenshots;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterLoginPage extends BasePage {
    @Rule
    public TestName test = new TestName();

    public RegisterLoginPage(WebDriver navegador) {
        super(navegador);
    }

    public RegisterLoginPage registrarName(String regName) {
        // Preencher o campo Name de id "sigunpbox" e name = "name"
        navegador.findElement(By.id("signupbox")).findElement(By.name("name")).sendKeys(regName);

        return this;
    }

    public RegisterLoginPage registrarLogin(String regLogin) {
        // Preencher o campo Login de id "sigunpbox" e name = "login"
        navegador.findElement(By.id("signupbox")).findElement(By.name("login")).sendKeys(regLogin);

        return this;
    }

    public RegisterLoginPage registerSenha(String regSenha) {
        // Preencher o campo Password de id "sigunpbox" e name = "password"
        navegador.findElement(By.id("signupbox")).findElement(By.name("password")).sendKeys(regSenha);

        return this;
    }

    public MePage clicarSave() {
        // Clicar no link com o nome SAVE
        try {
            navegador.findElement(By.linkText("SAVE")).click();
            navegador.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            List<WebElement> mensagemErro = navegador.findElements(By.xpath("//*[@id=\"toast-container\"]/div"));
            if (mensagemErro.size() > 0) {
                System.out.println(mensagemErro.get(0).getText());
                String screenShotArquivo = "src/main/resources/evidencias/" + Generator.dataHoraParaArquivo() + ".png";
                Screenshots.tirar(navegador, screenShotArquivo);
                fail();
            }
        }
        catch (Exception exception){
            System.out.println("ERRO INESPERADO!");
            exception.printStackTrace();
        }
        return new MePage(navegador);

    }

    public MePage registrarUmNovoUsuario(String regName, String regLogin, String regSenha) {
        registrarName(regName);
        registrarLogin(regLogin);
        registerSenha(regSenha);
        clicarSave();

        return new MePage(navegador);
    }

}
