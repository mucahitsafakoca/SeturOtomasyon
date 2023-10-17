package tr.com.setur.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverWeb {

    public static WebDriver webDriver;

    public static WebDriverWait webDriverWait;

    @BeforeAll
    public static void start(){

        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("win")) {
            WebDriverManager.chromedriver().win().setup();
            System.out.println("Windows isletim sisteminde Chrome Driver calistirildi");
        } else if (osName.toLowerCase().contains("mac")) {
            WebDriverManager.chromedriver().mac().setup();
            System.out.println("Mac isletim sisteminde Chrome Driver calistirildi");
        }

        webDriver = new ChromeDriver();

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

        webDriverWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();

        webDriver.navigate().to("https://www.setur.com.tr");
    }
    @AfterAll
    public static void stop(){
        if(webDriver!= null){
            webDriver.close();
        }
    }
    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) webDriver;
    }

}
