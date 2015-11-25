import service.*;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.*;

public class Test{
	public static void main(String[] args) {
		User user = new User();
		user.setName("Henry");
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.save(user);
	}
}

