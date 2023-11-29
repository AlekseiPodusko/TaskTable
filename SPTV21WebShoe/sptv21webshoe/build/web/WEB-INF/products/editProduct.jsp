
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="w-100 d-flex justify-content-center">
    <form action="editProduct?id=${id}" method="POST" >
        <div class="card border-0 mb-3 px-3" style="width: 40em;">
            <h2 class="my-3 w-100 d-flex justify-content-center">Change Task</h2>
            <div class="form-group">
                <label class="form-label mt-2 mx-2">Title</label>
                <input type="text" class="form-control" name="name" value="${product.title}">
            </div>
            <div class="form-group">
                <label class="form-label mt-2 mx-2">Description</label>
                <textarea class="form-control" name="description" rows="3" value="">${product.description}</textarea>
            </div>
            <div class="form-group">
                <label class="form-label mt-2 mx-2">Task are done?</label>
                <select class="form-control" name="completed">
                    <option value="true" ${product.isCompleted() ? "selected" : ""}>Yes</option>
                    <option value="false" ${!product.isCompleted() ? "selected" : ""}>No</option>
                </select>
            </div>


            <input class="btn btn-primary mb-2" type="submit" value="Изменить товар">
          </div>
    </form>
</div>