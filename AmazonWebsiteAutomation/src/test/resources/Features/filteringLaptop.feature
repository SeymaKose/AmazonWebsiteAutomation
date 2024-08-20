Feature: Filtering laptop by operating system

  Scenario: Filtering from the Electronics section
    Given user is on homepage
    When user clicks on the Electronics text
    And user clicks on Laptops under the Computers, Components & Accessories dropdown menu
    And user clicks on the Windows option in the Laptops dropdown menu
    And user should view laptops with the Windows operating system
    And user selects Windows11 Home from the Operation Systems section in the left sidebar filters 
    Then user should view laptops with the Windows11 Home operating system
    And close web browser 

  Scenario: Filtering from the Electronics section2
    Given user is on homepage
    When user clicks on the Electronics text
    And user clicks on Laptops under the Computers, Components & Accessories dropdown menu
    And user selects Windows11 Home from the Operation Systems section in the left sidebar filters
    Then user should view laptops with the Windows11 Home operating system
    And close web browser

  Scenario: Filtering process through the All hamburger menu - Computer
    Given user is on homepage
    When user clicks All hamburger menu
    And user clicks on Computer
    And user selects Laptops
    And user selects Windows11 Home from the Operation Systems section in the left sidebar filters
    Then user should view laptops with the Windows11 Home operating system
    And close web browser

  Scenario: Filtering process through the All hamburger menu - Electronics
    Given user is on homepage
    When user clicks All hamburger menu
    And user clicks on See All
    And user selects Electronics
    And user selects computer
    And user selects Laptops from the Category section in the left sidebar filters
    And user selects Windows11 Home from the Operation Systems section in the left sidebar filters
    Then user should view laptops with the Windows11 Home operating system
    And close web browser

  Scenario: Filter using search bar - windows11 home laptop
    Given user is on homepage
    When user enters "Windows 11 Home Laptop" into the search bar
    And user clicks the search button
    And user selects Laptops under the Category section in the left sidebar filters
    And user selects Windows11 Home under the Operation Systems section in the left sidebar filters
    Then user should view laptops with the Windows11 Home operating system
    And close web browser
