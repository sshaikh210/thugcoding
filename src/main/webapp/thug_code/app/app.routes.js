var thugCodeApp = angular.module('thugCodeApp');

thugCodeApp.config(['$stateProvider', '$urlRouterProvider','cfpLoadingBarProvider',
                                           function($stateProvider, $urlRouterProvider,cfpLoadingBarProvider){
    cfpLoadingBarProvider.includeSpinner = true;
    $urlRouterProvider.otherwise("/home");

	$stateProvider.
	state('home', {
	    url:'/home',
		templateUrl: '/thug_code/app/components/home/homeView.html',
		controller: 'homeController',
		resolve: {
                  loadPlugin: function($ocLazyLoad) {
                      return $ocLazyLoad.load ([
                          {
                              name: 'homeModule',
                              serie: true,
                              files: [
                                   '/thug_code/app/components/home/homeModule.js',
                                   '/thug_code/assets/js/functions.js'
                              ]
                          }
                      ])
                  }
              }
	}).
	state('rbac', {
    	    url:'/usermanagement',
    		templateUrl: '/thug_code/app/components/rbac/rbacView.html',
    		controller: 'rbacController',
    		resolve: {
                      loadPlugin: function($ocLazyLoad) {
                          return $ocLazyLoad.load ([
                              {
                                  name: 'rbacModule',
                                  serie: true,
                                  files: [
                                       '/thug_code/app/components/rbac/rbacModule.js',
                                       '/thug_code/assets/js/functions.js'
                                  ]
                              }
                          ])
                      }
             }
    });
}]);