/**
 *
 * Created by wangjianan on 16-8-15.
 */
var indexControllers = angular.module('indexControllers', ['services']);
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
var blogApp = angular.module("blogApp", ['services']);
blogApp.controller('blogCtrl', ['$scope', 'http', 'channel', function ($scope, http, channel) {
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
     * 初始化类别
     * @type {{availableOptions: *[], selectedOption: {id: string, name: string}}}
     */
    $scope.channels = {
        availableOptions: channel.channels,
        selectedOption: {id: '1', name: '北京'}
    };

    $scope.modal_title = '文章分类';
    $scope.channelName = '';
    $scope.channelDesc = '';
    $scope.channelModal = function () {
        // 获取分类信息
        var channelName = $scope.channelName;
        var channelDesc = $scope.channelDesc;
        var channelId = $scope.channels.selectedOption.id;
        http.post('/manage/channel/add', {
            channelName : channelName,
            channelDesc : channelDesc,
            channelId : channelId
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

    };

    /**
     * 文章类型
     * @param type
     */
    $scope.type = '原创';
    $scope.selectType = function (type) {
        $scope.type = type;
    };

    /**
     * 发表日志
     *
     * @param operation
     */
    $scope.toggle = function (operation) {
        var html = editor.$txt.html();
        var name = $scope.name;
        var type = $scope.type;
        var channel = $scope.channels.selectedOption;
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
