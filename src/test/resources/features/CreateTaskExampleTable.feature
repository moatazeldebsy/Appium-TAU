Feature: Create New Task
 Scenario Outline: The user can add new task
    Given Click add new Task
    Given Enter "<TaskName>" and "<TaskDesc>"
    Then Task Added Successfully

Examples:
 	 | TaskName | TaskDesc |
 	 | Cucumber Task 1 | Task 1 Details |
 	 | Cucumber Task 2 | Task 2 Details |