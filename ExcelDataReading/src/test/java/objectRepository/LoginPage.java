package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.LoginClass;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver)

	{

		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="email") WebElement emailid;

	@FindBy(name="password") WebElement password;

	public WebElement email()

	{
		
		return emailid;
	}

	public WebElement password()

	{

		return password;
	}

}
