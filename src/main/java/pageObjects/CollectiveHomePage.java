package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectiveHomePage {
	
	
	public WebDriver driver;
	
	//Locators for Book now Test case
	By terms=By.cssSelector("body.js:nth-child(2) div:nth-child(1) div.fadeAfterLoad section.cookie-banner:nth-child(1) div.cookie-banner__block.d-flex.flex-column.flex-md-row.justify-content-between.align-items-start.align-items-md-center > button.cookie-banner__button.btn--dark-green");
	By bookNowLink1 = By.xpath("//button[contains(text(),'Book Now')]");
	By locationDropdown = By.name("LOCATION");
	By dropdownOptions = By.cssSelector("body.js:nth-child(2) div.fadeAfterLoad div.v--modal-overlay div.v--modal-background-click div.v--modal-box.booking-sidebar div.booking-step-1 div:nth-child(2) form.field--dark div.booking-sidebar__step1--details div.input-select.field-wrapper.label-animate.location-field > div.input-select__dropdown");
	By selectRoom = By.xpath("//button[contains(text(),'Select your room')]");
	
	
	//Locators for Navigation bar Test case
	By navigationBar = By.cssSelector("body.js:nth-child(2) div.fadeAfterLoad header.main-header.offset-by-crisis-bar div.main-header__inner div.main-header__inner-container.container-fluid div.main-header__content > nav.main-header__navigation-wrapper");
	
	//Locators for Newsletter Test case
	By emailForNewsletter = By.id("field-email");
	By submitEmail = By.xpath("//*[@id=\"__layout\"]/div/footer/section[1]/div/div/div[2]/form/div[2]/button");
	By newsletterAck = By.xpath("//h2[contains(text(),'Thank you for signing up.')]");
	
	public CollectiveHomePage(WebDriver driver) {
		this.driver=driver;
	}

	//Locators can be accessed by using public methods
	public WebElement closeTerms()
	{
		return driver.findElement(terms);
	}
	
	public WebElement bookNow()
	{
		return driver.findElement(bookNowLink1);
	}
	
	public WebElement selectDropdown()
	{
		return driver.findElement(locationDropdown);
	}
	
	public List<WebElement> selectLocationOption()
	{
		return driver.findElements(dropdownOptions);
	}
	
	public WebElement selectRoomButton()
	{
		return driver.findElement(selectRoom);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	public WebElement getEmailForNewletter()
	{
		return driver.findElement(emailForNewsletter);
	}
	
	public WebElement submitForNewletter()
	{
		return driver.findElement(submitEmail);
	}
	
	public WebElement getNewsletterAck()
	{
			return driver.findElement(newsletterAck);
	}
	
}
