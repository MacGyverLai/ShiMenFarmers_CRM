package tw.lai.macgyver.shimen.crm.module.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.ObjectifyService;

import tw.lai.macgyver.shimen.crm.entity.User;
import tw.lai.macgyver.shimen.crm.module.IUserDao;

@Repository("userService")
public class UserObjDao implements IUserDao {

	public UserObjDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		List<User> result = null;
		
		result = ObjectifyService.ofy().load().type(User.class).list();
		
		return result;
	}

	@Override
	public User queryUserByEmail(String email) {
		// TODO Auto-generated method stub
		return ObjectifyService.ofy().load().type(User.class).filter("email", email).
				first().now();
	}

}
