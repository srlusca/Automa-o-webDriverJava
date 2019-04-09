package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
