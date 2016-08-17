/**
 *
 * Created by wangjianan on 16-8-15.
 */
var indexControllers = angular.module('indexControllers', ['httpServices']);
indexControllers.controller('indexCtrl', ['$scope', 'http', function($scope, http){
    http.post('/manage/getBills', {}).then(
        function(answer){
            var data = answer.data;
            if (data.status == 0) {
                $scope.models = data.content;
            }
        },
        function(error){
            $scope.error = error;
        }
    );
    $scope.tip = "223";
}]);

/**
 *
 * 添加修改Blog
 */
var blogApp = angular.module("blogApp", ['httpServices']);
blogApp.controller('editorCtrl', ['$scope', function ($scope) {
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
blogApp.controller('buttonBlogCtrl', ['$scope', 'http', function ($scope, http) {
    $scope.toggle = function (type) {
        if (type == 0) {
            http.post('/manage/add', {
                name : 'aa',
                message : 'bb'
            }).then(
                function(answer){
                    var data = answer.data;
                    if (data.status == 0) {
                        $scope.models = data.content;
                    }
                },
                function(error){
                    $scope.error = error;
                }
            );
            alert(type);
        } else if (type == 1) {
            alert(type);
        } else if (type == 2) {
            alert(type);
        }
    };
}]);
