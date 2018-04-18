var app = angular.module("myApp",['ui.router'])
	app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/login");
	$stateProvider
	.state('login',{
		url:'/login',
		controller: 'createUser',
		templateUrl:'views/login.html'
	})
	
})