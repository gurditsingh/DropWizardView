var app=angular.module("module",[])
app.controller("SignUp",function($scope,$http){

//------------------------------------------------SIGN IN HOUSE-----------------------------------------------------------//
    $scope.hsave=function(){
        var param = "?hName=" + $scope.signup.hName+"&hEmail=" + $scope.signup.hEmail + "&hPassword=" + $scope.signup.hPassword;
        $http.post("/api/signup/house"+param)
            .success(function(data) {
            });
    };

});

app.controller("MemberSignUp",function($scope,$http){

//------------------------------------------------SIGN IN MEMBER-----------------------------------------------------------//
    $scope.msave=function(){
        var param = "?mName=" + $scope.signup.mName+"&mEmail=" + $scope.signup.mEmail + "&mPassword=" + $scope.signup.mPassword +"&hEmail=singh";
        $http.post("/api/signup/member"+param)
            .success(function(data) {
                alert("saved");
            });
    };

});