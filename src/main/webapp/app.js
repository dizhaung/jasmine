/**
 * 前端 入口
 *
 * Created by wangjianan on 16-8-25.
 */
var app = angular.module("app", ['ngRoute']);
app.config(function ($routeProvider, $locationProvider) {
    // 设置默认路由
    $routeProvider.when("", "index");
    $routeProvider.when("/", "index");
    $routeProvider
        .when('/index', {
            url: 'index',
            template: '<div><p>lalalal</p></div>'
        })
        .otherwise({
            redirectTo: '/a'
        });


    // $locationProvider.html5Mode({
    //     enabled: false,
    //     requireBase: false
    // });
});