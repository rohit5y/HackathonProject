package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoanEMICalculator;
import testBase.BaseClass;

public class TC_003_LoanEMICalculator extends BaseClass {

	LoanEMICalculator loanCalculator;
	
	@Test
	public void selectCalculator() {
		loanCalculator = new LoanEMICalculator(driver);
		logger.info("*** Starting TC_003_LoanEMICalculator ***");
		try {
			loanCalculator.navigateToloanCalculator();
			logger.info("Clicking on Loan Calculator Link");
			try {
				//loanCalculator.handleAdvertisement();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			loanCalculator.selectEMICalculator();
			logger.info("Selecting EMI Calculator");
			System.out.println("Selecting Calculator");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(dependsOnMethods = "selectCalculator")
	public void textBoxValidation() {
		loanCalculator = new LoanEMICalculator(driver);
		SoftAssert softAssert = new SoftAssert();
		System.out.println("UI checks for EMI Calculator");

		Boolean validate = loanCalculator.loanInputBox();
		softAssert.assertEquals(validate, true, "Loan Amount Input Box Failed");
		System.out.println("Loan Amount InputBox validation successfull");
		logger.info("Validating Loan Amount Input Box");

		validate = loanCalculator.interestInputBox();
		softAssert.assertEquals(validate, true, "Loan Interest Input Box Failed");
		System.out.println("Interest Rate InputBox validation successfull");
		logger.info("Validating Loan Interest Input Box");

		validate = loanCalculator.tenureInputBox();
		softAssert.assertEquals(validate, true, "Loan Tenure Input Box Failed");
		System.out.println("Loan Tenure InputBox validation successfull");
		logger.info("Validating Loan Tenure Input Box");

		validate = loanCalculator.feeInputBox();
		softAssert.assertEquals(validate, true, "Loan Fees&Charges Input Box Failed");
		System.out.println("Loan Fees&Charges InputBox validation successfull");
		logger.info("Validating Loan Fees&Charges Input Box");

		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "selectCalculator")
	public void sliderValidation() {
		loanCalculator = new LoanEMICalculator(driver);
		try {
			SoftAssert softAssert = new SoftAssert();
			boolean loanValidation;
			loanValidation = loanCalculator.validateLoanSlider();
			System.out.println("Loan Amount Slider validation successfull");
			softAssert.assertEquals(loanValidation, true, "Loan Amount Slider Failed");
			
			loanValidation = loanCalculator.validateInterestSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Interest Slider Failed");
			System.out.println("Interest Rate Slider validation successfull");
			
			loanValidation = loanCalculator.validateTenureSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Tenure Slider Failed");
			System.out.println("Loan Tenure Slider validation successfull");
			
			loanValidation = loanCalculator.validateFeeSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Fees&Charges Slider Failed");
			System.out.println("Fees&Charges Slider validation successfull");
			
			softAssert.assertAll();
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test(dependsOnMethods = "selectCalculator")
	public void loanTenureValidation() {
		try {
			loanCalculator = new LoanEMICalculator(driver);
			
			boolean validate = loanCalculator.changeLoanTenure();
			Assert.assertEquals(validate, true, "Loan tenure Scale Failed");
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
