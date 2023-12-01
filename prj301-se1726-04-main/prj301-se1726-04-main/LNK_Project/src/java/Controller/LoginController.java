/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Information.infoDTO;
import Lendlord.lendlordDAO;
import Lendlord.lendlordDTO;
import User.userDAO;
import User.userDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginController extends HttpServlet {

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
        String userType = request.getParameter("userType");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        userDTO user = null;
        lendlordDTO lendlord = null;

        if (userType != null && userType.equals("user")) {
            userDAO userDAO = new userDAO();
            user = userDAO.loginUser(username, password);
            session.setAttribute("usersession", user);
            
            if (user != null) {
                // Đăng nhập thành công, chuyển hướng tới trang profile của user
                int userRole = user.getUserRole();
                if (userRole == 1) {
                    // Đăng nhập thành công với user role là 1, chuyển hướng tới trang user
                    request.getRequestDispatcher("ProfileController").forward(request, response);
                } else if (userRole == 2) {
                   // Đăng nhập thành công với user role khác 1, chuyển hướng tới trang admin
                    response.sendRedirect(request.getContextPath() + "/AdminController");
                }
             }else{
                    request.setAttribute("mess", "Wrong username or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);

                }
        }else if (userType != null && userType.equals("lendlord")) {
                lendlordDAO lendlordDAO = new lendlordDAO();
                lendlord = lendlordDAO.loginLend(username, password);
                session.setAttribute("user", lendlord);
    
                if (lendlord != null) {
                    // Đăng nhập thành công, lấy danh sách thông tin của lendlord
                    List<infoDTO> infoList = lendlordDAO.listInfoLend(Integer.toString(lendlord.getLendID()));
                    request.setAttribute("infoList", infoList);
                    List<infoDTO> infoListWait = lendlordDAO.listInfoLendWait(Integer.toString(lendlord.getLendID()));
                    request.setAttribute("infoListWait", infoListWait);
                    request.getRequestDispatcher("Landlord.jsp").forward(request, response);
                } else {
                    // Đăng nhập thất bại, chuyển hướng về trang đăng nhập và hiển thị thông báo lỗi
                    request.setAttribute("mess", "Wrong username or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
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
