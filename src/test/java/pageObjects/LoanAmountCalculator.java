package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanAmountCalculator extends BasePage{

	public LoanAmountCalculator(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Loan Calculator")
	WebElement loanCalculatorButton;
	
	@FindBy(xpath = "//*[@id=\"dismiss-button\"]/div/span")
	WebElement adCloseButton;
	
	// WebElements
	
	@FindBy(id = "loan-amount-calc")
	WebElement loanAmountCaiculator;
	
	@FindBy(id = "loanamount")
	WebElement loanAmountTextBox;
	
	
	@FindBy(id = "loanemi")
	WebElement loanEmiTextBox;
	
	@FindBy(xpath = "//*[@id=\"loanemislider\"]/span")
	WebElement loanemiSlider;
	
//	@FindBy(xpath = "//*[@id=\"loanamountslider\"]/div")
//	WebElement loanAmountSlider;
	
	@FindBy(xpath = "//*[@id=\"loanamountslider\"]/span")
	WebElement loanAmountSlider;
	
	@FindBy(id = "loaninterest")
	WebElement loanInterestTextBox;
	
	@FindBy(xpath = "//*[@id=\"loaninterestslider\"]/span")
	WebElement loanInterestSlider;
	
	@FindBy(id = "loanterm")
	WebElement timeInputBox;
	
	@FindBy(xpath = "//*[@id=\"loantermslider\"]/span")
	WebElement tenureSlider;
	
	@FindBy(xpath = "//*[@id=\"loantermsteps\"]/span/span")
	List<WebElement> loanTenureSteps;
	
	@FindBy(id = "loanyears")
	WebElement loanTenureYearButton;
	
	@FindBy(id = "loanmonths")
	WebElement loanTenureMonthButton;
	
	
	@FindBy(id = "loanfees")
	WebElement fessInputBox;
	
	@FindBy(xpath = "//*[@id=\"loanfeesslider\"]/span")
	WebElement feeSlider;
	
	public void navigateToloanCalculator() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", loanCalculatorButton);
		loanCalculatorButton.click();
	}
	
	public void loanAmountCalculator() {
		loanAmountCaiculator.click();
	}

}
