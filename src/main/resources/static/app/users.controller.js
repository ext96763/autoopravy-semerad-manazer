(function () {
    'use strict';

    angular
        .module('app')
        .controller('ManagerController', ManagerController);

    ManagerController.$inject = ['$http'];

    function ManagerController($http) {
        var vm = this;

        vm.users = [];
        vm.getAll = getAll;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/manager/users";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.users = response.data;
            });
        }

    }
})();
