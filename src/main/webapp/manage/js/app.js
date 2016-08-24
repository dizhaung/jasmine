/**
 *
 * Created by wangjianan on 16-8-9.
 */
var app = angular.module("app", ['ui.router', 'indexControllers', 'services', 'directive']);
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    // 设置默认路由
    $urlRouterProvider.when("", "/index/list");
    $stateProvider
        .state('index', {
            url: '/index',
            templateUrl: 'template/index/content.html'
        })
        .state('index.list', {
            url: '/list',
            templateUrl: 'template/index/blog_list.html',
            controller: 'indexCtrl'
        })
        .state('blog', {
            url: '/blog',
            templateUrl: 'template/index/blog_update.html',
            controller: 'blogCtrl',
            params:{'model':{}}
        });
}]);
