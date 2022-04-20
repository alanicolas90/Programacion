Feature: como usuario quiero crear una billetera familiar
  Scenario: creo una villetera familiar
    Given Usuario
    When I create a billetera familiar
    Then I should see a billetera familiar