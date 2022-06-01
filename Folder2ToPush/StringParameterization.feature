Feature: Login demoautomation site to check the Register, WebTable and Home 
	tab is available

Scenario: Verify Register tab with title 
	Given nevigate to demo automation site 
	Then click on skipsign "btn2" button 
	Then verify register title 
	And close the browser 
	
Scenario: Verify WebTable tab with title 
	Given nevigate to demo automation site 
	Then click on skipsign "btn2" button 
	Then click on webtable tab 
	Then verify webtable title 
	And close the browser 
	
Scenario: Verify Home tab with title 
	Given nevigate to demo automation site 
	Then click on skipsign "btn2" button 
	Then click on home tab 
	Then verify home page title 
	And close the browser