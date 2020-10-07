$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:feature/netcore.feature");
formatter.feature({
  "name": "Netcore_Automation_Task",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Automationcode|netcore",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "Navigate to the flipkart",
  "keyword": "Given "
});
formatter.step({
  "name": "Search for iphone",
  "keyword": "When "
});
formatter.step({
  "name": "capture the details in CSV format",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Flipkartwebsite"
      ]
    },
    {
      "cells": [
        "https://www.flipkart.com/"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Automationcode|netcore",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to the flipkart",
  "keyword": "Given "
});
formatter.match({
  "location": "support.StepDefinition.navigate_to_the_flipkart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search for iphone",
  "keyword": "When "
});
formatter.match({
  "location": "support.StepDefinition.search_for_iphone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "capture the details in CSV format",
  "keyword": "Then "
});
formatter.match({
  "location": "support.StepDefinition.capture_the_details_in_CSV_format()"
});
formatter.result({
  "status": "passed"
});
});