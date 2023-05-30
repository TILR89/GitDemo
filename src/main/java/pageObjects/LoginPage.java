package pageObjects;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {

    @FindBy(xpath = "//img[@alt='ParaBank']")
    private WebElement bankLogo;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class ='error']")
    private WebElement errorMessage;


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public HomePage loginToHomePage(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        waitWebElementToAppear(errorMessage);
        return errorMessage.getText();


    }

    public String getErrorMessage2() {
        System.out.println("hello");
        waitWebElementToAppear(errorMessage);
        return errorMessage.getText();


    }
}
