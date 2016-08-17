/**
 *
 * Created by wangjianan on 16-8-9.
 */
var app = angular.module("app", ['ngRoute', 'indexControllers', 'httpServices']);
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

/**
 * 添加修改Blog
 *
 */
var blogApp = angular.module("blogApp", []);
blogApp.controller('blogCtrl', ['$scope', function () {
    var editor = new wangEditor('editor');
    // 上传图片
    editor.config.uploadImgUrl = '/upload';
    editor.config.uploadParams = {
        // token1: 'abcde',
        // token2: '12345'
    };
    // 关闭网络上传
    editor.config.hideLinkImg = true;
    editor.create();
}]);

