package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;
        }

    public String capturarTextToast() {
        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
