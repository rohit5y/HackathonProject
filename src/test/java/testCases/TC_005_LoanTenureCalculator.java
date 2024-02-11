package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoanEMICalculator;
import testBase.BaseClass;

public class TC_005_LoanTenureCalculator extends BaseClass{

LoanEMICalculator loanCalculator;
	
	@Test
	public void selectCalculator() {
		loanCalculator = new LoanEMICalculator(driver);
		try {
			loanCalculator.navigateToloanCalculator();
			try {
//				loanCalculator.handleAdvertisement();
			} catch (Exception e) {
				System.out.println(e);
			}
			loanCalculator.selectloanTenureCalculator();
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

		Boolean validate = loanCalculator.loanEMIInputBox();
		softAssert.assertEquals(validate, true, "Loan EMI Input Box Failed");

		validate = loanCalculator.interestInputBox();
		softAssert.assertEquals(validate, true, "Loan Interest Input Box Failed");

		validate = loanCalculator.loanInputBox();
		softAssert.assertEquals(validate, true, "Loan Amount Input Box Failed");

		validate = loanCalculator.feeInputBox();
		softAssert.assertEquals(validate, true, "Loan Fees&Charges Input Box Failed");

		softAssert.assertAll();
	}
	
	@Test(dependsOnMethods = "selectCalculator")
	public void sliderValidation() {
		loanCalculator = new LoanEMICalculator(driver);
		try {
			SoftAssert softAssert = new SoftAssert();
			boolean loanValidation;
			loanValidation = loanCalculator.validateLoanEMISlider();
			System.out.println("Slider validation successfull");
			softAssert.assertEquals(loanValidation, true, "Loan EMI Slider Failed");
			
			loanValidation = loanCalculator.validateLoanSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Amount Slider Failed");
			System.out.println("Tenure Done");
			
			loanValidation = loanCalculator.validateInterestSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Interest Slider Failed");
			System.out.println("Interest Done");
			
			loanValidation = loanCalculator.validateFeeSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Fees&Charges Slider Failed");
			System.out.println("Fees & Charges Done");
			
			softAssert.assertAll();
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
//	@Test(dependsOnMethods = "selectCalculator", priority = 1)
//	public void loanTenureValidation() {
//		try {
//			loanCalculator = new LoanEMICalculator(driver);
//			
//			boolean validate = loanCalculator.changeLoanTenure();
//			Assert.assertEquals(validate, true, "Loan tenure Scale Failed");
//		}catch(Exception e) {
//			System.out.println(e);
//			Assert.fail();
//		}
//	}

	
}
