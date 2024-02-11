package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoanAmountCalculator;
import pageObjects.LoanEMICalculator;
import testBase.BaseClass;

public class TC_004_LoanAmountCalculator extends BaseClass {
	
LoanAmountCalculator loanAmountCalculator;
	
//	@Test
//	public void selectCalculator() {
//		loanAmountCalculator = new LoanAmountCalculator(driver);
//		try {
//			loanAmountCalculator.navigateToloanCalculator();
//			try {
////				loanCalculator.handleAdvertisement();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			loanAmountCalculator.loanAmountCalculator();
//			System.out.println("Selecting Calculator");
//			Assert.assertTrue(true);
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail();
//		}
//	}
	
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
			loanCalculator.selectloanAmountCalculator();
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

		validate = loanCalculator.tenureInputBox();
		softAssert.assertEquals(validate, true, "Loan Tenure Input Box Failed");

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
			softAssert.assertEquals(loanValidation, true, "Loan EMI Slider Failed");
			System.out.println("Slider validation successfull");
			
			loanValidation = loanCalculator.validateInterestSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Interest Slider Failed");
			System.out.println("Interest Done");
			
			loanValidation = loanCalculator.validateTenureSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Tenure Slider Failed");
			System.out.println("Tenure Done");
			
			loanValidation = loanCalculator.validateFeeSlider();
			softAssert.assertEquals(loanValidation, true, "Loan Fees&Charges Slider Failed");
			System.out.println("Fees & Charges Done");
			
			softAssert.assertAll();
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "selectCalculator", priority = 1)
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
