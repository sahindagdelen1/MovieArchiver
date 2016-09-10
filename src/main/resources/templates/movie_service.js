'use strict';

App.factory('MovieService', ['$http', '$q', function($http, $q){

    return {

        fetchAllMovies: function() {
            return $http.get('http://localhost:8080/movies/all')
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching users');
                    return $q.reject(errResponse);
                }
            );
        }


    };

}]);