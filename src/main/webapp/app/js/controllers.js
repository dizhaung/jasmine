/**
 * Created by wangjianan on 16-8-25.
 */
var controller = angular.module('controllers', ['services', 'directive']);
controller.controller('navbarCtrl', ['$scope', function ($scope) {
    // 导航栏控制器
}]);
controller.controller('articleCtrl', ['$scope', 'http', function ($scope, http) {
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
    $scope.blog = null;

}]);

controller.controller('viewCtrl', ['$scope', 'http', '$stateParams', function ($scope, http, $stateParams) {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();

    // 内容控制器
    var model = $stateParams.blog;
    alert(model);
}]);

controller.controller('indexCtrl', ['$scope', 'http', '$location', '$state', function($scope, http, $location, $state){
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