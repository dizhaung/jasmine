/**
 * Created by wangjianan on 16-6-24.
 */
$(document).ready(function () {
    $('#to').collapse('toggle')
});

/**
 * 绑定页面加载数据
 */
var model;
model = angular.module('manageIndex', []);
model.controller('data', function ($scope, $http) {
    $scope.title = "首页"
    $http({
        method: 'POST',
        url: '/manage/getBills',
        data: {},
        headers: {'Content-Type': 'application/json'}
    }).success(function (response) {
            if (response.status == 0) {
                var content = response.content;
                $scope.models = content;
            } else {
                alert(response.message)
            }
        })
        .error(function () {
            alert("网络异常，请稍候重试！")
        });
});