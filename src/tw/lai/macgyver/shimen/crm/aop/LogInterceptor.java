package tw.lai.macgyver.shimen.crm.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Aspect
@Service
public class LogInterceptor {
	
	private static String DA = ".";
	
	private String indent = "";

	@Around(value = "execution(* tw.lai.macgyver.shimen.crm.module..*.*(..))")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		Logger mylog = Logger.getLogger(this.getClass().getName());
		
		String invokeMethod = pjp.getSignature().getDeclaringType()
				.getSimpleName() + DA + pjp.getSignature().getName();
		
		mylog.info(this.indent + "into " + invokeMethod + "....");
		this.indent += "    ";
		mylog.info(this.indent + "Argument List :");
		Object[] arguments = pjp.getArgs();
		for (Object argument : arguments)
			if (argument != null)
				mylog.info(this.indent + new Gson().toJson(argument));
		try {
			result = pjp.proceed();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			mylog.log(Level.WARNING, ex.getMessage(), ex);
			throw ex;
		} finally {
			if ((this.indent.length() - 4) < 0)
				this.indent = "";
			else
				this.indent = this.indent.substring(0, this.indent.length() - 4);
			mylog.info(this.indent + "end method..." + invokeMethod);
		}
		
		return result;
	}
}
