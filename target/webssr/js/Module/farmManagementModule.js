/**
 * Module
 * Farm Management
 * @type {[angularjs:module]}
 */
var farmManagementModule = angular.module("FarmManagementModule", []);
farmManagementModule.controller('farmManagement', function($scope, $http, $state, $stateParams) {
    $scope.addUserClick=function(){
    	window.location.href="#/farmManagement";
    }
	
	$scope.accessToALMPSClick=function(){
		window.location.href="#/accessToALMProjectSandbox";
    }
	
	$scope.disconnectAlmSessionsClick=function(){
		window.location.href="#/disconnectAllMyALMSessions";
	}
});


/**
 * Controller
 * addUserToALM Controller
 * @type {[anjularjs:controller]}
 */
farmManagementModule.controller('addUserToAlmController', [ '$scope', 'addUserToALMService',
	function($scope , addUserToALMService) {
	    var selectFarm=null;
	    var userName=null;
	    
	    $scope.farmList=getAllFarm();
	    
	    $scope.farmListChange=function(){
	    	selectFarm=$scope.addUser.QCFarm;
	    	addUserToALMService.changeStatus(selectFarm,userName);
	    }
	    
	    $scope.userNameChange=function(){
	    	userName=$scope.addUser.QCUsers;
	    	addUserToALMService.changeStatus(selectFarm,userName);
	    }
	    
	    //Verify Btn Click
	    $scope.verifyBtnClick=function(){
	    	addUserToALMService.checkUserFormat(userName);
	    }
	    
	    $scope.addUserBtnClick=function(){
	    	$.ajax({
				url:'/webssr/addUser.do',
				type:'POST',
				data:{farm:"qc1f.austin.hp.com",user:"roy"},
				//dataType:'json',
				success:function(e){
					console.log(e.notok);
				},
				error:function(e)
				{
					console.log(e);
				}
			});
	    }
	}
]);

farmManagementModule.controller('accessController', 
	function($scope, $http, $state, $stateParams) {
		$scope.farm="roy";
		$scope.test1=function(){
			alert(1);
		}
	}
);

/**
 * Service
 * addUserToALM Service
 * @type {[angularjs:service]}
 */
farmManagementModule.factory('addUserToALMService',['$http',
	function($http){
		//Change Verify Btn Status
		var changeStatusResult=function(selectFarm,userName){
			if(selectFarm!=null &&selectFarm!="" && userName!=null && userName!=""){
				$("#btnVerify").attr("class","btn-Primary");
			}else{
				$("#btnVerify").attr("class","btn-Secondary");
			}	
		}
		//Check User Repeat
		var checkRepeatUser = function (obj) {
	        var userList = document.getElementById("userList");
	        var childList = userList.childNodes;
	        for (var i = 0; i < childList.length; i++) {
	            if (childList[i].innerHTML == obj.innerHTML) {
	                return false;
	            }
	        }
	        return true;
		}
		//Open Warning Layer
		var oepnWarningLayer=function(str){
			var div=document.createElement("div");
			div.className="alert alert-warning";
			div.innerHTML=str;
			div.role="alert";
			document.getElementById("warningBox").appendChild(div);
			$("#warningBox").show('slow');
		}
		//Check User format
		var checkUserFormatResult=function(userName){
			if(userName!="" && userName!=null){
				$("#warningBox").hide('slow');
				$("#warningBox").html("");
				var isMail=false;
				var regMail=/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
				if(regMail.test(userName)){
					var userList = document.getElementById("userList");
		            var childDiv = document.createElement("div");
		            childDiv.className="userChild";
		            childDiv.align="left";
		            if ($("#userList")[0].childElementCount > 0) {
		                childDiv.style.borderTop = "0px";
		            }
		            childDiv.innerHTML = "<img src='/webssr/img/addUserToALM/trash-blue.png' width='20' onclick='removeUser(this)'/><p>" + userName+ "</p>";
					
		            var boolRepeat = checkRepeatUser(childDiv);
		            if (boolRepeat) {
		                userList.appendChild(childDiv);
		                $(".readyUserList").css("display","inline-block");
		                $("#btnAddUser").attr("class","btn-Primary");
		            }else{
		            	oepnWarningLayer("This user already exists in the list!");
		            	return false;
		            }
					isMail=true;
				}else{
					oepnWarningLayer("Mail format is error!");
					isMail=false;
				}
			}
		}
		
		return {
			changeStatus:changeStatusResult,
			checkUserFormat:checkUserFormatResult
		}
	}
]);

function removeUser(obj){
	var parent=obj.parentNode;
	document.getElementById("userList").removeChild(parent);
	$("#userList").find("div:first-child").css("border-top", "1px solid #d5d5d5");
	if($("#userList")[0].childElementCount <=0){
		$("#btnAddUser").attr("class","btn-Secondary");
		$(".readyUserList").css("display","none");
	}
}

function getAllFarm(){
	var list=new Array();
	$.ajax({
		url:'/webssr/queryAllFarmList.do',
		type:'POST',
		data:{},
		async:false,
		//dataType:'json',
		success:function(e){
			if(e!=null && e!=""){
				list=e.split(";");
			}
		},
		error:function(e)
		{
			console.log(e);
		}
	});
	return list;
}
