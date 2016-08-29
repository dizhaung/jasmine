/**
 * app filter
 *
 * Created by wangjianan on 16-8-25.
 */
var filter = angular.module('filter', []);
filter.filter('htmlContent', ['$sce', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    };
}]);