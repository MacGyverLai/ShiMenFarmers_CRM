package tw.lai.macgyver.shimen.crm.module;

import java.util.List;

import tw.lai.macgyver.shimen.crm.entity.User;

public interface IUserDao {
	
	List<User> retrieveAllUser();
	
	User queryUserByEmail(String email);
}
