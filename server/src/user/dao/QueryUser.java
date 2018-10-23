package user.dao;

public class QueryUser {
	
	
	public static final String getAllUsers 				= "select * from 5g.user";
	public static final String getAllUsersByDate		= "select * from 5g.user order by user_last_connection";
	public static final String getUsersByName			= "select * from 5g.user where user_name = ?";
	public static final String getUsersByMail			= "select * from 5g.user where user_mail = ?";
	public static final String getUsersAdmin			= "select * from 5g.user where user_is_admin = 1";
	public static final String getUsersActive			= "select * from 5g.user where user_is_active = 1";
	public static final String getUsersNotActive		= "select * from 5g.user where user_is_active = 0";
	public static final String getUsersOnline			= "select * from 5g.user where user_is_online = 1";
	
	
	
}
