app.controller('createAccountController', function($scope, $route, $location,
		$http, createAccount) {
	console.log("URL: " + $location.$$path);

	$scope.account = {
		accountHolder : {
			firstname : '',
			lastname : '',
			dateOfBirth : '',
			address : '',
			email : ''
		},
		bankDetails : {
			bankname : '',
			iban : '',
			bic : '',
			balance : 0.0
		},
		transactions : {
			balance : 0.0,
			description : '',
			date : ''
		}
	};

	$scope.listAccounts = [];

	$scope.listTransactionsAcc = [];
	
	$scope.listTransactionsByDate = [];

	$scope.selectedBankAcc = undefined;	

	$scope.headingTitle = $route.current.$$route.headingTitle;
	
	$scope.createAccount = function() {
		$http({
			method : 'POST',
			url : '/accounts/create',
			data : $scope.account
		}).success(
				function(data, status, headers, config) {
					if (status == 200) {
						console.log('Account Added succesfully: '
								+ JSON.stringify(data));
						$location.url("/accounts/create-success");
					}
				}).error(function(data, status, headers, config) {
			console.log('App rest error occured: ' + data);
		});

	};

	$scope.listAllAccounts = function() {
		$http({
			method : 'POST',
			url : '/accounts/listAllAccounts',
			data : ''
		}).success(
				function(data, status, headers, config) {
					if (status == 200) {
						$scope.listAccounts = [];
						console.log('List All the Accounts received succesfully: '
								+ JSON.stringify(data));
						for (var i = 0; i < data.length; i++) {
							var bankDetails = {
								id : data[i].Id,
								bankname : data[i].bankName,
								iban : data[i].Iban,
								bic : data[i].bic,
								balance : data[i].balance
							}
							$scope.listAccounts[i] = bankDetails;
						}
						console.log("list all accounts array: "
								+ $scope.listAccounts);
						$location.url("/accounts/list-all");
					}
				}).error(function(data, status, headers, config) {
			console.log('App rest error occured: ' + data);
			$location.url("/accounts/list-all-not-found");
			return;
		});

	};

	$scope.createAccountTrans = function() {
		$http({
			method : 'POST',
			url : '/accounts/listAllAccounts',
			data : ''
		}).success(
			function(data, status, headers, config) {
				if (status == 200) {
					$scope.listAccounts = [];
					console.log('List All the Accounts received succesfully: '
						+ JSON.stringify(data));
					for (var i = 0; i < data.length; i++) {
						var bankDetails = {
							id : data[i].Id,
							bankname : data[i].bankName,
							iban : data[i].Iban,
							bic : data[i].bic,
							balance : data[i].balance
						}
						$scope.listAccounts[i] = bankDetails;
					}
					console.log("list all accounts array: "
						+ $scope.listAccounts);
					$location.url("/accounts/create-trans");
				}
			}).error(function(data, status, headers, config) {
				console.log('App rest error occured: ' + data);
				$location.url("/accounts/list-all-not-found");
				return;
			});
	};

	$scope.createAccTransaction = function() {
		$scope.selectedBankAcc['description'] = $scope.account.transactions.description;
		$scope.selectedBankAcc['date'] = $scope.account.transactions.date;
		$scope.selectedBankAcc['transBalance'] = $scope.account.transactions.balance;
		
		$http({
			method : 'POST',
			url : '/accounts/createTransAccount',
			data : $scope.selectedBankAcc
		}).success(
			function(data, status, headers, config) {
				if (status == 200) {
					console.log('The Account Transaction created succesfully: '
						+ JSON.stringify(data));
					$location.url("/accounts/create-trans-success");
				}
			}).error(function(data, status, headers, config) {
				console.log('App rest error occured: ' + data);
				$location.url("/accounts/list-all-not-found");
				return;
			});		
	};
	
	$scope.listAllTransactions = function() {
		$http({
			method : 'POST',
			url : '/accounts/listAllAccounts',
			data : ''
		}).success(
				function(data, status, headers, config) {
					if (status == 200) {
						$scope.listTransactionsAcc = [];						
						console.log('List All the Accounts received succesfully: '
								+ JSON.stringify(data));
						for (var i = 0; i < data.length; i++) {
							var bankDetails = {
								id : data[i].Id,
								bankname : data[i].bankName,
								iban : data[i].Iban,
								bic : data[i].bic,
								balance : data[i].balance
							}
							$scope.listTransactionsAcc[i] = bankDetails;
						}
						console.log("list all accounts array: "
								+ $scope.listTransactionsAcc);
						$location.url("/accounts/list-transactions-bydate");
					}
				}).error(function(data, status, headers, config) {
			console.log('App rest error occured: ' + data);
			$location.url("/accounts/list-all-not-found");
			return;
		});

	};

	$scope.listAllAccountsByBankName = function(bankName) {
		console.log("bankName: " + bankName);

		$http({
			method : 'POST',
			url : '/accounts/listAllAccountsByBankName',
			data : bankName
		}).success(
				function(data, status, headers, config) {
					if (status == 200) {
						$scope.listAccounts = [];
						console.log('List All the Accounts received By bankname succesfully: '
								+ JSON.stringify(data));
						for (var i = 0; i < data.length; i++) {
							var bankDetails = {
								id : data[i].Id,									
								bankname : data[i].bankName,
								iban : data[i].Iban,
								bic : data[i].bic,
								balance : data[i].balance
							}
							$scope.listAccounts[i] = bankDetails;
						}
						console.log("list all accounts by bank name array: "
								+ $scope.listAccounts);
						$scope.account.bankDetails.bankname = '';
						$location.url("/accounts/list-by-bank");
					}
				}).error(function(data, status, headers, config) {
			console.log('App rest error occured: ' + data);
			$location.url("/accounts/list-all-not-found");
			return;
		});
	};
	
	$scope.listAllTransByDate = function (date) {
		console.log("Date: " + date);
		$http({
			method : 'POST',
			url : '/accounts/listTransactionsByDate',
			data : date
		}).success(
				function(data, status, headers, config) {
					if (status == 200) {
						$scope.listTransactionsByDate = [];
						console.log('List All the Transactions received By date succesfully: '
								+ JSON.stringify(data));
						for (var i = 0; i < data.length; i++) {
							var trans = {
								id : data[i].Id,									
								transDate : data[i].transDate,
								transDescription : data[i].transDescription,
								transAmount : data[i].transAmount
							}
							$scope.listTransactionsByDate[i] = trans;
						}
						console.log("list all accounts by bank name array: "
								+ $scope.listTransactionsByDate);
						$scope.account.transactions.date = '';
						$location.url("/accounts/list-transactions-bydate");
					}
				}).error(function(data, status, headers, config) {
			console.log('App rest error occured: ' + data);
			$location.url("/accounts/list-trans-not-found");
			return;
		});
	}
	
	$scope.selectedBankAccount = function(selectedAccount) {
		console.log("Selected bank account id: " + $scope.selectedAccount);
		for (var i=0; i < $scope.listAccounts.length; i++) {
			var bank = $scope.listAccounts[i];
		    if (bank.id === $scope.selectedAccount) {
		    	$scope.selectedBankAcc = bank;
		    	console.log("Found: id= " + bank.id + ", bankname: " + JSON.stringify(bank));
		    	break;
		    }
		}
	}

	switch ($location.$$path) {
	case '/accounts/create-trans':
		$scope.createAccountTrans();
		break;
	case '/accounts/list-all':
		$scope.listAllAccounts();
		break;
	case '/accounts/list-transactions-bydate':
		console.log("$scope.account.transactions.date: [" + $scope.account.transactions.date + "]");
		if ($scope.account.transactions.date !== '') {
			$scope.listAllTransByDate($scope.account.transactions.date);
		}
		break;
	default:
	}

});

app.controller('viewAccountsController', function($scope, $route) {
	$scope.headingTitle = $route.current.$$route.headingTitle;
});

app.controller('transactionsController', function($scope, $route) {
	$scope.headingTitle = $route.current.$$route.headingTitle;
});
