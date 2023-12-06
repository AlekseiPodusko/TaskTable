<c:forEach var="task" items="${tasks}">
    <div class="col">
        <div class="card bg-light mb-3" style="max-width: 20rem;">
            <div class="card-body">
                <c:if test="${not empty task.listUsers}">
                    <h4> ${task.listUsers[0].firstName}'s Task</h4> 
                </c:if>
                <h4 class="card-title">${task.title}</h4>
                <p class="card-text" style="text-align: justify">${task.description}</p>
                <p class="card-text" style="color: ${task.completed ? 'green' : 'red'}">Ready: ${task.completed ? 'Yes' : 'No'}</p>
                <c:if test="${topRole eq 'ADMINISTRATOR' || topRole eq 'MANAGER'}">
                    <a href="showEditTask?id=${task.id}"><p class="text-info"><strong>Edit</strong></p></a>
                </c:if>
                
            </div>
        </div>
    </div>
</c:forEach>
