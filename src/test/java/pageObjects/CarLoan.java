package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CarLoan extends BasePage {

	Actions action = new Actions( driver);
	
	public CarLoan(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js;
	
	@FindBy(id = "car-loan")
	WebElement carLoan;
	
	@FindBy(id = "loanamount")
	WebElement loanAmount;
	
	@FindBy(id = "loaninterest")
	WebElement interestRate;
	
	@FindBy(id = "loanterm")
	WebElement loanTenure;
	
	@FindBy(css = "label[for='loanterm']")
	WebElement loanTenureText;
	
	@FindBy(xpath = "//div[@id=\"emiamount\"]//span")
	WebElement oneMonthEMI;
	
	@FindBy(id="year2024")
	WebElement tableCell2024Btn_Loc;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	WebElement febPrincipalAmt_Loc;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	WebElement febInterest_Loc;
	
	
	//(//td[@class="col-3 col-sm-2 currency"])[3]
	
			
	
	public void setLoanAmount() {
		carLoan.click();
		loanAmount.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(loanAmount , "1500000").sendKeys(Keys.ENTER).build().perform();

//		loanAmount.sendKeys("1500000");
		
	}
	
	public void setInteretRate() {
		
		
//		interestRate.clear();
		interestRate.click();
//		js.executeScript("arguments[0].value='9.5';", interestRate);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(interestRate , "9.5").sendKeys(Keys.ENTER).build().perform();
		// .sendKeys(Keys.DECIMAL).sendKeys(Keys.NUMPAD5).
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		interestRate.sendKeys("9.5");
	}
	
	public void setLoanTenure() {
		loanTenure.clear();
		loanTenure.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(loanTenure , "1").sendKeys(Keys.ENTER).build().perform();
		loanTenureText.click();
//		loanTenure.sendKeys("1");
		
	}
	
	public String getOneMonthEMI() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", oneMonthEMI);
		String expValue = oneMonthEMI.getText();
		System.out.println("One Month EMI : " + expValue);
		return expValue;
	}
	
	public String getFebPrincipalAmount() throws InterruptedException {
		tableCell2024Btn_Loc.click();
		Thread.sleep(2000);
		String principal =  febPrincipalAmt_Loc.getText();
		System.out.println("Principal Amount for 1st Month : "+principal);
		return principal;
	}
	
	public String getFebInterestAmount() {
		String interest =  febPrincipalAmt_Loc.getText();
		System.out.println("Interest for 1st Month : "+interest);
		System.out.println("-----------------------------------");
		return febInterest_Loc.getText();
	}
	
	
	
	

}
