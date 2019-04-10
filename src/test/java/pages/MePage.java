package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarAbaMoreDataAboutYou() {
        // Clicar no link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreData() {
        // Clicar no botão através do seu XPATH = //button[@data-target="addmoredata"] ou //div[@id="moredata"]/div/button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//div[@id=\"moredata\"]/div/button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(navegador);
    }

    public MePage validarMyName(String regName) {
        // Validar que meu fiz o registro no campo class "me"
        WebElement myName = navegador.findElement(By.className("me"));
        String myMe = myName.getText();
        assertEquals("Informação de Usuário inválida", "Hi, " + regName, myMe);

        return this;
    }

    public LoginPage fazerLogout() {
        // Efetuar logout atráves do text logout
        navegador.findElement(By.linkText("Logout")).click();

        return new LoginPage(navegador);
    }
}
