/**
 * Created by wangjianan on 16-8-25.
 */
var app = angular.module("app", ['ui.router', 'controllers', 'services', 'directive']);
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
        });
}]);
