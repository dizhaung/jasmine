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
            url: '/view/:gid',
            // params:{'blog':{}},
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

app.run(['$rootScope', '$log', function($rootScope, $log){
    /** 设置全局host **/
    $rootScope.host = "http://" + window.location.host;
    // $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    //     $log.debug('successfully changed states') ;
    //     $log.debug('event', event);
    //     $log.debug('toState', toState);
    //     $log.debug('toParams', toParams);
    //     $log.debug('fromState', fromState);
    //     $log.debug('fromParams', fromParams);
    // });
    //
    // $rootScope.$on('$stateNotFound', function(event, unfoundState, fromState, fromParams){
    //     $log.error('The request state was not found: ' + unfoundState);
    // });
    //
    // $rootScope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams, error){
    //     $log.error('An error occurred while changing states: ' + error);
    //
    //     $log.debug('event', event);
    //     $log.debug('toState', toState);
    //     $log.debug('toParams', toParams);
    //     $log.debug('fromState', fromState);
    //     $log.debug('fromParams', fromParams);
    // });
}]);