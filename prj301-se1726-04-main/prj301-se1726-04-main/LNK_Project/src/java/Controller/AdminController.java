/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Contract.contractDAO;
import Contract.contractDTO;
import Coupon.couponDAO;
import Coupon.couponDTO;
import Information.infoDAO;
import Information.infoDTO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zane
 */
public class AdminController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        HttpSession ses = request.getSession();
        String action = request.getParameter("action");
        if (ses != null) {
            if (action == null || action.equals("")) {
                couponDAO dao = new couponDAO();
                contractDAO dao2 = new contractDAO();
                infoDAO dao3 = new infoDAO();
                List<couponDTO> couponList = dao.List();
                List<contractDTO> contractList = dao2.list();
                List<infoDTO> infoList = dao3.list();
                request.setAttribute("couponList", couponList);
                request.setAttribute("contractList", contractList);
                request.setAttribute("infoList", infoList);
            } else if (action.equals("searchcoupon")) {
                String id = request.getParameter("search");
                couponDAO dao = new couponDAO();
                List<couponDTO> list = dao.getCouponByID(Integer.parseInt(id));
                request.setAttribute("couponList", list);
                request.setAttribute("couponList", list);
                request.setAttribute("couponDetail", list.get(0));
            } else if (action.equals("searchcontract")) {
                String id = request.getParameter("search");
                contractDAO dao = new contractDAO();
                List<contractDTO> list = dao.getContractByID(Integer.parseInt(id));
                request.setAttribute("contractList", list);
                request.setAttribute("contractList", list);
                request.setAttribute("contractDetail", list.get(0));
            } else if (action.equals("searchinfo")) {
                String id = request.getParameter("search");
                infoDAO dao = new infoDAO();
                List<infoDTO> list = dao.getInfoByID(Integer.parseInt(id));
                request.setAttribute("infoList", list);
                request.setAttribute("infoList", list);
                request.setAttribute("infoDetail", list.get(0));
            } else if (action.equals("delete")) {
                String id = request.getParameter("id");
                infoDAO dao = new infoDAO();
                contractDAO dao2 = new contractDAO();
                couponDAO dao3 = new couponDAO();
                dao.delete(Integer.parseInt(id));
                dao2.delete(Integer.parseInt(id));
                dao3.delete(Integer.parseInt(id));
            } else if (action.equals("delete2")) {
                String id = request.getParameter("id");
                infoDAO dao = new infoDAO();
                dao.approve(Integer.parseInt(id));
                contractDAO dao2 = new contractDAO();
                couponDAO dao3 = new couponDAO();
                dao2.approve(Integer.parseInt(id));
                dao3.approve(Integer.parseInt(id));
            } else if (action.equals("addCoupon")) {
                String couponName = request.getParameter("uname");
                String couponDetails = request.getParameter("detail");
                Float couponDiscount = Float.parseFloat(request.getParameter("discount"));
                String couponFor = request.getParameter("apply");
                String startDate = request.getParameter("startdate");
                String expiredDate = request.getParameter("expireddate");
                String couponStatus = request.getParameter("status");

                couponDTO dto = new couponDTO();
                dto.setCouponName(couponName);
                dto.setCouponDetails(couponDetails);
                dto.setCouponDiscount(couponDiscount);
                dto.setCouponFor(couponFor);
                dto.setStartDate(startDate);
                dto.setExpiredDate(expiredDate);
                dto.setStatusCoupon(couponStatus);

                couponDAO dao = new couponDAO();
                dao.createCoupon(dto);
            } else if (action.equals("home")) {
                RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
                rd.forward(request, response);
                return;
            } else if (action.equals("login")) {
                // If the "Login" link is clicked, redirect to login.jsp
                response.sendRedirect("login.jsp");
                return;
            }
            RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
