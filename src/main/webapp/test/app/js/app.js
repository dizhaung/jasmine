/**
 * 前端 入口
 *
 * Created by wangjianan on 16-8-25.
 */
var app = angular.module("app", ['ngRoute', 'controllers']);
app.config(function ($routeProvider, $locationProvider) {
    // 设置默认路由
    $routeProvider
        .when('/index', {
            url: 'index',
            template: '<div><p><a href="update">dasdasd</a></p></div>',
            controller: 'navbarCtrl'
        })
        .when('/update', {
            url: 'update',
            template: '<div><p>update</p></div>',
            controller: 'navbarCtrl'
        })
        .otherwise({
            redirectTo: '/index'
        });

    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});