package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private final String usernameTextboxLoginPage = "input[name='username']";
    private final String passwordTextboxLoginPage = "input[name='password']";
    private final String loginButton = "button[type='submit']";

    //Constructor
    public LoginPage(Page page){
        this.page = page;
    }

    //Page Actions
    public void navigate(){

    }

    public void addUsername(String username){
        page.fill(usernameTextboxLoginPage, username);
    }

    public void addPassword(String password){
        page.fill(passwordTextboxLoginPage, password);
    }

    public void clickLoginButton(){
        page.click(loginButton);
    }

    public void login(String username,String password ){
        page.fill(usernameTextboxLoginPage, username);
        page.fill(passwordTextboxLoginPage, password);
        page.click(loginButton);
    }
}
