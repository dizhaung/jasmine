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
controller.controller('articleCtrl', ['$scope', 'http', '$state', 'blogList', '$timeout', function ($scope, http, $state, blogList, $timeout) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    var initIndex = function () {
        /** 文章首页Blog列表 **/
        http.post('/index/getBills', {
            'channelGid': null
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    // 首页列表
                    blogList.init(data.content.blogInfoList);
                    // 最新文章
                    $scope.newArticleList = data.content.newArticleList;
                    // 友情链接
                    $scope.friendshipLinkList = data.content.friendshipLinkList;
                }
            },
            function(error){
                $scope.error = error;
            }
        );
        /** 标签 **/
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

    initIndex();

    $scope.$on('init.blog.update', function(newVal, oldVal) {
        $scope.models = blogList.blogList;
    });

    /** 标签云的实现 **/
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


    $scope.toMarkBlog = function (markGid) {
        http.post('/index/getBills', {
            'channelGid': null,
            'markGid': markGid
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
    $scope.goView = function (gid) {
        $state.go("view", {gid: gid});
    };
}]);

controller.controller('viewCtrl', ['$scope', 'http', '$state', '$stateParams', function ($scope, http, $state, $stateParams) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    // 内容控制器
    var blogGid = $stateParams.gid;
    if (blogGid != null) {
        http.post('/index/getBillDetail', {
            'blogGid' : blogGid
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    var response = data.content;
                    $scope.model = response.blogLoan;
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    }
}]);
