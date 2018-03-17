import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")

public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L; //servlet serial
	
	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg="";
			String op=valor(req, "op", "");
			HttpSession session = req.getSession();
			if(op=="") {
				
			}else if (op.equals("login")){
				resp.sendRedirect("login");
			}else if(op.equals("voltar")) {
				resp.sendRedirect("login");
			}else if(op.equals("criar")){
				resp.sendRedirect("create");
			}else if(op.equals("editar")) {
				resp.sendRedirect("update");		
			}else{
				throw new UnsupportedOperationException();
			}
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}