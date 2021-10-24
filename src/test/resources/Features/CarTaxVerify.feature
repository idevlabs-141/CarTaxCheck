Feature: Car Tax Verify

  Scenario Outline: Verify tax
    Given Vehicle Identity of reg numbers from inputFile should match against outputFile
      | inputFile   | outputFile   |
      | <inputFile> | <outputFile> |

    Examples:
      | inputFile     | outputFile     |
      | car_input.txt | car_output.txt |