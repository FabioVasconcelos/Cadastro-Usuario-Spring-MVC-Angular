//Criacao do modulo principal da aplicacao
var appUsuario = angular.module("appUsuario", [ 'ngRoute' ]);

appUsuario.config(function($routeProvider, $locationProvider) {

	$routeProvider
	.when("/listar", {
		templateUrl : 'view/usuario.html',
		controller : 'usuarioController'

	}).when("/cadastrar", {
		templateUrl : 'view/cadastro.html',
		controller : 'usuarioController'

	}).otherwise({
		rediretTo : '/'
	});
	
	$locationProvider.html5Mode(true);
	
});
