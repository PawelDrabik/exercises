var app = angular.module('app', [ 'ngRoute', 'ngResource' ]);
app.config(function($routeProvider) {	
	$routeProvider.when('/accounts/create', {
		templateUrl : '/views/create_acc.html',
		controller : 'viewAccountsController',
		headingTitle : "Create a new Bank Account"			
	}).when('/accounts/create-trans', {
		templateUrl : '/views/create_acc_trans.html',
		controller : 'viewAccountsController',
		headingTitle : "Create the Bank Account Transaction"			
	}).when('/accounts/create-success', {
		templateUrl : '/views/create_acc_success.html',
		controller : 'viewAccountsController',
		headingTitle : "Account created succesfully"
	}).when('/accounts/create-trans-success', {
		templateUrl : '/views/create_trans_success.html',
		controller : 'viewAccountsController',
		headingTitle : "Account Transaction created succesfully"
	}).when('/accounts/list-all', {
		templateUrl : '/views/list_all_accounts.html',
		controller : 'viewAccountsController',
		headingTitle : "List All Bank Accounts"
	}).when('/accounts/list-all-not-found', {
		templateUrl : '/views/list_all_accounts.html',
		controller : 'viewAccountsController',
		headingTitle : "List All Bank Accounts - something went wrong, try later."
	}).when('/accounts/list-by-bank', {
		templateUrl : '/views/list_accounts_bybank.html',
		controller : 'viewAccountsController',
		headingTitle : "List All ACC by Bank Name"
	}).when('/accounts/list-transactions-bydate', {
		templateUrl : '/views/list_transactions.html',
		controller : 'viewAccountsController',
		headingTitle : "List All Transactions by Date From"
	}).when('/accounts/list-trans-not-found', {
		templateUrl : '/views/list_all_trans.html',
		controller : 'viewAccountsController',
		headingTitle : "List All Transactions - something went wrong, try later."
	}).otherwise({
		redirectTo : '/'
	});
});
