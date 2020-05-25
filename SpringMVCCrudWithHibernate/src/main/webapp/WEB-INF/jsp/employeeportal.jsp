<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- External Java Script : Configure  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/employeeportal.js"></script>

<!-- External CSS : Configure  -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employeeportal.css" />

</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Employees</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover" id="Emptable">
                <thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Telephone</th>
						<th>Action</th>

					</tr>
				</thead>
                <tbody>
                <c:forEach var="employee" items="${listEmployee}">
                    <tr id="tr_${employee.id}">
                        <td id="empname${employee.id}">${employee.name}</td>
                        <td id="empemail${employee.id}">${employee.email}</td>
						<td id="empaddress${employee.id}">${employee.address}</td>
						<td id="emptelephone${employee.id}">${employee.telephone}</td>
                        <td id="deleterow${employee.id}">
                           <a href="#" class="edit" onclick="editEmployee(${employee.id});" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>                          
                       
                        <!-- deleteEmployeeModal 	editEmployeeModal	-->
                        
                        <a href="#" class="delete" data-toggle="modal" onclick="deleteRow(${employee.id});"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                         	<%-- <button type="button" class="delete-row delete" id="${employee.id}" onclick="deleteRow(${employee.id});">Delete Row</button> --%>
                        </td>                       
                        <td style="display:none;">${employee.id}</td>
                    </tr>
                    </c:forEach>                     
                </tbody>
            </table>
			
        </div>
    </div>	
    
    <!-- Add Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
					<f:form action="saveEmployee" method="post" commandName="employee"
						onSubmit="return checkformWhileAdding()">
					<div class="modal-header">						
						<h4 class="modal-title">Add Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="this.form.reset();closeAddPopUp();">&times;</button>
					</div>
					
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<f:input path="name" id="name" name="name" type="text" class="form-control" onfocusout="validationForNameAdd();"></f:input>
							<label id="nameErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Email</label>
							<f:input path="email" id="email" name="email" type="text" class="form-control" onfocusout="validationForEmailAdd();"></f:input>
							<label id="emailErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Address</label>
							<f:input path="address" id="address" name="address" type="text" class="form-control" onfocusout="validationForAddressAdd();"></f:input>
							<label id="addressErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Phone</label>
							<f:input path="telephone" id="telephone" name="telephone" type="text" class="form-control" onfocusout="validationForPhoneAdd();"
							onkeypress="javascript:return isNumber(event)"></f:input>
							<label id="telephoneErrMsg" style="display: none"></label>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" onclick="this.form.reset();closeAddPopUp();">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</f:form>
			</div>
		</div>
	</div>    
    
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<f:form action="updateEmployee" method="post" modelAttribute="employee" 
					onSubmit="return checkformWhileEdditing()">
					<div class="modal-header">						
						<h4 class="modal-title">Edit Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<f:input path="name" id="editName" type="text" class="form-control" value="" onfocusout="validationForNameEdit();"/>
							<label id="editNameErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Email</label>
							<f:input path="email" id="editEmail" type="text" class="form-control" value="" onfocusout="validationForEmailEdit();"/>
							<label id="editEmailErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Address</label>
							<f:input path="address" id="editAddress" type="text" class="form-control" value="" onfocusout="validationForAddressEdit();"/>
							<label id="editAddressErrMsg" style="display: none"></label>
						</div>
						<div class="form-group">
							<label>Phone</label>
							<f:input path="telephone" id="editTelephone" type="text" class="form-control" value="" onfocusout="validationForPhoneEdit();" 
							onkeypress="javascript:return isNumber(event)"/>
							<label id="editTelephonelErrMsg" style="display: none"></label>
						</div>		
						<div class="form-group">
							<f:input path="id" id="editId" type="hidden" class="form-control" value="" />
						</div>		
									
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</f:form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" id="cancelBtn" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" id="deleteBtn" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>                                		                            