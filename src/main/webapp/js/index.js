$(document).ready(function () {
    /** 首页top 提示 **/
    $('[data-toggle="tooltip"]').tooltip();
});
var model = angular.module('index', []);
model.controller('data', function ($scope, $http) {
    $scope.title = "首页";
    $http({
        method: 'POST',
        url: '/static/getBlogData',
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

