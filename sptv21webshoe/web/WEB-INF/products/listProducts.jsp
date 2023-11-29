<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="album">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:forEach var="product" items="${products}">
                <div class="col">
                    <div class="card bg-light mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <h4 class="card-title">${product.title}</h4>
                            <p class="card-text" style="text-align: justify">${product.description}</p>
                            <p class="card-text">Ready: ${product.completed ? "Yes" : "No"}</p>
                            <c:if test="${topRole eq 'ADMINISTRATOR' || topRole eq 'MANAGER'}">
                                <a href="showEditProduct?id=${product.id}"><p class="text-info"><strong>Edit</strong></p></a>
                                <form method="post" action="PurchaseServlet">
                                    <input type="hidden" name="action" value="deleteProduct">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>   
            </c:forEach>
        </div>
    </div>
</div>
