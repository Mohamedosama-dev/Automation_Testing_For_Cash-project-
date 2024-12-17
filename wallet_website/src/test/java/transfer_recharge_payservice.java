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

public class transfer_recharge_payservice {
    FirefoxDriver driver=new FirefoxDriver();
    @BeforeTest
    public void open_browser( ){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://127.0.0.1:8000/sign_in/");

    }
    @Test(priority = 1)
    public void valid_recharge_phone() {
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
        WebElement recharge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button recharge-button']")));
        recharge.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='target_phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount'] ")));
        amount.sendKeys("50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:green;']")));
        String ee =element.getText();
        String actual="Successful recharge";
        Assert.assertTrue(ee.contains(actual));
    }
    @Test(priority = 2)
    public void in_valid_recharge_phone_amount_less_than_zero() {
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
        WebElement recharge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button recharge-button']")));
        recharge.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='target_phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount'] ")));
        amount.sendKeys("-50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="Amount must be greater than zero";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void in_valid_recharge_phone_amount_equal_zero() {
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
        WebElement recharge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button recharge-button']")));
        recharge.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='target_phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount'] ")));
        amount.sendKeys("0");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="Amount must be greater than zero";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    public void in_valid_recharge_phone_not_exits() {
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
        WebElement recharge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button recharge-button']")));
        recharge.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='target_phone']")));
        PHONE.sendKeys("0177727272" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount'] ")));
        amount.sendKeys("50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="User with the specified phone number does not exist.";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void valid_transfer() {
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
        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button transfer-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='recipient-phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:green;']")));
        String ee =element.getText();
        String actual="Successful transfer!";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void in_valid_transfer_amount_less_zero() {
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
        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button transfer-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='recipient-phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("-50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="Amount must be greater than zero.";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void in_valid_transfer_amount_equal_zero() {
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
        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button transfer-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='recipient-phone']")));
        PHONE.sendKeys("01554166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("0");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="Amount must be greater than zero.";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void in_valid_transfer_number_already_exits() {
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
        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button transfer-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='recipient-phone']")));
        PHONE.sendKeys("01254166178" );
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
        amount.sendKeys("50");
        WebElement button_recharge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button_recharge.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="User with the specified phone number does not have a wallet";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void valid_transfer_to_Charity() {
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

        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button charity-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='id_charity']/option[text()='Egyptian Food Bank']\n")));
        PHONE.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_amount']")));
        amount.sendKeys("20");
        WebElement button2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button2.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='success-message']")));
        String ee =element.getText();
        String actual="Successfully sent";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void valid_pay_service() {
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

        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button pay-service-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='id_service']/option[text()='Gas (Service Number: 67890)']\n")));
        PHONE.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_service_number']")));
        amount.sendKeys("67890");
        WebElement amount2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_amount']")));
        amount2.sendKeys("20");

        WebElement button2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button2.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:green;']")));
        String ee =element.getText();
        String actual="Service Payment Successful! Amount";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 11)
    public void in_valid_pay_service() {
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
        WebElement transfer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button pay-service-button']")));
        transfer.click();
        WebElement PHONE=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='id_service']/option[text()='Gas (Service Number: 67890)']\n")));
        PHONE.click();
        WebElement amount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_service_number']")));
        amount.sendKeys("67890");
        WebElement amount2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_amount']")));
        amount2.sendKeys("-50");

        WebElement button2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button2.click();
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@style='color:red;']")));
        String ee =element.getText();
        String actual="The amount must be greater than 0";
        Assert.assertTrue(ee.contains(actual));
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void close_browser(){
        driver.quit();    }
}
