package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/home/srlusca/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Navegando para a página Task!
        navegador.get("http://www.juliodelima.com.br/taskit/");

        return navegador;
    }
}