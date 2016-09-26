/**
 * Created by wangjianan on 16-8-25.
 */
var angularDirective = angular.module('directive', []);
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
/***
 * 初始化背景颜色 指令
 */
angularDirective.directive('initBackgroundColor', function () {
    return {
        restrict: 'C',
        // priority: 1, // 指令执行的优先级
        // terminal: true,
        multiElement: true,
        link: function (scope,iEle,iAttrs) {
            iEle.css('margin-right','5px');
            iEle.css('background-color', '#'+Math.floor(Math.random()*16777215).toString(16));
            // iEle.css("border", "1px solid #cccccc");
        }
    };
});

angularDirective.directive('initColor', function () {
    return {
        restrict: 'C',
        // priority: 1, // 指令执行的优先级
        // terminal: true,
        multiElement: true,
        link: function (scope,iEle,iAttrs) {
            iEle.css('margin-right','5px');
            iEle.css('color', '#'+Math.floor(Math.random()*16777215).toString(16));
            iEle.css("border", "1px solid #cccccc");
        }
    };
});