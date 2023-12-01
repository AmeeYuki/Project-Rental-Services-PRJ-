/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Lendlord.lendlordDAO;
import Lendlord.lendlordDTO;
import User.userDAO;
import User.userDTO;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author f1nn
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private userDAO userdao;
    private lendlordDAO landlord;

    public void init() {
        userdao = new userDAO();
        landlord = new lendlordDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {}

//            request.setAttribute("error", "All fields must be filled out!");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
//            dispatcher.forward(request, response);
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("fir");
        String regex = "^\\d{10}$";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phone);

        int role = Integer.parseInt(request.getParameter("role"));
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "[!] All fields must be filled out!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
        }
        if (phone.length() > 10 && phone.length() < 0 || !mat.matches()) {
            request.setAttribute("error", "[!] Phone Number is not valided. The phone must from 10 numbers and only include number!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
        }
        if (!password.equals(confirm)) {
            request.setAttribute("error", "[!] Passwords are not the same! Enter again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
        }
        switch (role) {
            case 1:
                userDTO user = new userDTO();
                user.setUserUsername(username);
                user.setUserPassword(password);
                user.setUserEmail(email);
                user.setUserRole(role);
                user.setUserPhoneNumber(phone);
                try {
                    userdao.registerUser(user);
                    response.sendRedirect("login.jsp");
                } catch (IOException e) {
                }
                break;
            case 2:
                lendlordDTO land = new lendlordDTO();
                land.setLendUsername(username);
                land.setLendPassword(password);
                land.setLendEmail(email);
                land.setLendPhoneNumber(phone);
                try {
                    landlord.registerLandlord(land);
                    response.sendRedirect("login.jsp");
                } catch (IOException e) {

                }
                break;
            default:
                request.setAttribute("error", "Register not successfully!");
                response.sendRedirect("login.jsp");
                break;
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
