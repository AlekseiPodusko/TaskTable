
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="w-100 d-flex justify-content-center">
    <form action="addProduct" method="POST" >
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
                <label class="form-label mt-2 mx-2">Task are done?</label>
                <select class="form-control" name="completed">
                    <option value="true" ${completed != null && completed.equals("true") ? "selected" : ""}>Yes</option>
                    <option value="false" ${completed != null && completed.equals("false") ? "selected" : ""}>No</option>
                </select>
            </div>

            <input class="btn btn-primary mb-2" type="submit" value="Добавить товар">
          </div>
    </form>
</div>