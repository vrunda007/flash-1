

//Function for delete record
function deleteRow(currentRowId) {
	$.ajax({
			type: "POST",
			url: "/SpringMVCCrudWithHibernate/employee/delete/" + currentRowId,
			cache: false,
			success : function(data) {
				$("#deleterow"+currentRowId).parent().remove();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
}

//Function for edit record
function editEmployee(employeeId){
	
	    $("#editName").val($("#empname"+employeeId).text());
		$("#editEmail").val($("#empemail"+employeeId).text());
		$("#editAddress").val($("#empaddress"+employeeId).text());
		$("#editTelephone").val($("#emptelephone"+employeeId).text());
		$("#editEmployeeModal").modal("toggle");
		$("#editId").val(employeeId);
}

// validation for telephone number should allow only numbers
function isNumber(evt) {
    var iKeyCode = (evt.which) ? evt.which : evt.keyCode
    if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
        return false;

    return true;
}

/*********************************************************************
 * 			All validation while adding employee
 *********************************************************************/

//function for while Adding form should not submit without all field
function checkformWhileAdding(){
	
	var name = $("#name").val();
	var email = $("#email").val();
	var address = $("#address").val();
	var telephone = $("#telephone").val();
	var checkEmail = validationForEmailAdd();
	var checkName = validationForNameAdd();
	var checkAddress = validationForAddressAdd();
	var checkPhone = validationForPhoneAdd();
	if (name == "" || checkName ==  false || name == null){
		return false;
	}else if (email == "" || checkEmail == false || email == null){
		return false;
	}else if (address == "" || checkAddress == false || address == null){
		return false;
	}else if (telephone == "" || checkPhone == false || telephone == null){
		return false;
	}
	return true;
}

// function validation For Name while Adding employee
function validationForNameAdd(){
	var name = $("#name").val();
	if(name == ""){
		$("#name").css("border" ,"2px solid red");
		$("#nameErrMsg").css("display","block");
		$("#nameErrMsg").text("Please enter Name");
		$("#nameErrMsg").css("color","red");
		return false;
	}else{
		$("#name").css("border" ,"2px solid green");
		$("#nameErrMsg").text("");
		return true;
	}
}

//function validation For Email while Adding employee
function validationForEmailAdd(){
	var email = $("#email").val();

	var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
		var b=emailfilter.test(email);
		
		if(b==false)
		{
			$("#email").css("border" ,"2px solid red");
			$("#emailErrMsg").css("display","block");
			$("#emailErrMsg").text("john@gmail.com  OR  john@xyz.co.in");
			$("#emailErrMsg").css("color","red");
			return false;
		}else{
			$("#email").css("border" ,"2px solid green");
			$("#emailErrMsg").text("");
			return true;
		}
}

//function validation For Address while Adding employee
function validationForAddressAdd(){
	
	var address = $("#address").val();
	if(address == ""){
		$("#address").css("border" ,"2px solid red");
		$("#addressErrMsg").css("display","block");
		$("#addressErrMsg").text("Please enter Address");
		$("#addressErrMsg").css("color","red");
		return false;
	}else{
		$("#address").css("border" ,"2px solid green");
		$("#addressErrMsg").text("");
		return true;
	}
}

//function validation For Telephone while Adding employee
function validationForPhoneAdd(){
	var telephone = $("#telephone").val();
	if(telephone == ""){
		$("#telephone").css("border" ,"2px solid red");
		$("#telephoneErrMsg").css("display","block");
		$("#telephoneErrMsg").text("Please enter Telephone");
		$("#telephoneErrMsg").css("color","red");
		return false;
	}else{
		$("#telephone").css("border" ,"2px solid green");
		$("#telephoneErrMsg").text("");
		return true;
	}
}

//function to reset all fields while Adding employee when click on close symbol or cancel button
function closeAddPopUp(){
		
	$("#name").css("border" ,"");
	$("#nameErrMsg").hide();
	
	$("#email").css("border" ,"");
	$("#emailErrMsg").hide();
	
	$("#address").css("border" ,"");
	$("#addressErrMsg").hide();
	
	$("#telephone").css("border" ,"");
	$("#telephoneErrMsg").hide();
}

/*********************************************************************
 * 			All validation while editing employee
 *********************************************************************/


//function for while editing form should not submit without all field
function checkformWhileEdditing()
{
	var name = $("#editName").val();
	var email = $("#editEmail").val();
	var address = $("#editAddress").val();
	var telephone = $("#editTelephone").val();
	var checkEmail = validationForEmailEdit();
	if (name == "")
	{
		return false;
	}
	else if (email == "")
	{
		return false;
	}else if(checkEmail == false){
		return false;
	}
	else if (address == "")
	{
		return false;
	}else if (telephone == ""){
		return false;
	}
	return true;
}



function validationForNameEdit(){
	var editName = $("#editName").val();
	if(editName == ""){
		$("#editName").css("border" ,"2px solid red");
		$("#editNameErrMsg").css("display","block");
		$("#editNameErrMsg").text("Please enter Name");
		$("#editNameErrMsg").css("color","red");
	}else{
		$("#editName").css("border" ,"2px solid green");
		$("#editNameErrMsg").text("");
	}

}

function validationForEmailEdit(){

	var editEmail = $("#editEmail").val();

	var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
	var b=emailfilter.test(editEmail);
	
	if(b==false)
	{
		$("#editEmail").css("border" ,"2px solid red");
		$("#editEmailErrMsg").css("display","block");
		$("#editEmailErrMsg").text("john@gmail.com  OR  john@xyz.co.in");
		$("#editEmailErrMsg").css("color","red");
		return false;
	}else{
		$("#editEmail").css("border" ,"2px solid green");
		$("#editEmailErrMsg").text("");
		return true;
	}
}

function validationForAddressEdit(){
	
	var editAddress = $("#editAddress").val();
	if(editAddress == ""){
		$("#editAddress").css("border" ,"2px solid red");
		$("#editAddressErrMsg").css("display","block");
		$("#editAddressErrMsg").text("Please enter Address");
		$("#editAddressErrMsg").css("color","red");
	}else{
		$("#editAddress").css("border" ,"2px solid green");
		$("#editAddressErrMsg").text("");
	}
}

function validationForPhoneEdit(){
	var editTelephone = $("#editTelephone").val();
	if(editTelephone == ""){
		$("#editTelephone").css("border" ,"2px solid red");
		$("#editTelephonelErrMsg").css("display","block");
		$("#editTelephonelErrMsg").text("Please enter Telephone");
		$("#editTelephonelErrMsg").css("color","red");
	}else{
		$("#editTelephone").css("border" ,"2px solid green");
		$("#editTelephonelErrMsg").text("");
	}
}


function hideErrorMsg(){
	$("#loginErrMsg").text("");
}