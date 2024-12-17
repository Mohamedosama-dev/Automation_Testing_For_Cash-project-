import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class Register_User {
    FirefoxDriver driver=new FirefoxDriver();
    @BeforeTest
    public void open_browser( ){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://127.0.0.1:8000/sign_up/");

    }
    @Test(priority = 1)
    public  void Valid_register(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01527629219");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01527629219");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='User created successfully']\n")));
        String actualText = message.getText();
        String expected="User created successfully";
        Assert.assertTrue( actualText.contains(expected));
    }

    @Test(priority = 2)
    public void in_Valid_phone_phone_already_exit(){
        driver.get("http://127.0.0.1:8000/sign_up/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01155727172");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01155727172");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='phone-error' and @style='display: block;']")));
        String actualText = message.getText();
        String expected="Phone number already exists and has a wallet.";
        Assert.assertTrue( actualText.contains(expected));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void in_Valid_phone_phone_less_than_11(){
        driver.get("http://127.0.0.1:8000/sign_up/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("0115572717");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("0115572717");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='phone-error']")));
        String actualText = message.getText();
        String expected="Invalid phone number. It must be 11 digits and start with 011, 012, 015, or 010.";
        Assert.assertTrue( actualText.contains(expected));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void in_Valid_phone_phone_more_than_11(){
        driver.get("http://127.0.0.1:8000/sign_up/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("011557271721");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("0115572717");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='phone-error']")));
        String actualText = message.getText();
        String expected="Invalid phone number. It must be 11 digits and start with 011, 012, 015, or 010.";
        Assert.assertTrue( actualText.contains(expected));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 5)
    public void in_Valid_phone_phone_phone_017(){
        driver.get("http://127.0.0.1:8000/sign_up/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("017557271721");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("0115572717");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='phone-error']")));
        String actualText = message.getText();
        String expected="Invalid phone number. It must be 11 digits and start with 011, 012, 015, or 010.";
        Assert.assertTrue( actualText.contains(expected));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void in_Valid_password(){
        driver.get("http://127.0.0.1:8000/sign_up/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        username.clear();
        username.sendKeys("Mohamed Osama");
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01277989211");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("111");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password-error']")));
        String actualText = message.getText();
        String expected="Password must be at least 8 characters long.";
        Assert.assertTrue( actualText.contains(expected));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void in_Valid_login(){
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.sendKeys("01554166178");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("0145");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Invalid phone number or password']\n")));
        String actualText = message.getText();
        String expected="Invalid phone number or password";
        Assert.assertTrue( actualText.contains(expected));

    }

    @AfterTest
    public void close_browser(){
        driver.quit();    }



}


















