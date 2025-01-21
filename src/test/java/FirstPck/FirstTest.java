package FirstPck;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class FirstTest {
    By textinput = new By.ById("my-text-id");
    By Button = new By.ByXPath("/html/body/main/div/form/div/div[2]/button");
    By Password = new By.ByXPath("/html/body/main/div/form/div/div[1]/label[2]/input");
    By TextArea = new By.ByXPath("/html/body/main/div/form/div/div[1]/label[3]/textarea");
    By message =  new By.ByXPath("/html/body/main/div/div[1]/div/h1");
    By message2 =  new By.ById("message");


    By Dropdown = new By.ByXPath("/html/body/main/div/form/div/div[2]/label[1]/select");
    By Color = new By.ByXPath("/html/body/main/div/form/div/div[3]/label[1]/input");
     By DropList = new By.ByXPath(" /html/body/main/div/form/div/div[2]/label[2]/input");
    By Id_Range = new By.ByXPath("/html/body/main/div/form/div/div[3]/label[3]/input");



    @Test
    public void AWebTesting()
    {

        /*
        open chrome
        navigate to url "  //go to https://www.selenium.dev/selenium/web/web-form.html"
        click on the field
        type your data
        assert the word
        */


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(textinput).sendKeys("Ahmed");
        driver.findElement(Password).sendKeys("123456789");
        driver.findElement(TextArea).sendKeys("hello ,  iam ahmed");




        Select dropdown = new Select(driver.findElement(Dropdown));
        dropdown.selectByVisibleText("Two");




        File uploadFile = new File("C:\\Users\\ahmed\\OneDrive\\Desktop\\d.txt");
        WebElement fileInput = driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(2) > label:nth-child(3) > input"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());


        WebElement ch1=driver.findElement(By.id("my-radio-1"));
        ch1.click();

        WebElement ch3=driver.findElement(By.id("my-check-2"));
        ch3.click();

        WebElement Date = driver.findElement(By.name("my-date"));
        Date.sendKeys("08-08-2003");
//



        WebElement element = driver.findElement(Color);
        JavascriptExecutor javascriptexecutor=(JavascriptExecutor)driver;
        javascriptexecutor.executeScript("arguments[0].setAttribute('value','#FFEEFX')",element);



        driver.findElement(Id_Range).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);


        WebElement inputField = driver.findElement(By.name("my-datalist"));
        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"my-options\"]/option[2]"));
        for (WebElement option : options) {
            if (option.getAttribute("value").equals("New York")) {
                inputField.sendKeys(option.getAttribute("value"));
                break;
            }
        }
        driver.findElement(Button).click();
        String Store_Msg = driver.findElement(message).getText();
        Assert.assertEquals(Store_Msg , "Form submitted");

        String Store_Msg2= driver.findElement(message2).getText();
        Assert.assertEquals(Store_Msg2 , "Received!");
        driver.quit();
    }//method




    By New_Input=new By.ByXPath("//*[@id=\"reveal\"]");
    By Field= new By.ById("revealed");
    @Test
    public void B_Second_Test(){
        //open chrome
        WebDriver web = new ChromeDriver();

        //navigate to url
        web.get("https://www.selenium.dev/selenium/web/dynamic.html");

        //click on Reval a new input

        web.findElement(New_Input).click();

        //we want to wait as it takes some seconds

        WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Field));




        element.sendKeys("Ahmed");

        wait.until(ExpectedConditions.attributeToBe(Field, "value", "Ahmed"));

        System.out.println("Text successfully entered!");

        //close the browser
        web.quit();


    }

}
