/**
 * app controller
 *
 * Created by wangjianan on 16-8-25.
 */
var controller = angular.module('controllers', ['services', 'directive', 'filter']);
controller.controller('navbarCtrl', ['$scope', 'channel', 'http', function ($scope, channel, http) {
    // 导航栏控制器
    $scope.navbarList = [];
    if (channel.channels.length <= 0) {
        http.post('/channel/getChannel', {
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    var channelList = data.content;
                    if (channelList != null && channelList.length > 0) {
                        channel.init(channelList);
                        $scope.navbarList = channel.channels;
                    }
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    }

    $scope.toChannelBlog = function (channelGid) {
        alert(channelGid);
    };

}]);
controller.controller('articleCtrl', ['$scope', 'http', '$state', function ($scope, http, $state) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    // 内容控制器
    var init = function () {
        http.post('/index/getBills', {}).then(
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
    };
    init();

    var randomColor = function () {
        return '#'+Math.floor(Math.random()*16777215).toString(16);
    };

    var initMarkTagClass = function (markList) {
        var minFontSize = 8;
        var maxFontSize = 40;

        var maxCount = 0;
        var length = markList.length;
        for (var i = 0; i < length; i++ ) {
            if (maxCount < markList[i].count) {
                maxCount = markList[i].count;
            }
        }

        for (var j = 0; j < length; j++ ) {
            var mark = markList[j];
            var count = mark.count;
            var tag = ((count / maxCount) * 4 + 1) * minFontSize;
            var size = 10 + mark.count * 4;
            mark.class = "font-size: "+ size +"px; color: "+ randomColor() +"";
        }

        return markList;
    };

    // 标记
    var initMark = function () {
        http.post('/mark/getMark', {}).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    $scope.markList = initMarkTagClass(data.content);
                }
            },
            function(error){
                $scope.error = error;
            }
        );

    };
    initMark();

    $scope.goView = function (blog) {
        $state.go("view", {blog: blog});
    };

}]);

controller.controller('viewCtrl', ['$scope', 'http', '$state', '$stateParams', function ($scope, http, $state, $stateParams) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    // 内容控制器
    var model = $stateParams.blog;
    if (model != null) {
        $scope.model = model;
    }
}]);