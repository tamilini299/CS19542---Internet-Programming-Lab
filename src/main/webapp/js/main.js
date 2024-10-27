/**
 * JavaScript for initial load
 */


function addHorseInfo()
{
	
	var err = "";
	
	if( !($('#horseName').val()) )
	{			
		err = "Please provide valid horse name";
		
	}else if( !($('#horseOwner').val()) )
	{			
		err = "Please provide valid horse owner name";		
	}
	else
	{
		document.forms["addHorse"].submit();
	}
	
	if(err != "")
	{
		enableErrorMsg(err);
	}
}

function submitDiv(page, form)
{
	var form = document.forms[form];
	
	if( page == 'card')
	{
		form.action = '/get/card';
	}
	else if( page == 'play')
	{
		form.action = '/get/horse';
	}
	else if( page == 'balance')
	{
		form.action = '/get/balance';
	}
	else if( page == 'playBet')
	{
		form.action = '/play/bet';
	}
	else if( page == 'viewSumm')
	{
		form.action = '/balance/get/all';
	}
	else if( page == 'horse')
	{
		form.action = '/list/horse';
	}

	form.submit();
}

function playBet(){
	
	var err = "";
	
	if( !($('#betAmount').val()) ||
		( $('#betAmount').val() &&  
		!( $('#betAmount').val().match(/^[\d\.]+$/g))) ){			
		err = "Please provide valid bet amount";
		
	}else if ($('input[name=horseId]:checked').length == 0) {
		err = "Please select a horse to bet";
	}
	else {
		document.forms["placeBet"].submit();
	}
	
	if(err != "")
	{
		enableErrorMsg(err);
	}

}

function submitCard(){
	
	var errorText = "";
	
	if( !($('#userId').val()) )
	{
		errorText = "Not an authorized user";
	}
	else if( !($('#cardOwner').val()) )
	{
		errorText = "Please provide valid card owner";
	}
	else if( !($('#cardNumber').val()) ||
			( $('#cardNumber').val() &&  
			!( $('#cardNumber').val().match(/^[\d-]+$/g))) )
	{	
		errorText = "Please provide valid card number";
	}
	else if( !($('#cardExpiry').val()) ||
			( $('#cardExpiry').val() &&  
			!($('#cardExpiry').val().match(/^[\d/]+$/g))) )
	{	
		errorText = "Please provide valid card expiry";
	}
	else if( !($('#cardCVV').val()) ||
			( $('#cardCVV').val() &&  
			$('#cardCVV').val().length != 3) )
	{
		errorText = "Please provide valid CVV number";
	}
	else
	{
		document.forms["cardForm"].submit();
	}
	
	if(errorText != "")
	{
		enableErrorMsg(errorText);
	}
}

function regUser(){
		
	var errorText = "";
	
	if( !($('#userName').val()) )
	{
		errorText = "Please provide valid user name";
	}
	else if( !($('#password').val()) )
	{
		errorText = "Please provide valid password";
	}
	else if( !($('#firstName').val()) )
	{
		errorText = "Please provide valid first name";
	}
	else if( !($('#lastName').val()) )
	{	
		errorText = "Please provide valid last name";
	}
	else if( !($('#mobileNum').val()) )
	{	
		errorText = "Please provide valid mobile number";
	}
	else if( !($('#emailId').val()) )
	{	
		errorText = "Please provide valid email address";
	}
	else
	{
		document.forms["regForm"].submit();
	}
	
	if(errorText != "")
	{
		enableErrorMsg(errorText);
	}
}

function enableErrorMsg(errorText)
{
	var errDivObj = document.getElementById('errDiv');
	errDivObj.innerHTML = errorText;
	errDivObj.style.border = "1px solid black";
	errDivObj.style.display = "block";
}

function disableErrorMsg()
{
	var errDivObj = document.getElementById('errDiv');
	errDivObj.style.display = "none";
	errDivObj.style.border = "";
	
	if(document.getElementById('wonDiv'))
	{
		document.getElementById('wonDiv').innerHTML = "";
		document.getElementById('wonDiv').style.display = "none";
	}
}


function makePayment(){
	
	if( !($('#balance').val()) ||
		( $('#balance').val() &&  
		!( $('#balance').val().match(/^[\d\.]+$/g))) )
	{
		enableErrorMsg("Please provide valid amount");
	}else 
	{
		document.forms["cardInfoForm"].submit();
	}
}

function changeMainDiv(page)
{
	$('#mainDiv').load(page);
}

function getSummary() 
{
	this.disableErrorMsg();
	//errDivObj = document.getElementById('errDiv').style.display = "none";
  	//document.getElementById("adminPass").value = prompt("Please enter your admin password");
  	this.submitDiv("viewSumm", "navForm");
}

function authenticate()
{
	
	if( !($('#userName').val()) || 
		!($('#password').val()) )
	{			
		var errorText = "Please enter credentials";
		enableErrorMsg(errorText);		
	}
	else{
		
		document.forms["loginForm"].submit();
	}
}

function submitForm(url, method, data)
{
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

$(function() {
    $("#dialogForm").dialog({
        autoOpen: false,
        modal: true,
        buttons: {
            "Submit": function() {
                $("#adminPass").val($("#passInput").val());
                $(this).dialog("close");
                getSummary();
            },
            "Cancel": function() {
                $(this).dialog("close");
            }
        }
    });

    $('#viewSummary').click(function() {
			//$('errDiv').val("none");
			//$('errDiv').style.display = "none";

        	$("#dialogForm").dialog("open");
    });

});

$(document).ready(function() { 
    function disableBack() {
        window.history.forward() 
    } 
    window.onload = disableBack(); 
    window.onpageshow = function(e) { 
        if (e.persisted)
            disableBack(); 
    }
    window.onload = function() {void(0)}
});

