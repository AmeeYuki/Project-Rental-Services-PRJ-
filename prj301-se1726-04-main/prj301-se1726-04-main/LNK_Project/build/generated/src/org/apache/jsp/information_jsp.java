package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class information_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/information.css\">\r\n");
      out.write("  <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- partial:index.partial.html -->\r\n");
      out.write("  <header class=\"header\">\r\n");
      out.write("    <a href=\"#\"><img src=\"image1.png\" class=\"logo\" alt=\"\"></a>\r\n");
      out.write("    <div>\r\n");
      out.write("      <ul class=\"navbar\">\r\n");
      out.write("        <li><a href=\"#home\">Home</a></li>\r\n");
      out.write("        <li><a href=\"#booking\">Booking</a></li>\r\n");
      out.write("        <li><a href=\"#contact\">Contact Us</a></li>\r\n");
      out.write("        <li><a href=\"#user\">Login</i></a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </header>\r\n");
      out.write("\r\n");
      out.write("  <div id=\"container\">\r\n");
      out.write("    <div class=\"title\">\r\n");
      out.write("      <h1>Information</h1>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"#\" method=\"post\" id=\"contact_form\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"title\"></label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Title\" name=\"title\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"locate\"></label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Locate\" name=\"title\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"type\"></label>\r\n");
      out.write("        <select placeholder=\"Type\" name=\"type\" required>\r\n");
      out.write("          <option disabled hidden selected>Type</option>\r\n");
      out.write("          <option>Hotel</option>\r\n");
      out.write("          <option>Homestay</option>\r\n");
      out.write("          <option>Tour</option>\r\n");
      out.write("        </select>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"typeroom\"></label>\r\n");
      out.write("        <select placeholder=\"Type of room\" name=\"typeroom\" required>\r\n");
      out.write("          <option disabled hidden selected>Type of room</option>\r\n");
      out.write("          <option>Single Bed & 1 Toilets</option>\r\n");
      out.write("          <option>Double Beds & 1 Toilets</option>\r\n");
      out.write("          <option>2 rooms & 2 Toilets</option>\r\n");
      out.write("          <option>3 rooms & 2 Toilets</option>\r\n");
      out.write("          <option>4 rooms & 3 Toilets</option>\r\n");
      out.write("          <option>KhÃ¡c</option>\r\n");
      out.write("        </select>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"peopleroom\"></label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Maximum people in room\" name=\"peopleroom\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"area\"></label>\r\n");
      out.write("        <input type=\"number\" placeholder=\"Area\" name=\"area\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"price\"></label>\r\n");
      out.write("        <input type=\"number\" placeholder=\"price\" name=\"price\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"imageInput\">Chá»n file áº£nh</label>\r\n");
      out.write("        <input  type=\"file\" id=\"imageInput\">\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"box\">\r\n");
      out.write("        <label for=\"decripsion\"></label>\r\n");
      out.write("        <textarea cols=\"30\" rows=\"5\" name=\"decripsion\" placeholder=\"decripsion\" required></textarea>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"submit\">\r\n");
      out.write("        <input type=\"submit\" value=\"save\" id=\"form_button\" />\r\n");
      out.write("      </div>\r\n");
      out.write("    </form><!-- // End form -->\r\n");
      out.write("  </div><!-- // End #container -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
