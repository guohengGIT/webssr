/**
 * Home 
 */
var homeModule=angular.module("HomeModule",[]);
homeModule.controller('Home',function($scope, $http, $state, $stateParams) {
	$scope.addUserClick=function(){
		window.location.href="#/farmManagement";
	}
	
	$scope.accessToALMPSClick=function(){
		window.location.href="#/accessToALMProjectSandbox";
    }
	
	$scope.disconnectAlmSessionsClick=function(){
		window.location.href="#/disconnectAllMyALMSessions";
	}
});

/**
 * Menu Management
 * @type {[type]}
 */
var menuManagementModule= angular.module("MenuManagementModule", []);
menuManagementModule.controller('MenuManagement', function($scope, $http, $state, $stateParams) {
	$scope.homeClick=function(){
		window.location.href="#/index";
	};
	
	$scope.farmManagementClick=function(){
		window.location.href="#/farmManagement";
	}
	
	$scope.projectMangementClick=function(){
		window.location.href="#/projectManagement";
	}
	
	$scope.reportMangementClick=function(){
		window.location.href="#/reportManagement";
	}
	
	$scope.almAuditClick=function(){
		window.location.href="#/almAudit";
	}
});
