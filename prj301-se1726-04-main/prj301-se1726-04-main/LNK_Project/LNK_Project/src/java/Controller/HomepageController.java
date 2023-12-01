/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Information.infoDAO;
import Information.infoDTO;
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
 * @author f1nn
 */
public class HomepageController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        HttpSession ses = request.getSession();
        userDTO cur = null;
        infoDAO dao = new infoDAO();
        String action = request.getParameter("action");
        List<infoDTO> listInfomation = dao.getListPostisActive();
        if(ses != null){
            dao = new infoDAO();
            cur = (userDTO) ses.getAttribute("usersession");
            if(cur != null){
                if(action == null || action.equals("")){
                    request.setAttribute("listActive", listInfomation);
                    RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
                    rd.forward(request, response);
                } else if(action.equalsIgnoreCase("searchMain")){
                    String keyword = request.getParameter("searchMain");
                    List<infoDTO> list = dao.searchListPosBySearch(keyword);
                    request.setAttribute("listActive", list);
                    RequestDispatcher rd = request.getRequestDispatcher("HompageController");
                    rd.forward(request, response);
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            }
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        }
        }
        finally{
        infoDAO dao = new infoDAO();
        String action = request.getParameter("action");
        List<infoDTO> listInfomation = dao.getListPostisActive();
        request.setAttribute("listActive", listInfomation);
        RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
        rd.forward(request, response);
        
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
