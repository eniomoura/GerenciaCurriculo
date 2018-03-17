import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/create")

public class CreateController extends HttpServlet{
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
			String nome=valor(req, "nome", "");
			String email=valor(req, "email", "");
			String telefone=valor(req, "telefone", "");
			String nascimento=valor(req, "nascimento", "");
			String endereco=valor(req, "endereco", "");
			String area=valor(req, "area", "");
			String idiomas=valor(req, "idiomas", "");
			String conhecimentos=valor(req, "conhecimentos", "");
			String formacao=valor(req, "formacao", "");
			String experiencia=valor(req, "experiencia", "");
			String remuneracao=valor(req, "remuneracao", "");
			
			if(op=="") {
            }else if(op.equals("adicionar")){
            	CurriculoDAO.inclui(nome, email, telefone, nascimento, endereco, area, idiomas, conhecimentos, formacao, experiencia, remuneracao);
                resp.sendRedirect("home");
			}else{
				throw new UnsupportedOperationException();
			}
			req.getRequestDispatcher("create.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}