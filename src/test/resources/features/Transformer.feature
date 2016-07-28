Feature: Transform default and custom data in steps

  @wip
  Scenario: Should transform strings by default
    Then Cucumber should parse "double quoted" as string parameter

  @wip
  Scenario: Should transform integers by default
    Then Cucumber should parse 1 and 123123 as integer parameters

  @wip
  Scenario: Should transform decimal with custom transformer
    Then Cucumber should parse 2.2 with custom transformer