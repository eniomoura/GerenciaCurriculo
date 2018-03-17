import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cadastro")

public class CadastroController extends HttpServlet{
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
			String op=valor(req, "op", "");
            if(op=="") {
            }else if(op.equals("cadastrar")){
                resp.sendRedirect("login");
            }else if(op.equals("voltar")) {
            	resp.sendRedirect("login");
			}else{
				throw new UnsupportedOperationException();
			}
			req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}