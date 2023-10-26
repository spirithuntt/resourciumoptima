<%--<%@ page import="com.resourciumoptima.domain.Task" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.resourciumoptima.domain.Employee" %>--%>
<%--<!-- MODAL -->--%>
<%--<div class="modal fade" id="modal-tasks-edit" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--  <div class="modal-dialog">--%>
<%--    <div class="modal-content">--%>
<%--      <form action="createTask" method="POST" id="form" enctype="multipart/form-data" data-parsley-validate>--%>
<%--        <div class="modal-header">--%>
<%--          <h5 class="modal-title" id="modal-title">Edit Task</h5>--%>
<%--          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--        </div>--%>
<%--        <div class="modal-body">--%>
<%--          <div class="mb-3">--%>
<%--            <input type="hidden" name="id" value="<%= Task.getId() %>">--%>
<%--            <label class="form-label">Assigned To</label>--%>
<%--            <select name="assignedEmployee" class="form-select" aria-label="Default select example">--%>
<%--              <option selected disabled>Open this select menu</option>--%>
<%--              <%--%>
<%--                List<Employee> employees = (List<Employee>) request.getAttribute("employees");--%>
<%--                for (Employee employee : employees) {--%>
<%--              %>--%>
<%--              <option value="<%= employee.getId() %>"><%= employee.getFirstName() + " " + employee.getLastName() %></option>--%>
<%--              <%--%>
<%--                }--%>
<%--              %>--%>
<%--            </select>--%>
<%--          </div>--%>
<%--          <div class="form-group mb-3">--%>
<%--            <label for="message-text" class="col-form-label">Description</label>--%>
<%--            <textarea class="form-control" id="message-text" name="description"></textarea>--%>
<%--          </div>--%>
<%--          <div class="mb-3">--%>
<%--            <label class="form-label">Start Date</label>--%>
<%--            <input type="date" class="form-control" name="deadline">--%>
<%--          </div>--%>
<%--          <div class="mb-3">--%>
<%--            <label class="form-label">End Date</label>--%>
<%--            <input type="date" class="form-control" name="status">--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="modal-footer">--%>
<%--          <button type="button" data-bs-dismiss="modal" class="btn btn-secondary">Cancel</button>--%>
<%--          <button type="submit" name="action" value="update" class="btn btn-primary task-action-btn" id="save">Save</button>--%>
<%--        </div>--%>
<%--      </form>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>
