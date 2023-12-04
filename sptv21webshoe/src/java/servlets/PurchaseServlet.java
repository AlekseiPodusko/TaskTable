
package servlets;

import entity.Product;
import entity.User;
import session.ProductFacade;
import session.UserRolesFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerServlet", urlPatterns = {
    "/showAddProduct",
    "/addProduct",
    "/showEditProduct",
    "/editProduct",
})
public class PurchaseServlet extends HttpServlet {
    @EJB UserRolesFacade userRolesFacade;
    @EJB ProductFacade productFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "Log in!");
            request.getRequestDispatcher("/showLogin").forward(request, response);
        }
        User authUser = (User) session.getAttribute("authUser");
        if(authUser == null){
            request.setAttribute("info", "Log in!");
            request.getRequestDispatcher("/showLogin").forward(request, response);
        }
        if(!userRolesFacade.isRole("MANAGER", authUser)){
            request.setAttribute("info", "No rights");
            request.getRequestDispatcher("/showLogin").forward(request, response);
        }
        session.setAttribute("topRole", userRolesFacade.getTopRole(authUser));
        
        String path = request.getServletPath();
        switch(path) {
            case "/showAddProduct":
                request.getRequestDispatcher("/WEB-INF/products/addProduct.jsp").forward(request, response);
                break;
               
            case "/addProduct":
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String completed = request.getParameter("completed");

                if (name.isEmpty() || description.isEmpty() || completed == null) {
                    request.setAttribute("name", name);
                    request.setAttribute("description", description); // Исправленная строка
                    request.setAttribute("completed", completed);
                    request.setAttribute("info", "Fill all gaps!");
                    request.getRequestDispatcher("/showAddProduct").forward(request, response);
                    break;
                }

                Product product = new Product();
                product.setTitle(name);
                product.setDescription(description);
                boolean isCompleted = Boolean.parseBoolean(completed); // Преобразование строки в boolean
                product.setCompleted(isCompleted);

                productFacade.create(product);

                request.setAttribute("info", "Task has been added");
                request.getRequestDispatcher("/showAddProduct").forward(request, response);
                break;

                
            case "/showEditProduct":
                String productId = request.getParameter("id");
                product = productFacade.find(Long.parseLong(productId));
                request.setAttribute("id", productId);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/products/editProduct.jsp").forward(request, response);
                break;
                
            case "/editProduct":
                productId = request.getParameter("id");
                name = request.getParameter("name");
                description = request.getParameter("description");
                completed = request.getParameter("completed");

                if (name.isEmpty() || description.isEmpty() || completed == null) {
                    // Обработка ситуации, когда не все поля заполнены
                } else {
                    product = productFacade.find(Long.parseLong(productId));
                    product.setTitle(name);
                    product.setDescription(description);

                    boolean isCompletedValue = "true".equals(completed);
                    product.setCompleted(isCompletedValue);

                    productFacade.edit(product);
                    request.setAttribute("info", "Task has been updated");
                    request.getRequestDispatcher("/listProducts").forward(request, response);
                    break;
                }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
