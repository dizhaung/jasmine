/**
 *
 * Created by wangjianan on 16-8-15.
 */
var angular = angular.module('indexControllers', ['httpServices']);
angular.controller('indexCtrl', ['$scope', 'http', function($scope, http){
    http.query('/manage/getBills', {}).then(
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
}]);