package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='email']") // Эта строка использует аннотацию @FindBy для поиска
    // веб-элемента на веб-странице с помощью XPath-выражения. В данном случае, элемент найден по XPath,
    // который ищет <input> элемент с атрибутом name, равным "email".
    // Найденный элемент сохраняется в переменной emailField типа WebElement.
    WebElement emailField;

    @FindBy(xpath = "//input[@name='password']") //Эта строка использует аннотацию @FindBy для поиска
    // веб-элемента на веб-странице с помощью XPath-выражения. В данном случае, элемент найден по XPath,
    // который ищет <input> элемент с атрибутом name, равным "password".
    // Найденный элемент сохраняется в переменной passwordField типа WebElement.
    WebElement passwordField;

    @FindBy(xpath = "//button[@name='registration']") //Эта строка использует аннотацию @FindBy для поиска
    // веб-элемента на веб-странице с помощью XPath-выражения. В данном случае, элемент найден по XPath,
    // который ищет <button> элемент с атрибутом name, равным "registration".
    // Найденный элемент сохраняется в переменной registrationField типа WebElement.
    WebElement registrationButton;

    @FindBy(xpath = "//button[@name='login']") //Эта строка использует аннотацию @FindBy для поиска
    // веб-элемента на веб-странице с помощью XPath-выражения. В данном случае, элемент найден по XPath,
    // который ищет <button> элемент с атрибутом name, равным "login".
    // Найденный элемент сохраняется в переменной loginField типа WebElement.
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    public LoginPage fillEmailField(String email){ // Этот метод заполняет поле электронной почты на веб-странице.
        // Он принимает строку email, переданную в качестве аргумента, и использует метод sendKeys(),
        // чтобы ввести эту строку в поле emailField.
        emailField.sendKeys(email);
        return  this;  // Затем метод возвращает объект LoginPage, что позволяет использовать этот метод в цепочке вызовов
    }
    public LoginPage fillPasswordField(String password){ // Этот метод заполняет поле пароля на веб-странице.
        // Он принимает строку password, переданную в качестве аргумента, и использует метод sendKeys(),
        // чтобы ввести эту строку в поле passwordField.
       passwordField.sendKeys(password);
        return  this;  // Затем метод возвращает объект LoginPage, что позволяет использовать этот метод в цепочке вызовов
    }

    public LoginPage clickByRegistartionBUtton() {
        registrationButton.click();
        return this;
    }
    public BasePage clickByLoginButton(){
        loginButton.click();
        Alert alert = getAlertIfPresent();
        if(alert!=null){
            alert.accept();
            return new LoginPage(driver);
        } else {return new ContactsPage(driver);
        }
    }
    private Alert getAlertIfPresent(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            return wait.until(ExpectedConditions.alertIsPresent());
        }catch(TimeoutException e){
            System.out.println("Allert issue " +e);
            return null;
        }
    }
}