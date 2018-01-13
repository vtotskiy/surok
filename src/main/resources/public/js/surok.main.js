var app = angular.module("surokAppMain", []);
app.controller("AppCtrl", function($scope, $http){
    $scope.webnames = [];
    $http.get('http://localhost:8096/api/getlist').then(function mySuccess(response) {
        $scope.webnames = response.data;
    });
});