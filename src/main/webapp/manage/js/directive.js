/**
 *
 * Created by wangjianan on 16-8-22.
 */
var angularDirective = angular.module('directive', []);
// angularDirective.directive('checkList', function () {
//     return {
//         scope: {
//             list: '=checkList',
//             numList: '=checkNumList',
//             value: '@'
//         },
//         link: function (scope, elem, attrs) {
//             var checked = elem.prop('checked');
//             elem.bind('click', function () {
//                 // elem.html('You clicked me!');
//             });
//             // alert(index);
//         }
//     };
// });
angularDirective.directive('checkList', function () {
    return {
        scope: {
            list: '=checkList',
            numList: '=checkNumList',
            value: '@'
        },
        link: function (scope, elem, attrs) {
            var handler = function (setup) {
                var checked = elem.prop('checked');
                var index = scope.list.indexOf(scope.value);

                if (checked && index == -1) {
                    if (setup) {
                        elem.prop('checked', false);
                    } else {
                        scope.list.push(scope.value);
                        scope.numList ? scope.numList.push(attrs.reqNum) : "";
                    }
                } else if (!checked && index != -1) {
                    if (setup) {
                        elem.prop('checked', true);
                    } else {
                        scope.list.splice(index, 1);
                        scope.numList ? scope.numList.splice(index, 1) : "";
                    }

                }
            };

            var setupHandler = function () {
                handler(true);
            };
            var changeHandler = function () {
                handler(false);
            };

            elem.bind('change', function () {
                scope.$apply(changeHandler);
            });
            scope.$watch('list', setupHandler, true);
        }
    };
});