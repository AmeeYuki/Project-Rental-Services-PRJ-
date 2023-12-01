/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Contract.contractDAO;
import Contract.contractDTO;
import Invoice.invoiceDAO;
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
                userDAO dao = new userDAO();
                cur = (userDTO) ses.getAttribute("usersession");
                String userID = String.valueOf(cur.getUserID());
                if (cur != null) { // check nguoi dung dang login de lay dia chi user id
                    List<contractDTO> getUpCommingContract = dao.getUpcomingContractDTO(userID);
                    List<contractDTO> getHistoryContract = dao.getHistoryContractDTO(userID);
                    request.setAttribute("listComming", getUpCommingContract);
                    request.setAttribute("listHistory", getHistoryContract);
                    if (action == null || action.equals("") || action.equals("return")) {
                        RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");
                        rd.forward(request, response);
                    } else if (action.equals("edit")) {
                        String fullname = request.getParameter("fullname");
                        String phone = request.getParameter("phone");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        dao.editUserInfo(cur.getUserUsername(), fullname, phone, email, password);
                        RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");
                        rd.forward(request, response);
                    } else if (action.equals("searchUp")) {
                        String keyword = request.getParameter("searchUp");
                        String id = String.valueOf(cur.getUserID());
                        List<contractDTO> searchByNameUp = dao.searchByNameUp(id, keyword);
                        request.setAttribute("listComming", searchByNameUp);
                        RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");
                        rd.forward(request, response);
                    } else if (action.equals("home")) {
                        RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");
                        rd.forward(request, response);
                    } else if (action.equalsIgnoreCase("view")) {
                        String ID = request.getParameter("contractID");
                        int contractID = Integer.parseInt(ID);
                        invoiceDAO invDAO = new invoiceDAO();
                        request.setAttribute("invoice", invDAO.invoiceByUser(contractID));
                        RequestDispatcher rd = request.getRequestDispatcher("invoice.jsp");
                        rd.forward(request, response);
                    } else if (action.equalsIgnoreCase("cancel")) {
                        String ID = request.getParameter("contractID");
                        ID = ID.replaceAll("\\s", "");
                        int contractID = Integer.parseInt(ID);
                        contractDAO conDao = new contractDAO();
                        conDao.cancelContractByUser(contractID);
                        request.setAttribute("listComming", getUpCommingContract);
                        request.setAttribute("listHistory", getHistoryContract);
                        RequestDispatcher rd = request.getRequestDispatcher("profileUser.jsp");

                        rd.forward(request, response);

                    }

                }
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
