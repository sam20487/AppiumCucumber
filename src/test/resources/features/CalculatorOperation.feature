Feature: Calculator operations

  Scenario: Calculation with valid data

    When I go to the calculator application
    And I type "2+2" in the input field
    And I click "[=]" button
    Then "4" result is displaying in the result field
    #When I type "sin(pi/6)/log(sqrt(e))" in the input field
    #And I click "[=]" button
    #Then "2.303" result is displayed in the result field
    #When I go to the calculator application
	
		
 Scenario: Calculation validations

   When I go to the calculator application
   And I type "5/0" in the input field
   And I click "[=]" button
   Then "Can't divide by 0" red validation message appears in the result field
   When I type "9^99999"
   And I click "[=]" button
   Then "Value too large" red validation message appears in the result field
