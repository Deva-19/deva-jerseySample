var app = angular.module('myApp')
	app.service('userservice',function($state,$http) {
		
		this.submit = function(name,email,username,password) {
			var data={
				 fullname : name,
				 email : email,
				 username : username,
				 password: password,
				
		};
			var url = "http://localhost:8080/login/rest/user/createUser";
				$http.post(url, data)
					.then(function successCallback(response) {
						console.log(response.data);			 
				
					}, function errorCallback(response) {
						alert("Fill the details");
				});
			}
	});
