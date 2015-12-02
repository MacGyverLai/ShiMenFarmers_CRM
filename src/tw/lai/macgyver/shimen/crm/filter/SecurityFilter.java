package tw.lai.macgyver.shimen.crm.filter;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import tw.lai.macgyver.shimen.crm.entity.User;

import com.google.gson.Gson;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		Logger gLog = Logger.getLogger(this.getClass().getName()); 
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		gLog.info("Request parameter = " + new Gson().toJson(parameterMap));
		
		User loginUser = (User) ((HttpServletRequest) req)
				.getSession().getAttribute("loginUser");
		
		String servletPath = ((HttpServletRequest) req).getServletPath();
		gLog.info("ServletPath = " + servletPath);
		
		if (loginUser == null && !"/aouth2callback.do".equals(servletPath)) {
			gLog.info("Forward to login page....");
			req.getRequestDispatcher("login.do").forward(req, res);
		}
		
		filterChain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
