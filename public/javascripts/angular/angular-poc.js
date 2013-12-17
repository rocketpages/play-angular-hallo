var app = angular.module('app', []);

app.controller('PreviewCtrl', function ($scope, $window, $http) {
    $scope.previewConfig = {};
    $scope.updateProfile = function() {
          $http({
              method : 'POST',
              url : '/update',
              data : $scope.previewConfig
          })
    };
});

app.directive('hallo', function() {
    return {
       restrict: 'A',
       require: '?ngModel',
       link: function(scope, element, attrs, ngModel) {
           if (!ngModel) {
               return;
           }
           element.hallo({
              plugins: {}
           });
           ngModel.$render = function() {
               element.html(ngModel.$viewValue || '');
           };
           element.on('hallodeactivated', function() {
               ngModel.$setViewValue(element.html());
               scope.$apply();
           });
       }
    };
});