
import Contract.contractDTO;
import Information.infoDTO;
import Lendlord.lendlordDAO;
import User.userDAO;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1nn
 */
public class Test {
    public static void main(String[] args) {
        lendlordDAO dao = new lendlordDAO();
        List<infoDTO> infoLendList = dao.listInfoLendWait("6");
            System.out.println(infoLendList);
    }
}
