//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlet;
//
//import entity.User;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import session.UserFacade;
//import session.UserFacade;
//import tools.PasswordEncrypt;
//
///**
// *
// * @author user
// */
//@WebServlet(name = "CustomerServlet", urlPatterns = {
//    "/listCustomers",
//
//    
//
//})
//public class UserServlet extends HttpServlet {
//
//    @EJB private UserFacade userFacade;
//    
//    static enum Role {USER,MANAGER,ADMINISTRATOR};
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession(false);
//        if(session == null){
//            request.setAttribute("info", "У вас нет прав, авторизуйтесь!");
//            request.getRequestDispatcher("/showLogin").forward(request, response);
//            return;
//        }
//        User authUser = (User) session.getAttribute("user");
//        if(authUser == null || !authUser.getRoles().contains(UserServlet.Role.MANAGER.toString())){
//            request.setAttribute("info", "У вас нет прав, авторизуйтесь!");
//            request.getRequestDispatcher("/showLogin").forward(request, response);
//            return;
//        }
//        
//        String path = request.getServletPath();
//        switch (path) {
//            
//            case "/listUsers":
//                Map<User, List<User>> mapUsers = new HashMap();
//                List<User> listUsers = userFacade.findAll();
//                for (int i = 0; i < listUsers.size(); i++) {
//                    User r = listUsers.get(i);
//                    mapUsers.put(r, historyFacade.getReadingProduct(r)); 
//                }
//                request.setAttribute("mapCustomers", mapUsers);
//                request.getRequestDispatcher("/WEB-INF/user/listUsers.jsp").forward(request, response);
//                break;
//                
//        }
//            }
//      
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}