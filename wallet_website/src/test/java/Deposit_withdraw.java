import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Deposit_withdraw {
    FirefoxDriver driver=new FirefoxDriver();
    @BeforeTest
    public void open_browser( ){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://127.0.0.1:8000/sign_in/");

    }
    @Test(priority = 1)
    public void valid_deposit() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button deposit-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("20");
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='success-message']")));
        String Expected=message.getText();
        String actual="Deposit successful! New Balance";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 2)
    public void in_valid_deposit_amount_less_than_zero() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button deposit-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("-50");
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='error-message']")));
        String Expected=message.getText();
        String actual="Amount must be greater than zero";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void valid_withdraw_amount() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button withdraw-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("7");
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='message']")));
        String Expected=message.getText();
        String actual="Withdraw successful. New Balance:";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    public void invalid_withdraw_amount_equal_zero() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button withdraw-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("0" );
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='message']")));
        String Expected=message.getText();
        String actual="Amount must be greater than zero";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 5)
    public void invalid_withdraw_amount_less_than_zero() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button withdraw-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("-50" );
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='message']")));
        String Expected=message.getText();
        String actual="Amount must be greater than zero";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 6)
    public void invalid_withdraw_amount_bigger_than_Balance() {
        driver.get("http://127.0.0.1:8000/sign_in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone']")));
        phone.clear();
        phone.sendKeys("01554166176");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        password.clear();
        password.sendKeys("01554166176");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
        WebElement dePosit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button withdraw-button']")));
        dePosit.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("15000" );
        WebElement deposit_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        deposit_button.click();
        WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='message']")));
        String Expected=message.getText();
        String actual="insufficient Balance";
        Assert.assertTrue(Expected.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void close_browser(){
        driver.quit();    }



}
