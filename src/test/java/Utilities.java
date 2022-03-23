import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Base64;

public class Utilities {
    public static WebDriver driver = null;
    public static String xpath_email = null;
    public static String xpath_password = null;
    public static String emailPlaceHolder = null;
    public static String passwordPlaceHolder = null;
    public static String xpath_loginButton = null;
    public static String xpath_forgotPasswordButton = null;
    public static String xpath_locationDropdown = null;
    public static String xpath_signUpButton = null;
    public static String xpath_googleButton = null;
    public static String xpath_samlButton = null;
    public static String xpath_openIdButton = null;
    public static String loginUrl = null;
    public static String loginTitle = null;
    public static String invalidUserName = null;
    public static String invalidPassword = null;
    public static String xpath_errorMessage = null;
    public static String text_errorMessage = null;
    Utilities()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        assignPaths();
    }
    protected static ConfigReader configRead = new ConfigReader();

    public static void assignPaths()
    {
        xpath_email = configRead.getConfigData("XPath-EmailAddress");
        xpath_password = configRead.getConfigData("XPath-Password");
        emailPlaceHolder = configRead.getConfigData("XPath-EmailPlaceHolder");
        passwordPlaceHolder = configRead.getConfigData("XPath-PasswordPlaceHolder");
        xpath_loginButton = configRead.getConfigData("XPath-LoginButton");
        xpath_forgotPasswordButton = configRead.getConfigData("XPath-ForgotPasswordButton");
        xpath_locationDropdown = configRead.getConfigData("XPath-LocationDropdown");
        xpath_signUpButton = configRead.getConfigData("XPath-SignUpButton");
        xpath_googleButton = configRead.getConfigData("XPath-GoogleButton");
        xpath_samlButton = configRead.getConfigData("XPath-SAMLButton");
        xpath_openIdButton = configRead.getConfigData("XPath-OpenIDButton");
        loginUrl = configRead.getConfigData("LoginUrl");
        loginTitle = configRead.getConfigData("LoginTitle");
        invalidUserName = configRead.getConfigData("InvalidUserName");
        invalidPassword = decoder(configRead.getConfigData("InvalidPassword"));
        xpath_errorMessage = configRead.getConfigData("XPath-ErrorMessaage");
        text_errorMessage = configRead.getConfigData("Text-ErrorMessage");
    }


    public static String decoder(String s)
    {
        String decode="";
        byte[] actualByte = Base64.getDecoder().decode(s);
        decode = new String(actualByte);
        return decode;
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
