/**
 *
 * Created by wangjianan on 16-8-16.
 */
var angularServices = angular.module('services', []);
angularServices.service('http', ['$http', '$q', function ($http, $q) {
    return{
        post: function (url, data) {
            var deferred = $q.defer();
            var promise = $http({
                method: 'POST',
                url: url,
                data: data,
                headers: {'Content-Type': 'application/json'}
            });
            promise.then(
                // 通讯成功的处理
                function(answer){
                    //在这里可以对返回的数据集做一定的处理,再交由controller进行处理
                    answer.status = true;
                    deferred.resolve(answer);
                },
                // 通讯失败的处理
                function(error){
                    // 可以先对失败的数据集做处理，再交由controller进行处理
                    error.status = false;
                    deferred.reject(error);
                }
            );
            return deferred.promise
        }
    }
}]);

angularServices.service('channel', ['$rootScope', function ($rootScope) {
    var service = {
        channels: [
            {id: '1', name: '北京'},
            {id: '2', name: '上海'},
            {id: '3', name: '广州'},
            {id: '4', name: '长春'}
        ],
        addChannel: function (channel) {
            service.channels.push(channel);
            $rootScope.$broadcast('channel.update');
        }
    };
    return service;
}]);