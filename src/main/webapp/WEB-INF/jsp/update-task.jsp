<%@ page import="com.resourciumoptima.domain.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- MODAL -->
<div class="modal fade" id="modal-tasks-edit" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="${pageContext.request.contextPath}/TasksUpdateServlet" method="POST" id="form" >

        <input type="hidden" name="taskIdUpdate" id="taskIdUpdate" value="">

        <div class="modal-header">
          <h5 class="modal-title" id="modal-title">Update Task</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label class="form-label" >Assigned To</label>
            <select name="assignedToUpdate"  class="form-select" aria-label="Default select example">

              <%
                // Iterate through users
                List< Employee > usersUpdate = (List< Employee >) request.getAttribute("usersUpdate");

                for (Employee user : usersUpdate){
              %>
              <option value="<%= user.getId() %>"><%= user.getFirstName() %> <%= user.getLastName() %></option>
              <%
                }
              %>

            </select>
          </div>
          <div class="form-group mb-3">
            <label for="message-text" class="col-form-label">Description</label>
            <textarea class="form-control" id="message-text" name="descriptionUpdate"></textarea>
          </div>
            <div class="form-group mb-3">
                <label for="message-text" class="col-form-label">Status</label>
                <select name="statusUpdate"  class="form-select" aria-label="Default select example">
                    <option value="Pending">Pending</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Completed">Completed</option>
                </select>
            </div>
            <div class="form-group mb-3">
                <label for="message-text" class="col-form-label">Priority</label>
                <select name="priorityUpdate"  class="form-select" aria-label="Default select example">
                    <option value="Low">Low</option>
                    <option value="Medium">Medium</option>
                    <option value="High">High</option>
                </select>
            </div>


        </div>

        <div class="modal-footer">
          <button type="button" data-bs-dismiss="modal" class="btn btn-secondary" >Cancel</button>
          <button type="submit" name="save" class="btn btn-warning task-action-btn" id="save">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
