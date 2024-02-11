package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomeLoan extends BasePage {

	List<List<String>> tableData = new ArrayList<>();

	public HomeLoan(WebDriver driver) {
		super(driver);
	}

	Actions action = new Actions(driver);
	JavascriptExecutor js;

	@FindBy(id = "home-loan")
	WebElement homeLoanTab;

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

	@FindBy(id = "emipaymenttable")
	WebElement emiTable;
	
	@FindBy(id = "yearheader")
	WebElement yearHeader;
	
	@FindBy(id = "principalheader")
	WebElement principalHeader;
	
	@FindBy(id = "interestheader")
	WebElement interestHeader;
	
	@FindBy(id = "totalheader")
	WebElement totalHeader;
	
	@FindBy(id = "balanceheader" )
	WebElement balanceHeader;
	
	@FindBy(id = "paidtodateheader")
	WebElement paidtodateHeader;

	@FindAll(@FindBy(xpath = "//*[@id=\"emipaymenttable\"]//tr[@class=\"row no-margin yearlypaymentdetails\"]"))
	List<WebElement> rowData;

	public void setLoanAmount() {
		homeLoanTab.click();
		loanAmount.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(loanAmount, "1500000").sendKeys(Keys.ENTER).build().perform();

//		loanAmount.sendKeys("1500000");

	}

	public void setInteretRate() {

//		interestRate.clear();
		interestRate.click();
//		js.executeScript("arguments[0].value='9.5';", interestRate);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(interestRate, "9.5").sendKeys(Keys.ENTER).build().perform();
		// .sendKeys(Keys.DECIMAL).sendKeys(Keys.NUMPAD5).
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setLoanTenure() {
		loanTenure.clear();
		loanTenure.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(loanTenure, "10").sendKeys(Keys.ENTER).build().perform();
		loanTenureText.click();

	}

	public List<List<String>> getTableData() {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", emiTable);
		tableData.add(addHeader());
		for (WebElement row : rowData) {
			List<String> cellDataText = new ArrayList<String>();
			List<WebElement> cellElement = row.findElements(By.tagName("td"));
			for (WebElement cell : cellElement) {
				String data = cell.getText();
				cellDataText.add(data);
			}
			tableData.add(cellDataText);
		}
		
		System.out.println("Year Principal(A) Interest(B) Total Payment(A+B) Balance Loan Paid To Date");
		for(int i=1;i<tableData.size();i++) {
			System.out.println(tableData.get(i));
		}
		System.out.println("------------------------");
		
		return tableData;
	}
	
	public List<String> addHeader(){
		List<String> header = new ArrayList<>();
		header.add(yearHeader.getText());
		header.add(principalHeader.getText());
		header.add(interestHeader.getText());
		header.add(totalHeader.getText());
		header.add(balanceHeader.getText());
		header.add(paidtodateHeader.getText());
		return header;
	}
}
