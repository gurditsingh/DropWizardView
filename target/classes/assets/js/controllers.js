var app=angular.module("module",[])

app.controller("ctrl",function($scope,$http){
//------------------------------------------------LOADING-----------------------------------------------------------//

    $http.get("/api/user/show")
                   .success(function(data) {
                       $scope.users = data;
                   });
     $http.get("/api/user/count")
                        .success(function(data) {
                            $scope.total = data;
                        });

//------------------------------------------------SAVE AND UPDATE-----------------------------------------------------------//
    $scope.call=function(){
    if($scope.new.UID==null){
         var urlString = "fname=" + $scope.new.fname + "&lname=" + $scope.new.lname + "&phone=" + $scope.new.phone + "&email=" + $scope.new.email;

            $http.get("/api/user/add?" + urlString ).success(function(data) {
                console.log("information saved...");
                $http.get("/api/user/show")
                                   .success(function(data) {
                                       $scope.users = data;
                                   })   ;

            }).error(function(e){
                                  console.log(e);

                              });
                              $scope.new="";
    }
    else{
         var urlString = "fname=" + $scope.new.fname + "&lname=" + $scope.new.lname + "&phone=" + $scope.new.phone + "&email=" + $scope.new.email + "&UID=" + $scope.new.UID;

            $http.get("/api/user/update?" + urlString ).success(function(data) {
                console.log("information saved...");
                $http.get("/api/user/show")
                                   .success(function(data) {
                                       $scope.users = data;

                                   });

            }).error(function(e){
                                  console.log(e);

                              });
                              $scope.new="";
    }
    }


//------------------------------------------------CLEAR FORM-----------------------------------------------------------//


    $scope.clear=function(){
            $scope.new="";
        }

//------------------------------------------------DELETE--------------------------------------------------------------//

        $scope.delete=function(id){
             $http.get("/api/user/delete/"+id)
                                 .success(function(data) {
                                  $http.get("/api/user/show")
                                                 .success(function(data) {
                                                     $scope.users = data;

                                                 });
                                 });
        }


//------------------------------------------------FIND-----------------------------------------------------------//

        $scope.find=function(id){
                   $http.get("/api/user/find/"+id)
                                                    .success(function(data) {
                                                    $scope.new=data;

                                                    });
                }

//------------------------------------------------FIND-----------------------------------------------------------//

    search=function(){
        if($scope.Sname==""){
         $http.get("/api/user/show")
                           .success(function(data) {
                               $scope.users = data;

                           });
        }
        else{
        $http.get("/api/user/search/"+$scope.Sname)
                   .success(function(data) {
                   $scope.users = data;

          });
        }
    }

});
