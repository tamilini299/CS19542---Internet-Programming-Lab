/**
 * 
 */
function authenticate(){
	
	if( !($('#userName').val()) || !($('#password').val()) ){		
		document.getElementById('errDiv').innerHTML = "Invalid Credentials";
		document.getElementById('errDiv').style.display = "block";
			
		return false;
		
	}else{
		//document.forms["loginForm"].submit();
		submitForm('loginForm', '/user/login', 'POST');
		alert(document.getElementById('responseDiv').innerHTML);
	}
}
function changeMainDiv(page){
	$('#mainDiv').load('templates/' + page); 
}

function changeProcessDiv(page){
	$('#processDiv').load('templates/' + page); 
}

function submitForm(form, url, method){
	var data = {'userName': 'admin', 'password': 'admin'};
	$.ajax({
        url : url,
        
        contentType: "application/json",
        type: method,
        data : JSON.stringify(data),
        dataType: "json",
        
        success : function (resp) {
			document.getElementById('responseDiv').innerHTML = JSON.stringify(resp);
        },
        
        error : function(err) {
			document.getElementById('errDiv').innerHTML = "Application Error. Please try again";
			document.getElementById('errDiv').style.display = "block";
			alert(err.responseText);
   		 }
    });
}

/*changeMainDiv('landing_page.html'){
	
}
*/
		
function validateAnswer(){

	if( correctAns.find(isValidAns) ){
		document.getElementById("score").innerHTML = parseInt(document.getElementById("score").innerHTML) + 1;
		document.getElementById("corAns").style.display = "block";	
		document.getElementById("wrongAns").style.display = "none";
		var nextAreaCount = document.getElementById("nextArea").innerHTML;	
		document.getElementById("gotoButton-" + nextAreaCount).style.background = "#89C994";
		
	}else{
		document.getElementById("corAns").style.display = "none";
		document.getElementById("wrongAns").style.display = "block";

		var nextAreaCount = document.getElementById("nextArea").innerHTML;	
		document.getElementById("gotoButton-" + nextAreaCount).style.background = "#BD8484";				
	}
	
	document.getElementById("validateBtn").style.display = "none";
	document.getElementById("nextBtn").style.display = "block";

}

function isValidAns(ansListOne){

	var selectedAns = document.querySelector('input[name = "inputRadio"]:checked');
	if( selectedAns ){
		return ansListOne == selectedAns.value;
	}
	
}

function showNext(){		
	var currTable = parseInt(document.getElementById("nextArea").innerHTML) + 1;			
	document.getElementById("nextArea").innerHTML = currTable;
	
	document.getElementById("corAns").style.display = "none";
		document.getElementById("wrongAns").style.display = "none";
	
	document.getElementById("inputArea").innerHTML = document.getElementById("questTable-" + currTable).innerHTML;		
	
	document.getElementById("validateBtn").style.display = "block";
	document.getElementById("nextBtn").style.display = "none";
	
	if( currTable == 30 ){
		document.getElementById("nextBtn").disabled = true;
	}else{
		document.getElementById("nextBtn").disabled = false;
	}
}
		
function gotoQuest(pageNo){
	
	if( document.querySelector('#myTimer').innerHTML != "TIME UP!!!" &&
		document.getElementById("gotoButton-" + pageNo).style.background == ""){
		document.getElementById("nextArea").innerHTML = pageNo - 1;
		this.showNext();
	}
}

function closeMe(button){
	document.getElementById(button).style.display = "none";
}
	
		
function startTimer(duration, display) {
	var timer = duration, minutes, seconds;
	setInterval(function () {
		minutes = parseInt(timer / 60, 10)
		seconds = parseInt(timer % 60, 10);

		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		display.textContent = minutes + ":" + seconds;

		if (--timer < 0) {
			timer = 0;
			document.querySelector('#myTimer').innerHTML = "TIME UP!!!";
			document.getElementById("validateBtn").style.display = "none";
			document.getElementById("nextBtn").style.display = "none";

		}
	}, 1000);
}
		
function submitLogin(){
	if( document.querySelector('#username').value.toUpperCase() == "TAMIL" &&	document.querySelector('#password').value == "tamil" ){
		document.querySelector('#loginDiv').style.display = "none";
		document.querySelector('#masterTable').style.display = "block";
		
		var time = 2700, // your time in seconds here
		display = document.querySelector('#myTimer');
		startTimer(time, display);
	}else{
		document.querySelector('#loginErr').style.display = "block";
	}
}

function disableErrorMsg(){
	document.querySelector('#errDiv').style.display = "none";
}
