package user.dao;

public class QueryUser {
	
	
	public static final String getAllUsers 			= "select * from 5g.user";
	public static final String getUsersByName		= "select user_name, user_first_name, user_mail from 5g.user where user_name = ?";
	public static final String getUsersByMail		= "select user_name, user_first_name, user_mail from 5g.user where user_mail = ?";
}
