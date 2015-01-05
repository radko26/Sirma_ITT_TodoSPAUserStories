Scenario: Test add task
Given the user has clicked on the add-task button
When the user fills in the fields with 'UserStoryAddTaskTest1' as content and click on the create button
Then he should see his task with 'UserStoryAddTaskTest1' as content displayed on the main page


Scenario: Test add task with expiry date
Given the user has clicked on the add-task button
When the user fills in the fields with 'UserStoryAddTaskTest2' as content and '2014/12/17' as expiry date and click on the create button
Then he should see his task with 'UserStoryAddTaskTest2' as content and 'Wed Dec 17 2014' as expiry date displayed on the main page



Scenario: Test marking task as finished
Given the user has added a task with 'UserStoryAddTaskTest3' as content
When the user clicks the finish option on task with content 'UserStoryAddTaskTest3'
Then he should see his task with 'UserStoryAddTaskTest3' marked as finished
