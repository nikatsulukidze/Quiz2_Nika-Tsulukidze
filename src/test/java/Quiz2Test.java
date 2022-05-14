//package Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;


public class Quiz2Test {

    @Test
    public void firstTask() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/progress-bar");
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar > div"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.attributeContains(progressBar, "aria-valuenow", "100"));
        System.out.println("100%");
        driver.quit();
    }
    @Test
    public void secondTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement dropDown = driver.findElement(By.id("dropdowm-menu-1"));
        Select dropLanguage = new Select(dropDown);
        dropLanguage.selectByVisibleText("C#");
        String text = dropLanguage.getFirstSelectedOption().getText();
        if(text.equals("C#")){
            System.out.println("Selected programming language "+ text + " matches to C#");
        }else {
            System.out.println("Selected programming language doesn't match " + text);
        }
        List<WebElement> checkBox = driver.findElements(By.cssSelector("#checkboxes input[type=checkbox]"));
        for (WebElement box : checkBox) {
            if (!box.isSelected()) {
                box.click();
            }
        }
        WebElement radioButYell = driver.findElement(By.cssSelector("#radio-buttons > input[type=radio][value=yellow]"));
        radioButYell.click();
        Select fruitDropBox = new Select(driver.findElement(By.id("fruit-selects")));
        List<WebElement> fruitDBx = fruitDropBox.getOptions();
        for (WebElement dBx : fruitDBx) {
            if (dBx.getAttribute("value").equals("orange") && !dBx.isEnabled()) {
                System.out.println(" 'Orange' option in dropdown is disabled");
            }
        }
        driver.quit();
    }
        @Test
        public void thirdTask(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("http://the-internet.herokuapp.com/iframe");
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
            WebElement body = driver.findElement(By.tagName("body"));
            body.click();
            WebElement Text = driver.findElement(By.cssSelector("#tinymce p"));
            Text.clear();
            Text.sendKeys("Here Goes");
            driver.switchTo().defaultContent();
            WebElement ButtonCen = driver.findElement(By.cssSelector("button[aria-label=\"Align center\"]"));
            ButtonCen.click();
            driver.quit();
        }
}