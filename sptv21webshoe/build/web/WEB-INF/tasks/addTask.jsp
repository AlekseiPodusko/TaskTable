
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="w-100 d-flex justify-content-center">
    <form action="addTask" method="POST" >
        <div class="card border-0 mb-3 px-3" style="width: 40em;">
            <h2 class="my-3 w-100 d-flex justify-content-center">Add Task</h2>
            <div class="form-group">
                <label class="form-label mt-2 mx-2">Title</label>
                <input type="text" class="form-control" name="name" value="${name}">
            </div>
            <div class="form-group">
                <label class="form-label mt-2 mx-2">Description</label>
                <textarea class="form-control" name="description" rows="3" value="${description}"></textarea>
            </div>
            <div class="form-group">
                    <label class="form-label mt-1">Choose User</label>
                    <select class="form-select" name="selectUser">
                        <c:forEach var="item" items="${mapUsers}">
                            <option value="${item.key.id}">${item.key.firstName} ${item.value}</option>
                        </c:forEach>
                    </select>
            </div>
            <div class="form-group">
            <label class="form-label mt-1">Task are done?</label>
            <select class="form-control" name="completed" style="width: 100%; padding: 0.375rem 0.25rem; font-size: 1rem; line-height: 1.5; color: #fffff; background-color: transparent; background-clip: padding-box; border: 1px solid #ced4da; border-radius: 0.50rem; transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;">
                <option value="true" ${completed != null && completed.equals("true") ? "selected" : ""} style="background-color: transparent; color: #000000;">Yes</option>
                <option value="false" ${completed != null && completed.equals("false") ? "selected" : ""} style="background-color: transparent; color: #000000;">No</option>
            </select>
        </div>
           
            <br>
            <input class="btn btn-primary mb-2" type="submit" value="Add Task">
          </div>
    </form>
</div>