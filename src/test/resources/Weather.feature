Feature: Testing weather
  Scenario: Test weather
    Given City name is London
    When Requesting weather information
    Then Coordinates are lon:-0.13 and lat:51.51
    And Weather is:
    | id | 300|
    | main | Drizzle|
    | description | light intensity drizzle|
    | icon        | 09d                    |
    And Base is stations
    And Main is:
    | temp | 280.32|
    | pressure | 1012|
    | humidity | 81  |
    | temp_min | 279.15|
    | temp_max | 281.15|
    And Visibility is 10000
    And Wind is:
    | speed | 4.1|
    | deg | 80   |
    And Clouds are 90
    And Dt is 1485789600
    And Sys is:
    | type | 1|
    | id | 5091|
    | message | 0.0103|
    | country | GB    |
    | sunrise | 1485762037|
    | sunset | 1485794875|
    And Id is 2643743
    And Name is London
    And Cod is 200