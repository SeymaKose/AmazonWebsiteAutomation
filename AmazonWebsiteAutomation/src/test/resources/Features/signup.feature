Feature: Sign-up

  Scenario: Successfully sign up with valid information
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should be navigated to the email verification page
    #And user successfully complete e-mail verification process
    #And user should be redirected to the homepage
    #Then users name should be visible in the account section
    And close browser
  	
  Scenario: Sign-up with an invalid name-surname
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters invalid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should see an error message indicating the name-surname is invalid
    And close browser

  Scenario: Sign-up with an invalid email
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters an invalid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should see an error message indicating the email address is invalid
    And close browser
  
  Scenario: Sign-up with an already registered email
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a registered email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should see an error message indicating the email address is already registered
    And close browser

  #  Scenario: Sign-up with matching invalid passwords
  #    Given user is on Amazon homepage
  #    When user clicks sign up text
  #    And user is on sign up page
  #    And user enters a valid name-surname
  #    And user enters a valid email
  #    And user enters an invalid password
  #    And user re-enters a same invalid password
  #    And user clicks continue button
  #    Then user should see alert text about invalid password
  #  Scenario: Sign-up with mismatch invalid passwords
  #    Given user is on Amazon homepage
  #    When user clicks sign up text
  #    And user is on sign up page
  #    And user enters a valid name-surname
  #    And user enters a valid email
  #    And user enters an invalid password
  #    And user re-enters a different invalid password
  #    And user clicks continue button
  #    Then user should see alert text about invalid password
  #    And user should see alert text about mismatch password
  
  Scenario: Sign-up with mismatch passwords
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters a different password
    And user clicks create account button
    Then user should see an error message indicating that the passwords do not match
    And close browser
    
  Scenario: Sign-up with empty name-surname field
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user leaves the name-surname field empty
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should see an error message indicating that the name-surname field cannot be empty
    And close browser

  Scenario: Sign-up with empty email field
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user leaves the email field empty
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    Then user should see an error message indicating that the email field cannot be empty
    And close browser
    
  Scenario: Sign-up with empty password field
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user leaves the password field empty
    And user leaves the re-enter password field empty
    And user clicks create account button
    Then user should see an error message indicating that the password field cannot be empty
    And close browser

  Scenario: Sign-up with empty passwordCheck field
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user leaves the re-enter password field empty
    And user clicks create account button
    Then user should see an error message indicating that the re-enter password field cannot be empty
    And close browser

  Scenario: Sign-up with legal marketing
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    Then user check the legal marketing checkbox
    And user clicks create account button
    And close browser

  Scenario: Resend verification code
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    And user should be navigated to the email verification page
    And user clicks resend OTP button
    Then user should see information text about resending verification code
    And user should see information note about not recieving verification email
    And close browser

  Scenario: Change email address
    Given user is on Amazon homepage
    When user clicks sign up text
    And user is on sign up page
    And user enters a valid name-surname
    And user enters a valid email
    And user enters a valid password
    And user re-enters the password for confirmation
    And user clicks create account button
    And user should be navigated to the email verification page
    And user clicks change text
    Then user should be navigated to sign up page
    And close browser
