/**
 * 前端 入口
 *
 * Created by wangjianan on 16-8-25.
 */
var app = angular.module("app", ['ui.router']);
app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function ($stateProvider, $urlRouterProvider, $locationProvider) {
    // 设置默认路由
    $urlRouterProvider.when("", "index");
    $stateProvider
        .state('index', {
            url:'/index',
            template: '<p>大达瓦达瓦的撒旦我的</p>'
        });

    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);