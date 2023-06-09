<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>   
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
 
</head>
<body>
    <div class="container">
             <h3 class="pb-1 pt-3">Report Application</h3>
             <br>
             <form:form action="search" modelAttribute="request" method="POST">
                 <table>
                     <!-- row#1 -->
                     <tr>
                        <td>Plan Name: </td>
                        <td>
                           <form:select path="planName">
                              <form:option value="">-SELECT-</form:option>
                              <form:options items="${names }"/>
                           </form:select>&nbsp; &nbsp;&nbsp;
                        </td>

                         <td>Plan Status: </td>
                         <td>
                            <form:select path="planStatus">
                               <form:option value="">-SELECT-</form:option>
                               <form:options items="${status }"/>
                            </form:select>
                         </td>
                         <td>Gender:</td>
                         <td>
                            <form:select path="gender">
                               <form:option value="">-SELECT-</form:option>
                               <form:option value="Male">Male</form:option>
                               <form:option value="Fe-Male">Fe-Male</form:option>
                            </form:select>
                         </td>
                      </tr>
                      
                      <tr>
                         <td>Start Date: </td>
                         <td><form:input path="startDate" type="date"/>&nbsp; &nbsp;&nbsp;</td>
                         <td>End Date: </td>
                         <td><form:input path="endDate" type="date"/></td>
                      </tr>
                     
                      <tr>
                           <td> <br>
                            <a href="./" class="btn btn-success">Reset</a>
                         </td>
                         <td> <br>
                            <input type="submit" value="search" class="btn btn-primary"/> &nbsp; &nbsp;&nbsp;
                         </td>
                      </tr>
                      
                 </table>
             </form:form>
             
             <hr>
                <table class="table table-striped table-hover">
                  <thead>
                     <tr>
                         <th>Id</th>
                         <th>Holder Name</th>
                         <th>Gender</th>
                         <th>Plan Name</th>
                         <th>Plan Status</th>
                         <th>Start Date</th>
                         <th>End Date</th>
                     </tr>
                  </thead>
                  <tbody>
                       <c:forEach items="${list}" var="data" varStatus="index">
                          <tr>
                             <td>${data.citizenId}</td>
                             <td>${data.citizenName}</td>
                             <td>${data.gender}</td>
                             <td>${data.planName}</td>
                             <td>${data.planStatus}</td>
                             <td>${data.planStartDate}</td>
                             <td>${data.planEndDate}</td>                            
                          </tr>
                          
                       </c:forEach>
                  </tbody>
                  <tfoot>
                        <tr>
                          <c:if test="${empty list}">
                             <td style="text-align:center" colspan="7">No Records Found</td>
                          </c:if>
                       </tr>             
                  </tfoot>
                </table>
             <hr>
             <b>Export: </b> <a href="">EXCEL</a> <a href="">PDF</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
   
</body>
</html> 