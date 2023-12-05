<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="album">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:forEach var="task" items="${tasks}">
                <div class="col">
                    <div class="card bg-light mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <h4 class="card-title">${task.title}</h4>
                            <p class="card-text" style="text-align: justify">${task.description}</p>
                            <p  class="card-text" style="color: ${task.completed ? 'green' : 'red'}">Ready: ${task.completed ? 'Yes' : 'No'}</p>
                            <c:if test="${topRole eq 'ADMINISTRATOR' || topRole eq 'MANAGER'}">
                                <a href="showEditTask?id=${task.id}"><p class="text-info"><strong>Edit</strong></p></a>
                            </c:if>
                        </div>
                    </div>
                </div>   
            </c:forEach>
        </div>
    </div>
</div>
