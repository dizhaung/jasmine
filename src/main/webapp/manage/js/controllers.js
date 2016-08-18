/**
 *
 * Created by wangjianan on 16-8-15.
 */
var indexControllers = angular.module('indexControllers', ['httpServices']);
indexControllers.controller('indexCtrl', ['$scope', 'http', '$location', function($scope, http, $location){
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
    
    // 添加
    $scope.add = function (url_) {
        var host = $location.host();
        var port = $location.port();
        var protocol = $location.protocol();
        var url = protocol + "://" + host + ":" + port + "/manage/" + url_;
        window.location.href = url;
    }
}]);

/**
 *
 * 添加修改Blog
 */
var blogApp = angular.module("blogApp", ['httpServices']);
blogApp.controller('blogCtrl', ['$scope', 'http', function ($scope, http) {
    /**
     * 创建编辑器
     *
     * @type {wangEditor}
     */
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

    /**
     * 发表日志
     *
     * @param operation
     */
    $scope.toggle = function (operation) {
        alert(operation);
        var html = editor.$txt.html();
        var name = $scope.name;
        var type = $scope.type;
        if (operation == 0) { // 发表日志
            http.post('/manage/add', {
                name : name,
                type : type,
                message : html
            }).then(
                function(answer){
                    var data = answer.data;
                    if (data.status == 0) {
                        alert(data.message);
                    }
                },
                function(error){
                    $scope.error = error;
                }
            );
        } else if (operation == 1) { // 保存
            alert(operation);
        } else if (operation == 2) { // 舍弃
            alert(operation);
        }
    };
}]);
