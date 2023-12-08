
package servlets;

import entity.Task;
import entity.User;
import session.TaskFacade;
import session.UserFacade;
import session.UserRolesFacade;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.PasswordProtector;

@WebServlet(name = "CustomerServlet", urlPatterns = {
    "/showEditUser",
    "/editUser",
})
public class CustomerServlet extends HttpServlet {
    @EJB private UserRolesFacade userRolesFacade;
    @EJB private UserFacade userFacade;
    @EJB private TaskFacade taskFacade;
    static enum Role {MANAGER};

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
        if(!userRolesFacade.isRole("CUSTOMER", authUser)){
            request.setAttribute("info", "No Rights!");
            request.getRequestDispatcher("/showLogin").forward(request, response);
        }
        session.setAttribute("topRole", userRolesFacade.getTopRole(authUser));
        
        String path = request.getServletPath();
        switch(path) {
            
            case "/showEditUser":
                request.setAttribute("firstName", authUser.getFirstName());
                request.setAttribute("sureName", authUser.getSureName());
                request.setAttribute("phone", authUser.getPhone());
                request.setAttribute("login", authUser.getLogin());
                request.getRequestDispatcher("/WEB-INF/customers/showEditUser.jsp").forward(request, response);
                break;
                
            case "/editUser":
                boolean changePassword = false;
                String firstName = request.getParameter("firstName");
                String sureName= request.getParameter("sureName");
                String phone = request.getParameter("phone");
                String login = request.getParameter("login");
                String oldPassword = request.getParameter("oldPassword");
                String newPassword1 = request.getParameter("newPassword1");
                String newPassword2 = request.getParameter("newPassword2");
                
                if (firstName.isEmpty() || sureName.isEmpty() || phone.isEmpty() || login.isEmpty()) {
                    request.setAttribute("firstName", firstName);
                    request.setAttribute("sureName", sureName);
                    request.setAttribute("phone", phone);
                    request.setAttribute("login", login);
                    request.setAttribute("info", "Fill all the gap!");
                    request.getRequestDispatcher("/WEB-INF/customers/showEditUser.jsp").forward(request, response);
                }
                PasswordProtector passwordProtector = new PasswordProtector();
                if (!oldPassword.isEmpty()) {
                    String password = passwordProtector.getProtectedPassword(oldPassword, authUser.getSalt());
                    if (!password.equals(authUser.getPassword())) {
                        request.setAttribute("info", "Incorrect password");
                        request.getRequestDispatcher("/showEditUser").forward(request, response);
                        break;
                    }
                    if ("".equals(newPassword1) || "".equals(newPassword2)) {
                        request.setAttribute("info", "Fill all gap");
                        request.getRequestDispatcher("/showEditUser").forward(request, response);
                        break;
                    }
                    if (!newPassword1.equals(newPassword2)) {
                        request.setAttribute("info", "New passwords don't match");
                        request.getRequestDispatcher("/showEditUser").forward(request, response);
                        break;
                    }
                    if (newPassword1.equals(oldPassword)) {
                        request.setAttribute("info", "The new password cannot be the same as the old one");
                        request.getRequestDispatcher("/showEditUser").forward(request, response);
                        break;
                    }
                    changePassword = true;
                    authUser.setPassword(passwordProtector.getProtectedPassword(newPassword1, authUser.getSalt()));
                }
                
                authUser.setFirstName(firstName);
                authUser.setSureName(sureName);
                authUser.setPhone(phone);
                authUser.setLogin(login);
                userFacade.edit(authUser);
                if (changePassword) {
                    session.setAttribute("changePassword", "true");
                    request.getRequestDispatcher("/logout").forward(request, response);
                    break;
                }
                request.setAttribute("changePassword", "false");
                request.setAttribute("info", "Data updated");
                request.getRequestDispatcher("/showEditUser").forward(request, response);
                break;
                
          
        }
    }
    
    private Date localdateToDate(LocalDate dateToConvert){
        return Date.from(dateToConvert.atStartOfDay(ZoneId.systemDefault()).toInstant());
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
