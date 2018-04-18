var app = angular.module('myApp')
app.controller('createUser',function($scope,userservice) {
	$scope.name;
	$scope.email;
	$scope.username;
	$scope.password;
	$scope.submit = function() {
		userservice.submit($scope.name,$scope.email,$scope.username,$scope.password);
	}
})