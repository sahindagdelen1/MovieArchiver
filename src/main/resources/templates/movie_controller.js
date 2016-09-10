'use strict';

App.controller('MovieController', ['$scope', 'MovieService', function($scope, MovieService) {
    var self = this;
    self.movie={id:null,title:'',year:''};
    self.movies=[];

    self.fetchAllMovies = function(){
        MovieService.fetchAllMovies()
            .then(
            function(d) {
                self.movies = d;
            },
            function(errResponse){
                console.error('Error while fetching movies');
            }
        );
    };
}]);