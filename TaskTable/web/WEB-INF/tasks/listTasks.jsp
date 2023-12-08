<div class="container">
    <div class="row">
        <c:forEach var="task" items="${tasks}">
            <div class="col">
                <div class="card bg-light mb-3" style="max-width: 20rem;">
                    <div class="card-body">
                        <h4>${task.listUsers[0].firstName}'s Task</h4> 
                        <h4 class="card-title">${task.title}</h4>
                        <p class="card-text" style="text-align: justify">${task.description}</p>
                        <p class="card-text" style="color: ${task.completed ? 'green' : 'red'}">Ready: ${task.completed ? 'Yes' : 'No'}</p>
                        
                        <c:if test="${(topRole eq 'ADMINISTRATOR') || (authUser ne null && authUser.id eq task.listUsers[0].id)}">
                            <a href="showEditTask?id=${task.id}">
                                <p class="text-info"><strong>Edit</strong></p>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
