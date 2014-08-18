var app=angular.module("module",['ngCookies'])
app.controller("main",function($scope,$http,$cookieStore){

    if($cookieStore.get("userEmail")!=null) {
        $scope.currentUser = $cookieStore.get("userEmail");
    }
    else
    {
        window.location.replace("/Login.html");
    }

    $scope.logout=function(){
        $cookieStore.put("userEmail",null);
        window.location.replace("/Login.html");

    }
});
