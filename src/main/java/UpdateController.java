import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")

public class UpdateController extends HttpServlet{
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
			Curriculo curriculo=CurriculoDAO.consultarNome("ENIO ROCHA MOURA");
			String op=valor(req, "op", "");
			req.setAttribute("nome", curriculo.nome);
			req.setAttribute("email", curriculo.email);
			req.setAttribute("telefone", curriculo.telefone);
			req.setAttribute("nascimento", curriculo.nascimento);
			req.setAttribute("endereco", curriculo.endereco);
			req.setAttribute("area", curriculo.area);
			req.setAttribute("idiomas", curriculo.idiomas);
			req.setAttribute("conhecimentos", curriculo.conhecimentos);
			req.setAttribute("formacao", curriculo.formacao);
			req.setAttribute("experiencia", curriculo.experiencia);
			req.setAttribute("remuneracao", curriculo.remuneracao);

			if(op=="") {
            	
            }else if(op.equals("entrar")){
                resp.sendRedirect("home");
			}else{
				throw new UnsupportedOperationException();
			}
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}