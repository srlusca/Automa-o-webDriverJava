package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")

public class InformacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    //@Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name = "login") String login,
            @Param(name = "senha") String senha,
            @Param(name = "tipo") String tipo,
            @Param(name = "contato") String contato,
            @Param(name = "mensagem") String mensagemEsperada
    ) {
        String textoToast = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin(login, senha)
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreData()
                .adicionarContato(tipo, contato)
                .capturarTextToast();

        assertEquals(mensagemEsperada, textoToast);
    }

    @Test
        public void testRegistrarUsuario(
                @Param(name = "regName") String regName,
                @Param(name = "regLogin") String regLogin,
                @Param(name = "regSenha") String regSenha
        ) {
            new LoginPage(navegador)
                    .clicarRegistrarSe()
                    .registrarUmNovoUsuario(regName, regLogin, regSenha)
                    .validarMyName(regName)
                    .fazerLogout();

    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}
