/**
 *
 * Created by wangjianan on 16-8-9.
 */
var app = angular.module("app", ['ngRoute', 'indexControllers']);
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/index', {
            templateUrl: 'template/content.html',
            controller: 'indexCtrl'
        })
        .otherwise({
            redirectTo: '/index'
        });
}]);
