package com.traderev_qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

	public WebDriver driver;
	By careers_tab = By.xpath("//a[text()=' Careers ']");
	By canadian_Opportunities_btn = By.xpath("//a[@title='Canadian Jobs']");
	By careers_section_items_lst = By.xpath("//div[@class='section-title']");
	By canadian_Opportunities_items_lst = By.xpath("//div[@class='filter-button-wrapper']");
	By filter_Location_dd = By.xpath("//div[text()='Location']");
	By loc_Toranto = By.xpath("//a[text()='Toronto, Ontario, Canada']");
	By loc_searchResults = By.xpath("//span[@class='sort-by-location posting-category small-category-label']");
	By team_searchResults = By.xpath("//span[@class='sort-by-team posting-category small-category-label']");	
	By team_Filter = By.xpath("//div[@aria-label='Filter by Team: All']");
	By team_Engineering = By.xpath("//a[text()='Engineering']");
	
	
	public CareersPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCareers() {
		return driver.findElement(careers_tab);
	}

	public WebElement getCanadianOpportunities () {
		return driver.findElement(canadian_Opportunities_btn);
	}
	
	public WebElement getfilterLocation () {
		return driver.findElement(filter_Location_dd);
	}
	
	public WebElement getfilterTeam () {
		return driver.findElement(team_Filter);
	}
	
	public WebElement getLocationTorantoCity () {
		return driver.findElement(loc_Toranto);
	}
	
	public WebElement getEngineeringTeam () {
		return driver.findElement(team_Engineering);
	}
	
	public WebElement getLocationResults () {
		return driver.findElement(loc_searchResults);
	}
	
	public void navigate_careers() {
		WebElement element = getCareers();
		element.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();	
		allWindows.remove(parentWindow);
		Iterator<String> ite = allWindows.iterator();
		driver.switchTo().window((String) ite.next());
		
		WebDriverWait wait = new WebDriverWait(driver, 100);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(canadian_Opportunities_btn));
	}
	
	public void click_CanadianOOpportunities () {
		
		WebElement element = getCanadianOpportunities();
		WebElement el = driver.findElement(By.xpath("//div[@class='start-up']/preceding::div[@class='section-title'][1]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		element.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		WebDriverWait wait = new WebDriverWait(driver, 800);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filter-bar']")));
		
	}
	
	public boolean verify_careersScreen (String title) {
		try {
		List<WebElement> li = driver.findElements(careers_section_items_lst);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String stringList;
		for (WebElement we : li) {
			je.executeScript("arguments[0].scrollIntoView(true);",we);
			stringList = (we.getText().trim());

			if (title.contains(stringList)) {
				System.out.println("true - " + stringList);
			}
		}
		return true;
		} catch (Exception a) {
			a.printStackTrace();
			return false;
		}
	}
	
	public boolean verify_CandianOpportunityScreen (String title) {
		try {
		List<WebElement> li = driver.findElements(canadian_Opportunities_items_lst);
		String stringList;
		for (WebElement we : li) {		
			stringList = (we.getText().trim());

			if (title.contains(stringList)) {
				System.out.println("true - " + stringList);
			}
		}
		return true;
		} catch (Exception a) {
			a.printStackTrace();
			return false;
		}
	}

	public void filter_citySearch (String filter, String searchItem) {
		WebElement element;
		if (filter.equalsIgnoreCase("City")) {
		element = getfilterLocation();
		} else {
			element = getfilterTeam();
		}
		element.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (filter.equalsIgnoreCase("City")) {
			element = getLocationTorantoCity();
			} else {
				element = getEngineeringTeam();
			}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		element.click();		
	}	
	
	public boolean getCityfilterSearchResults (String filter, String searchItem) {
		try {
			List<WebElement> li;
			if (filter.equalsIgnoreCase("City")) {
				li = driver.findElements(loc_searchResults);
			} else {
				li = driver.findElements(team_searchResults);
			}
		String stringList;
		String[] list;
		for (WebElement we : li) {
			stringList = (we.getText().trim());
			if (searchItem.equalsIgnoreCase(stringList)) {
				System.out.println("true - " + stringList);
			}
			 if (filter.equalsIgnoreCase("Team")) {
				 list = stringList.split("-");
				 if (list[0].equalsIgnoreCase(searchItem)) {
						System.out.println("true - " + searchItem);
					}
			 }
		}
		return true;	
		} catch (Exception a) {
			a.printStackTrace();
			return false;
		}
	}

	
	
}
