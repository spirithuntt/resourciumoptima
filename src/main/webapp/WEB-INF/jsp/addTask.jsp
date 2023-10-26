<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.resourciumoptima.domain.Employee" %>
<%@ page import="java.util.List" %>
<!-- MODAL -->
<div class="modal fade" id="modal-tasks-add" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/createTask" method="POST" id="form" >
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label" for="description">Description</label>
                        <input type="text" class="form-control" id="description" name="description" placeholder="Description" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="deadline">deadline</label>
                        <input type="date" class="form-control" id="deadline" name="deadline" placeholder="deadline" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="employee">Employee</label>
                        <select class="form-select" id="employee" name="assignedEmployeeId" required>
                            <option value="" selected disabled hidden>Choose here</option>
                            <%
                                List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                                for (Employee employee : employees) {


                            %>
                            <option value="<%= employee.getId() %>"><%= employee.getFirstName() %> <%= employee.getLastName() %></option>
                            <% } %>

                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="priority">Priority</label>
                        <select class="form-select" id="priority" name="priority" required>
                            <option value="" selected disabled hidden>Choose here</option>
                            <option value="LOW">Low</option>
                            <option value="MEDIUM">Medium</option>
                            <option value="HIGH">High</option>
                        </select>
                        </div>
                    <div class="mb-3">
                        <label class="form-label" for="status">Status</label>
                        <select class="form-select" id="status" name="status" required>
                            <option value="" selected disabled hidden>Choose here</option>
                            <option value="NEW">New</option>
                            <option value="IN_PROGRESS">In progress</option>
                            <option value="DONE">Done</option>
                        </select>
                </div>

                <div class="modal-footer">
                    <button type="button" data-bs-dismiss="modal" class="btn btn-secondary" >Cancel</button>
                    <button type="submit" name="save" class="btn btn-primary task-action-btn" id="save">Save</button>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>