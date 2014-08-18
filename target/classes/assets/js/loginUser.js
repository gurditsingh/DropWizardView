var app=angular.module("module",['ngCookies'])
app.controller("loginUser",function($scope,$http,$cookieStore){
//------------------------------------------------SIGN IN-----------------------------------------------------------//
    $scope.signin=function(){
       var param = "?userEmail=" + $scope.login.userEmail + "&password=" + $scope.login.password;
        $http.get("/api/login/sign"+param)
            .success(function(data) {
               if(String(data)==="true"){
                    $cookieStore.put("userEmail",$scope.login.userEmail);
                    $scope.currentLogin=$cookieStore.get("userEmail");
                   window.location.replace("/main.html");
               }
               else{
                   $("#login-username").css({'border':'2px solid','border-color' : '#A81709'});
                   $("#login-password").css({'border':'2px solid','border-color' : '#A81709'});
                    $cookieStore.put("userEmail",null);
               }

            });
    };

});