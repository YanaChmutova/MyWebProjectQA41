package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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


    public LoginPage clickByLoginButton(){ // Этот метод кликает по кнопке логина на веб-странице.
        // Он вызывает метод click() для loginButton.
        loginButton.click();
        return this; // Затем он также возвращает объект LoginPage, чтобы этот метод также можно было использовать в цепочке вызовов.
    }

    public LoginPage clickByRegistartionBUtton() {
        registrationButton.click();
        return this;
    }
}