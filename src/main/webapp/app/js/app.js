/**
 * 前端 入口
 *
 * Created by wangjianan on 16-8-25.
 */
var app = angular.module("app", ['ui.router', 'controllers', 'services', 'directive', 'filter']);
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    // 设置默认路由
    $urlRouterProvider.when("", "/index");
    $urlRouterProvider.when("/", "/index");
    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                "navbar": {
                    templateUrl: 'app/template/navbar.html',
                    controller: 'navbarCtrl'
                },
                "article": {
                    templateUrl: 'app/template/article.html',
                    controller: 'articleCtrl'
                },
                "footer": {
                    templateUrl: 'app/template/footer.html'
                }
            }
        })
        .state('view', {
            url: '/view',
            params:{'blog':{}},
            views: {
                "navbar": {
                    templateUrl: 'app/template/navbar.html',
                    controller: 'navbarCtrl'
                },
                "other": {
                    templateUrl: 'app/template/view.html',
                    controller: 'viewCtrl'
                }
            }
        });
        // .state('index', {
        //     url: '/index',
        //     templateUrl: 'app/template/content.html'
        // })
        // .state('index.list', {
        //     url: '/list',
        //     views: {
        //         "navbar": {
        //             templateUrl: 'app/template/navbar.html',
        //             controller: 'navbarCtrl'
        //         },
        //         "article": {
        //             templateUrl: 'app/template/article.html',
        //             controller: 'articleCtrl'
        //         },
        //         "footer": {
        //             templateUrl: 'app/template/footer.html'
        //         }
        //     }
        // });
}]);
