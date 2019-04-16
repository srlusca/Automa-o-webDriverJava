package pages;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class AddSomeTaskPage extends BasePage {

    public AddSomeTaskPage(WebDriver navegador) {
        super(navegador);
    }

    public AddSomeTaskPage adicioneUmaTarefa() {
        // Clicar no texto "+ ADD A TASK"
        navegador.findElement(By.xpath("//button[@data-target=\"addtask\"]")).click();

        return this;
    }

    public AddSomeTaskPage adicionarUmTituloParaATarefa(String titulo) {
        // Digitar no campo de titulo para a tarefa o xapth //div[@id="addtask"]//input[@name="title"]
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//input[@name=\"title\"]")).sendKeys(titulo);

        return this;
    }

    public AddSomeTaskPage adicionarDataParaATarefa(String dataLimite) {
        // Adicionar a data Limite para a tarefa
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//input[@placeholder=\"What is the maximum date to do it?\"]")).click();
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//div[@aria-label='" + dataLimite + "']")).click();
        navegador.findElement(By.xpath("//button[@class=\"btn-flat picker__close waves-effect\"]")).click();

        return this;
    }

    public AddSomeTaskPage adicionarTempoLimiteParaATarefa(String horaLimite, String minutoLimite) {
        String keys = Keys.chord(Keys.SHIFT, Keys.TAB);
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//textarea[@placeholder=\"Tell us, please!\"]")).sendKeys(keys);

        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//div[@class=\"clockpicker-dial clockpicker-hours\"]//div[text()='" + horaLimite + "']")).click();
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//div[@class=\"clockpicker-dial clockpicker-minutes\"]//div[text()='" + minutoLimite + "']")).click();
        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//button[text()=\"OK\"]")).click();

        return this;
    }

    public AddSomeTaskPage adicionarComentarioParaATarefa(String comentario) {

        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//textarea[@placeholder=\"Tell us, please!\"]")).sendKeys(comentario);

        return this;
    }

    public AddSomeTaskPage confirmarSeEstaCorreto() {

        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//select/option[@value=\"yes\"]")).click();

        return this;
    }

    public AddSomeTaskPage clicarNoSave() {

        navegador.findElement(By.xpath("//div[@id=\"addtask\"]//a[@class=\"modal-action waves-effect waves-green btn-flat\"]")).click();

        return this;
    }

    public AddSomeTaskPage preencherUmaNovaTarefa(String titulo, String dataLimite, String horaLimite, String minutoLimite, String comentario) {
        adicioneUmaTarefa();
        adicionarUmTituloParaATarefa(titulo);
        adicionarDataParaATarefa(dataLimite);
        adicionarTempoLimiteParaATarefa(horaLimite, minutoLimite);
        adicionarComentarioParaATarefa(comentario);
        clicarNoSave();

        return this;
    }

    public AddSomeTaskPage validarTarefaInserida() {

        WebElement verificarMensagemPop = navegador.findElement(By.xpath("//div[@id=\"toast-container\"]//div[\"The task has been added, pretty simple!\"]"));
        String mensagemTarefaPop = verificarMensagemPop.getText();
        assertEquals("The task has been added, pretty simple!", mensagemTarefaPop);

        return this;
    }
}