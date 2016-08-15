/**
 *
 * Created by wangjianan on 16-8-15.
 */

var angular = angular.module('indexControllers', []);
angular.controller('indexCtrl', ['$scope', function($scope){
    $scope.title = "首页";
    $scope.models = function () {
        $http({
            method: 'POST',
            url: '/static/getBlogData',
            data: {},
            headers: {'Content-Type': 'application/json'}
        }).success(function (response) {
            if (response.status == 0) {
                return response.content;
            } else {
                alert(response.message)
            }
        })
        .error(function () {
            alert("网络异常，请稍候重试！")
        });
    };
}]);
