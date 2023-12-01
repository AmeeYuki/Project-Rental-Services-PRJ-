package Controller;

import Information.infoDAO;
import Information.infoDTO;
import Lendlord.lendlordDAO;
import Lendlord.lendlordDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InformationController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equals("newPost")) {
            // Redirect to the create page
            request.getRequestDispatcher("Post.jsp").forward(request, response);

        } else if (action != null && action.equals("Create")) {
            // Get data from the form
            String lendID = request.getParameter("lendID");
            String infoTitle = request.getParameter("infoTitle");
            String infoAddress = request.getParameter("infoAddress");
            String infoType = request.getParameter("infoType");
            String infoTypeRoom = request.getParameter("infoTypeRoom");
            String infoImage = request.getParameter("infoImage");
            String infoDescription = request.getParameter("infoDescription");
            float infoPrice = Float.parseFloat(request.getParameter("infoPrice"));

            infoDTO info = new infoDTO();
            info.setLendID(lendID);
            info.setInfoTitle(infoTitle);
            info.setInfoAddress(infoAddress);
            info.setInfoType(infoType);
            info.setInfoTypeRoom(infoTypeRoom);
            info.setInforImage(infoImage);
            info.setInfoDescription(infoDescription);
            info.setInfoPrice(infoPrice);

            infoDAO infoDao = new infoDAO();
            infoDao.insertInformation(info);
            

// Cập nhật lại thông tin chủ nhà
            HttpSession session = request.getSession();
           lendlordDAO lendlordDAO = new lendlordDAO();

            lendlordDTO lend = lendlordDAO.showLend(lendID);
                        session.setAttribute("user", lend);

                List<infoDTO> infoList = lendlordDAO.listInfoLend(Integer.toString(lend.getLendID()));
                request.setAttribute("infoList", infoList);
                List<infoDTO> infoListWait = lendlordDAO.listInfoLendWait(Integer.toString(lend.getLendID()));
                request.setAttribute("infoListWait", infoListWait);
                request.getRequestDispatcher("Landlord.jsp").forward(request, response);
            
            // Sau khi thêm thông tin thành công, điều hướng người dùng đến trang lendlord
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
