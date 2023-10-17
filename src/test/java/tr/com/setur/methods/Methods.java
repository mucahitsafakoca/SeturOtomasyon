package tr.com.setur.methods;

import tr.com.setur.driver.DriverWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Methods extends DriverWeb {
    private static final WebDriverWait webDriverWait = DriverWeb.webDriverWait;

    public static JavascriptExecutor jsExecutor;

    public Methods() {
        jsExecutor = getJSExecutor();
    }

    public WebElement findElement(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public String getText(By by) {
        return findElement(by).getText();

    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void waitSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickWithJS(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public String readCSV() {
        String[] values = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/Sehir.csv"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                values = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert values != null;
        return values[0];
    }
}
