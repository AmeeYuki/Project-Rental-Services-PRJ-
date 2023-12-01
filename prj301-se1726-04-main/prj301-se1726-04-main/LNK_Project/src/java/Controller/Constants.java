/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author f1nn
 */
public class Constants {
    //this key is provided by me (TRAN TIEN LOC). If you want to use this key, please create an account in  google console developer
    	public static String GOOGLE_CLIENT_ID = "771000613635-1lqg91lqfj1jti9cr76psdurou6q3i52.apps.googleusercontent.com";

	public static String GOOGLE_CLIENT_SECRET = "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";
    //if your Servlet's port is 8084 or something else please change the localhost:yourport 
        //public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/LNK_Project/LoginGoogleController";
        
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8084/LNK_Project/LoginGoogleController";

	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
