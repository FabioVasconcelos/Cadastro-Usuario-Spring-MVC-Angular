appUsuario.controller("usuarioController", function  ($scope, $http){
	
	$scope.usuarios=[];
	$scope.usuario={};
	$scope.user={};
	$scope.carregarUsuarios = function(){
		$http({method:'GET', url:'http://localhost:8080/usuarios'})
		.then(function (response){
			
			$scope.usuarios=response.data;
			
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		
		
		});
	
	
	};
	
	$scope.cancelarAlteracaoUsuario=function (){
		$scope.usuario={};
	};
	
	
	$scope.salvarUsuario= function (){
		
		$http({method:'POST', url:'http://localhost:8080/usuarios',data:$scope.usuario})
		.then(function (response){
			
		$scope.user = angular.copy($scope.usuario);
		$scope.cancelarAlteracaoUsuario();
		$scope.frmUsuario.$setPristine(true);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	
	
	$scope.carregarUsuarios();
	
	
});