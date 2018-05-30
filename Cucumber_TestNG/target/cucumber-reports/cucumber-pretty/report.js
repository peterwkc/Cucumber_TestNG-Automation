$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Feature/Login.feature");
formatter.feature({
  "name": "Login to Volare Collector",
  "description": "Description:  As a user, I want login to Volare Collector ",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login_Valid"
    }
  ]
});
formatter.scenario({
  "name": "Valid Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login_Valid"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Volare Collector Home Page opens in browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.loadPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login to Volare Collector with Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "Login.login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page navigate to Volare Collector Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.navigatePage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/Feature/Logout.feature");
formatter.feature({
  "name": "Logout from Volare Collector",
  "description": "Description:  As a user, I want login to Volare Collector ",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Logout_Valid"
    }
  ]
});
formatter.scenario({
  "name": "Valid Logout",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Logout_Valid"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "A user has login to Volare Collector",
  "keyword": "Given "
});
formatter.match({
  "location": "Logout.assertLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click logout button",
  "keyword": "When "
});
formatter.match({
  "location": "Logout.logout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logout from Volare Collector and redirect to login page",
  "keyword": "Then "
});
formatter.match({
  "location": "Logout.afterLogout()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});