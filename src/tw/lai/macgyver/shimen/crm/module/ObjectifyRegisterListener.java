package tw.lai.macgyver.shimen.crm.module;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tw.lai.macgyver.shimen.crm.entity.Customer;
import tw.lai.macgyver.shimen.crm.entity.Order;
import tw.lai.macgyver.shimen.crm.entity.OrderDetail;
import tw.lai.macgyver.shimen.crm.entity.Product;
import tw.lai.macgyver.shimen.crm.entity.User;

import com.googlecode.objectify.ObjectifyService;

public class ObjectifyRegisterListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Logger mylog = Logger.getLogger(this.getClass().getName());
		mylog.info("into Context initialized....");
		
		ObjectifyService.register(User.class);
		ObjectifyService.register(Customer.class);
		ObjectifyService.register(Order.class);
		ObjectifyService.register(OrderDetail.class);
		ObjectifyService.register(Product.class);
	}

}
