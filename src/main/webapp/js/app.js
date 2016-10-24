var routerApp = angular.module('routerApp', ['ui.router' , 'HomeModule','MenuManagementModule', 
'FarmManagementModule',
'ProjectManagementModule',
'ReportManagementModule',
'ALMAuditModule']);
/**
 * Configuation Run
 * @param  {[type]} $rootScope
 * @param  {[type]} $state
 * @param  {[type]} $stateParams
 * @return {[type]}
 */
routerApp.run(function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
});

/**
 * Configuation Router (UI Router)
 * @param  {[type]} $stateProvider
 * @param  {[type]} $urlRouterProvider
 * @return {[type]}
 */
routerApp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/index');
    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                '': {
                    templateUrl: '/webssr/Views/home.html'
                },
                'main@index': {
                    templateUrl: '/webssr/Views/mainMenu.html'
                }
            }
        })
        .state('farmManagement', {
            url: '/farmManagement',
            views: { 
                '': {
                    templateUrl: '/webssr/Views/farmManagementModule.html'
                },
                'farmManagementList@farmManagement': {
                    templateUrl: '/webssr/Views/farmManagement/farmManagement.html'
                },
                'farmManagementDetail@farmManagement':{
                    templateUrl: '/webssr/Views/farmManagement/addUserToALM.html'
                }
            }
        })
        .state('accessToALMProjectSandbox',{
        	url:'/accessToALMProjectSandbox',
        	views:{
        		'': {
                    templateUrl: '/webssr/Views/farmManagementModule.html'
                },
                'farmManagementList@accessToALMProjectSandbox': {
                    templateUrl: '/webssr/Views/farmManagement/farmManagement.html'
                },
                'farmManagementDetail@accessToALMProjectSandbox':{
                    templateUrl: '/webssr/Views/farmManagement/accessToALMProjectSandbox.html'
                }
        	}
        })
        .state('disconnectAllMyALMSessions',{
        	url:'/disconnectAllMyALMSessions',
        	views:{
        		'': {
                    templateUrl: '/webssr/Views/farmManagementModule.html'
                },
                'farmManagementList@disconnectAllMyALMSessions': {
                    templateUrl: '/webssr/Views/farmManagement/farmManagement.html'
                },
                'farmManagementDetail@disconnectAllMyALMSessions':{
                    templateUrl: '/webssr/Views/farmManagement/disconnectAllMyALMSessions.html'
                }
        	}
        })
        .state('projectManagement', {
            url: '/projectManagement',
            views: {
                '': {
                    templateUrl: '/webssr/Views/projectManagementModule.html'
                },
                'projectManagementList@projectManagement': {
                    templateUrl: '/webssr/Views/projectManagement/projectManagement.html'
                },
                'projectManagementDetail@projectManagement':{
                    templateUrl: '/webssr/Views/projectManagement/projectRenaming.html'
                }
            }
        })
        .state('reportManagement', {
            url: '/reportManagement', 
             views: {
                '': {
                    templateUrl: '/webssr/Views/reportManagementModule.html'
                },
                'reportManagementList@reportManagement': {
                    templateUrl: '/webssr/Views/reportManagement/reportManagement.html'
                },
                'reportManagementDetail@reportManagement':{
                    templateUrl: '/webssr/Views/reportManagement/almReport.html'
                }
            }
        })
        .state('almAudit', {
            url: '/almAudit', 
             views: {
                '': {
                    templateUrl: '/webssr/Views/almAuditModule.html'
                },
                'almAuditList@almAudit': {
                    templateUrl: '/webssr/Views/almAudit/almAudit.html'
                },
                'almAuditDetail@almAudit':{
                    templateUrl: '/webssr/Views/almAudit/diskSpace.html'
                }
            }
        })
});
