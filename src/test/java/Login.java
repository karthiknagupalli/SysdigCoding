import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.List;

public class Login extends Utilities{

    private WebElement emailBox = null;
    private WebElement passwordBox = null;
    private WebElement loginButton = null;
    private WebElement forgotPassowrdButton = null;
    private WebElement signUpButton = null;
    private WebElement googleButton = null;
    private WebElement samlButton = null;
    private WebElement openidButton = null;
    private WebElement locationdropdown = null;
    private WebElement errorMessage = null;



    // Open the login Page url and validate if the Url and Title are correct
    @Test(priority = 1)
    public void openUrl() throws InterruptedException {

        driver.get(loginUrl);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentUrl,loginUrl);
        Assert.assertEquals(currentTitle,loginTitle);
        System.out.println("Successfully landed on the Login Page");
    }

    // Validate if the elements are getting displayed in login page
    @Test(priority = 2)
    public void validateIfElementsDisplayed() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath(xpath_email)).isDisplayed()); // check if the element is displayed
        emailBox = driver.findElement(By.xpath(xpath_email));
        Assert.assertEquals(emailBox.getAttribute("placeholder"),emailPlaceHolder); // check if the element placeholder is correct
        System.out.println("userName Field is displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_password)).isDisplayed()); // check if the element is displayed
        passwordBox = driver.findElement(By.xpath(xpath_password));
        Assert.assertEquals(passwordBox.getAttribute("placeholder"),passwordPlaceHolder); // check if the element placeholder is correct
        System.out.println("password Field is displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_loginButton)).isDisplayed()); // check if the element is displayed
        loginButton = driver.findElement(By.xpath(xpath_loginButton));
        System.out.println("Login Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_forgotPasswordButton)).isDisplayed()); // check if the element is displayed
        forgotPassowrdButton = driver.findElement(By.xpath(xpath_forgotPasswordButton));
        System.out.println("Forgotpassword Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.linkText(xpath_signUpButton)).isDisplayed()); // check if the element is displayed
        signUpButton = driver.findElement(By.linkText(xpath_signUpButton));
        System.out.println("signUp Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_googleButton)).isDisplayed()); // check if the element is displayed
        googleButton = driver.findElement(By.xpath(xpath_googleButton));
        System.out.println("Google Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_samlButton)).isDisplayed()); // check if the element is displayed
        samlButton = driver.findElement(By.xpath(xpath_samlButton));
        System.out.println("SAML Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_openIdButton)).isDisplayed()); // check if the element is displayed
        openidButton = driver.findElement(By.xpath(xpath_openIdButton));
        System.out.println("openid Button is getting displayed correctly");

        Assert.assertTrue(driver.findElement(By.xpath(xpath_locationDropdown)).isDisplayed()); // check if the element is displayed
        locationdropdown = driver.findElement(By.xpath(xpath_locationDropdown));
        System.out.println("Location Dropdown is getting displayed correctly");

    }


    // Validate the Email Address and password fields
    @Test(priority = 3)
    public void validateEmailAndPassword() throws Exception {
        String currentUrl = driver.getCurrentUrl();

        emailBox.clear();
        passwordBox.clear();
        loginButton.click();
        Assert.assertEquals(currentUrl,loginUrl);
        Thread.sleep(1000);

        emailBox.clear();
        passwordBox.clear();
        emailBox.sendKeys("abcd");
        loginButton.click();
        Assert.assertEquals(currentUrl,loginUrl);
        Thread.sleep(1000);

        emailBox.clear();
        passwordBox.clear();
        passwordBox.sendKeys("abcd");
        loginButton.click();
        Assert.assertEquals(currentUrl,loginUrl);
        Thread.sleep(1000);

        emailBox.clear();
        passwordBox.clear();
        emailBox.sendKeys(invalidUserName);
        passwordBox.sendKeys(invalidPassword);
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(xpath_errorMessage)).isDisplayed());
        WebElement error = driver.findElement(By.xpath(xpath_errorMessage));
        Assert.assertEquals(error.getText(),text_errorMessage);
        takeSnapShot(driver,"src/test/Screenshots");

    }

    // Quit the browser after executing all the testcases
    @AfterTest
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Browser Exit");
        driver.close();
        driver.quit();
    }
}
