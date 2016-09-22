/**
 * app controller
 *
 * Created by wangjianan on 16-8-25.
 */
var controller = angular.module('controllers', ['services', 'directive', 'filter']);
controller.controller('navbarCtrl', ['$scope', 'channel', 'http', 'blogList', function ($scope, channel, http, blogList) {
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
    } else {
        $scope.navbarList = channel.channels;
    }

    $scope.toChannelBlog = function (channelGid) {
        http.post('/index/getBills', {
            'channelGid': channelGid,
            'markGid': null
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    blogList.init(data.content.blogList);
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    };

}]);
controller.controller('articleCtrl', ['$scope', 'http', '$state', 'blogList', function ($scope, http, $state, blogList) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    // 首页Blog 列表
    var init = function () {
        http.post('/index/getBills', {
            'channelGid': null
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    var resultMap = data.content;
                    blogList.init(resultMap.blogList);
                    $scope.newBlogList = resultMap.newBlogList;
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    };
    init();

    $scope.$on('init.blog.update', function(newVal, oldVal) {
        $scope.models = blogList.blogList;
    });

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

    var initColor = function () {
        alert();
        var color = "margin-right: 5px; background-color: "+  randomColor() +";";
        console.log(color);
    };

    /**
     * 标记
     *
     */
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

    $scope.toMarkBlog = function (mark) {
        http.post('/index/getBills', {
            'channelGid': null,
            'markGid': mark.markGid
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    blogList.init(data.content.blogList);
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    };

    /**
     * 导向详细视图
     * @param blog
     */
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