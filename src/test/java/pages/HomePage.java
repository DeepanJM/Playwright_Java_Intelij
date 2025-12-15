package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;
    //private final String timeLink = "getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(\"Time\"))";
    private final String timeLink = "//span[text()='Time']";



    public HomePage(Page page){
        this.page = page;
    }

    public void clickTimeLink(){
        //page.click(timeLink);
        page.locator(timeLink).click();
    }

    public String getTimeLinkText() {
        return page.locator(timeLink).textContent().trim();
    }
}
