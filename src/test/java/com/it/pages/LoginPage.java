package com.it.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{

	@FindBy(name = "login")
	private WebElement inputLogin;

	@FindBy(name = "pass")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@tabindex='5']")
	private WebElement btnLogin;

	protected void login(String login, String password) {
		driver.scrollDown();
		inputLogin.clear();
		inputLogin.sendKeys(login);
		inputPassword.clear();
		inputPassword.sendKeys(password);
		btnLogin.click();
	}

}
