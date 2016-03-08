var thugCodeApp = angular.module('thugCodeApp', [ 'ngRoute', 'ngResource',
		'ui.router', 'oc.lazyLoad','angular-loading-bar']);
thugCodeApp.factory('UsersFactory',function($resource){
    return $resource('/user/getAll/');
});
thugCodeApp.factory('UserSaveFactory',function($resource){
    return $resource('/admin/register');
});
thugCodeApp.factory('UserEditFactory',function($resource){
    return $resource('/user/edit/:id', {id:'@id'});
});
thugCodeApp.factory('UserDeleteFactory',function($resource){
    return $resource('/user/delete/:id', {id:'@id'});
});
thugCodeApp.factory('UserLoginFactory',function($resource){
    return $resource('/user/check-login/');
});