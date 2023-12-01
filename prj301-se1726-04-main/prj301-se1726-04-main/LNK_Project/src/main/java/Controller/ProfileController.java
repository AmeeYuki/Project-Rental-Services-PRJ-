/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Contract.contractDTO;
import User.userDAO;
import User.userDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lehai
 */
public class ProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            // Check security kiem tra xem nguoi dung dang nhap chua?
            HttpSession ses = request.getSession();
            userDTO cur = null;
            if (ses != null) { // check session
                cur = (userDTO) ses.getAttribute("usersession");
                if (cur != null) { // check nguoi dung dang login de lay dia chi user id
                    userDAO dao = new userDAO();
                    String userID = String.valueOf(cur.getUserID());
                    List<contractDTO> getUpCommingContract = dao.searchUpcomming(userID);
                    List<contractDTO> getHistoryContract = dao.getHistoryContractDTO(userID);
                    request.setAttribute("listComming", getUpCommingContract);
                    request.setAttribute("listHistory", getHistoryContract);
                    RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");
                    rd.forward(request, response);
                    
                    
                    if(action.equals("searchUp")){
                    List<contractDTO> searchUp = dao.searchUpcomming(userID); //upcomming search and history search
                    request.setAttribute("listComming", searchUp);
                    rd = request.getRequestDispatcher("profileUser.jsp");
                    rd.forward(request, response);
                    }

                }
            }
            if (cur == null) { // ko thay quay ve login
                response.sendRedirect(request.getContentType() + "/login");
                return;
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
