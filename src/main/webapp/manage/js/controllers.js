/**
 *
 * Created by wangjianan on 16-8-15.
 */
var indexControllers = angular.module('indexControllers', ['services', 'directive']);
indexControllers.controller('indexCtrl', ['$scope', 'http', '$location', '$state', function($scope, http, $location, $state){
    var init = function () {
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
    };
    init();
    $scope.tip = "全部";

    /**
     * 删除
     *
     * @param blogGid
     */
    $scope.delete = function (blogGid) {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                http.post('/manage/blog/delete', blogGid).then(
                    function (answer) {
                        var data = answer.data;
                        init();
                    },
                    function (error) {
                        $scope.error = error;
                    }
                );
            }
        });
    };

    /**
     * 修改
     *
     * @param model
     */
    $scope.update = function (model) {
        $state.go("blog", {model: model});
    }
}]);

/**
 *
 * 添加修改Blog
 */
indexControllers.controller('blogCtrl', ['$scope', 'http', 'channel', 'mark', '$state', '$stateParams', function ($scope, http, channel, mark, $state, $stateParams) {
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
    // 初始化公共channel
    if (channel.channels.length <= 0) {
        http.post('/manage/channel/getChannel', {
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0) {
                    var channelList = data.content;
                    channel.init(channelList);
                    $scope.channels = {
                        availableOptions: channel.channels,
                        selectedOption: channel.channels[0]
                    };
                }
            },
            function(error){
                $scope.error = error;
            }
        );
    } else {
        $scope.channels = {
            availableOptions: channel.channels,
            selectedOption: channel.channels[0]
        };
    }

    $scope.modal_title = '文章分类';
    $scope.channelName = '';
    $scope.channelDesc = '';
    $scope.channelModal = function () {
        // 获取分类信息
        var channelName = $scope.channelName;
        var channelDesc = $scope.channelDesc;
        var selectedOption = $scope.channels.selectedOption;
        var channelId = "root";
        if (selectedOption != undefined && selectedOption != null) {
            channelId = selectedOption.gid;
        }
        http.post('/manage/channel/add', {
            channelName : channelName,
            channelDesc : channelDesc,
            channelId : channelId
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0 && data.content != null) {
                    channel.addChannel(data.content);
                    // 关闭模态对话框
                    $('#channel_modal_id').modal('hide')
                }
            },
            function(error){
                alert(error);
            }
        );

    };

    /**
     * init mark
     */
    $scope.markList = [];
    //他是一个数组，所以要在控制器中声明一个数组
    $scope.markNameSelection = [];
    $scope.markGidSelection = [];
    http.post('/manage/mark/getMark', {
    }).then(
        function(answer){
            var data = answer.data;
            if (data.status == 0) {
                var markList = data.content;
                if (markList != null && markList.length > 0) {
                    mark.init(markList);
                    $scope.markList = mark.marks;
                }
            }
        },
        function(error){
            $scope.error = error;
        }
    );

    $scope.mark_title = '文章标签';
    $scope.markName = '';
    $scope.markDesc = '';
    $scope.markModal = function () {
        // 获取标签信息
        var markName = $scope.markName;
        var markDesc = $scope.markDesc;
        http.post('/manage/mark/add', {
            name : markName,
            description : markDesc
        }).then(
            function(answer){
                var data = answer.data;
                if (data.status == 0 && data.content != null) {
                    mark.addMark(data.content);
                    // 关闭模态对话框
                    $('#mark_modal_id').modal('hide')
                }
            },
            function(error){
                alert(error);
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
     * 修改
      */
    function getLoanType(type) {
        var loanType = '原创';
        switch (type) {
            case 0:
                loanType = '原创';
                break;
            case 1:
                loanType = '转载';
                break;
            case 2:
                loanType = '翻译';
                break;
        }
        return loanType;
    }
    var model = $stateParams.model;
    if (model) {
        $scope.name = model.name;
        $scope.type = getLoanType(model.type);
        editor.$txt.html(model.content);
    }
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
        var marks = $scope.markGidSelection;
        if (operation == 0) { // 发表日志
            http.post('/manage/blog/add', {
                name : name,
                type : type,
                channel: channel.gid,
                marks: marks,
                message : html
            }).then(
                function(answer){
                    var data = answer.data;
                    if (data.status == 0) {
                        $state.go('index.list');
                    } else {
                        bootbox.alert(data.message, function() {
                        });
                    }
                },
                function(error){
                    alert(error);
                }
            );
        } else if (operation == 1) { // 保存
            alert(operation);
        } else if (operation == 2) { // 舍弃
            $state.go('index.list');
        }
    };
}]);