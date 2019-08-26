package hu.naszi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class UserDao {
	
	public List<User> getAllUsers() {
		
		List<User> userList = null;
		try {
			File file = new File("Users.dat");
			if (!file.exists()) {
				User user = new User(1, "Naszi", "Lotolvaj");
				userList.add(user);
				saveUserList(userList);
			} else {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				userList = (List<User>) objectInputStream.readObject();
				objectInputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}

	private void saveUserList(List<User> userList) {
		// TODO Auto-generated method stub
		
	}

}
