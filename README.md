# SunflowerApp
Framework Details:

•	Automation Tool Used : Appium

•	Programming language : Java

•	Project Management Tool : Maven

•	IDE: Eclipse	

•	Framework : Page Object Model

•	DeviceType : Simulator




The Scenarios Automated:

1. TestValidateHomeScreen 

The test script launches the App and validates the Screen elements. validates for the Header, two links ( My garden , Plant lists), The gardent is empty text Message and 
Add Plant Button is present. Also checks when clicked on Plant lists / Add Plant  is clicked user is navigated to Plant list screen.

2. TestAddPlant

The test script reads the plant name to be added from the excel sheet and stores it in a variable.
The test script then clicks on the Plant List link and validates for below screen elements:
  Plant list,  Filter By growing zone button, Header and the Plant Name mention in the excel sheet is present.
 The script clicks on the plant name mentioned in the excel sheet navigates to the product page and clicks on Add Plant button and then clicks on back button validates 
 plant list screen is loaded and then clicks on My garden link and upon navigations checks if the the plant is added successfully.
 
 
 3. TestValidateAddedPlant
 
 The test script reads the plant name to be added from the excel sheet and stores it in a variable.
 The test scrpit validates if the added plant is displayed in the My garden screen and clicks on the product and verify if the page related the added plant is 
 loaded successfully and scrolls up to validated the entire page is loaded.
 Then clicks on back button and validates if My Graden screen is displayed.
 
 4. TestAddPlantButtonDisabled
 
 The test scrpits validates that duplicate products cannot be added to the Garden. The test script reads the plant name to be added from the excel sheet and stores it in a variable.
 The test scripts navigates to Plant list screen and clicks on the same plant which was added to the garden and validates that the "Add Plant" button on 
 the product screen is hidden and user cannot add the same plant to garden.
 
 
 Reports:
 
 
 .html report is generated which contains the precise information on the execution and the time taken for execution.
 
 Screenshots:
 
 
 Screenshots are saven in the mentioned folder if scripts fail.

Test data :


The data for example plant name : Apple is stored in the excel file and the data is read from the excel file. By changing the plant name in the excel file the scrpits 
can be executed for different plants in the list.

