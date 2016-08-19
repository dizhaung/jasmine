/**
 *
 * Created by wangjianan on 16-8-9.
 */
var app = angular.module("app", ['ngRoute', 'indexControllers', 'services']);
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/index', {
            templateUrl: 'template/blog_list.html',
            controller: 'indexCtrl'
        })
        .otherwise({
            redirectTo: '/index'
        });
}]);

app.controller('index', function ($scope) {
    $scope.title = '首页';
    $scope.name = '首页';
});
