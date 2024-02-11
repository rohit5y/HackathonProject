# Selenium Automation Testing Project: Find the Interest Amount for current year
 
## Project Overview
This Selenium automation testing project focuses on automating tasks on https://emicalculator.net/
The primary objectives include input field and slider element validation by passing data, navigating through the portal, verifying the presence of specific elements and extracting details from the page. 
The project uses various dependencies and libraries to facilitate automation.

## Project Structure
 
### 1. Maven Repository
 
- *Maven Version*: 3.9.6
 
### 2. Dependencies
 
- *Apache POI*
     * Version: 5.2.2
     * Purpose: Used for reading and writing Excel files, facilitating data-driven testing.<br />
 
- *TestNG*
     * Version: 7.8.0
     * Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- *Extent Report*
     * Version: 5.0.9
     * Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- *Selenium*
     * Version: 4.16.1
     * Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
 
- *Loggers*
     * Version: 2.20.0
     * Purpose: Provides logging capabilities for better debugging and traceability.
 
## Automation Test Flow
 
1. *Open https://emicalculator.net/*
     * Navigate to the emicalculator.net.
 
2. *Car Loan*
     * Click on car loan 
     * Capture screenshot of the page.
     * Enter data into car loan amount input field using slider.
     * Capture screenshot of the page.
     * Enter data into interest rate input field using slider.
     * Capture screenshot of the page.
     * Enter data into loan tenure input field using slider. 
     * Capture screenshot of the page.
     * Click on loan tenure month button.
     * Capture screenshot of the page.
     * Click on first year button in year on year table.
     * Capture screenshot of the page.
     * Write first month Principal amount and Interest amount data in to excel.
     * Capture screenshot of the page.
 
3. *Home Loan*
     * Click on Calculators drop down.
     * Capture screenshot of the page.
     * Click on home loan emi calculator.
     * Capture screenshot of the page.
     * Enter relevant details in home loan emi calculator page.
     * Capture screenshot of the page.
     * Extract all the data from  year on year table & store in excel.
     * Capture screenshot of the page.

4. *Loan Calculator*
     * Click on Calculators drop down.
     * Capture screenshot of the page.
     * Click on loan calculator.
     * Capture screenshot of the page.

5.  *EMI Calculator*
     * UI check for text box & scales.
     * Capture screenshot of the page.

6.  *Loan Amount Calculator*
     * UI check for text box & scales.
     * Capture screenshot of the page.

7.  *Loan Tenure Calculator*
     * UI check for text box & scales.
     * Capture screenshot of the page.
   
 
## How to Run the Tests
 
1. *Open Eclipse IDE:*
     * Launch Eclipse IDE on your machine.
 
2. *Import Project:*
     * Select File -> Import from the menu.
     * Choose Existing Maven Projects and click Next.
     * Browse to the directory where you cloned the repository and select the project.
 
3. *Update Maven Project:*
     * Right-click on the project in the Project Explorer.
     * Choose Maven -> Update Project.
     * Click OK to update dependencies.
 
4. *Set Up Configuration:*
     * Open the src/test/resources/config.properties file.
     * Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. *Run Test Suite:*
     * Locate the test suite file (e.g. /testng.xml).
     * Right-click on the file and choose Run As -> TestNG Suite.
 
6. *View Reports:*
     * After execution, open the test-output folder and open index.html for reports.
     * Find the Extent Report HTML file (myReport.html) in reports folder for detailed test reports.
 
## Author Information
 
- *Rohit Gupta*
 
## Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.