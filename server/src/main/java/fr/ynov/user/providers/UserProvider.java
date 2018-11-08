package fr.ynov.user.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.user.ressources.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserProvider {

    private Connection conn;

    public UserProvider() throws SQLException, ClassNotFoundException {
        this.conn = DBConnection.getConnection();
    }

    public void createUser (User user) throws SQLException {
        String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
        String formattedString1 = currentTime.format(formatter1);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
        String formattedString2 = currentTime.format(formatter2);


        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getFirstname());
        ps.setString(4, user.getMail());
        ps.setString(5, user.getLogin());
        ps.setString(6, user.getPassword());
        ps.setBoolean(7, user.isActive());
        ps.setBoolean(8, user.isAdmin());
        ps.setString(9, formattedString1);
        ps.setString(10, formattedString2);
        ps.setString(11, user.getStatus());
        ps.setString(12, user.getToken());

        ps.executeUpdate();

        System.out.println(user);

        ps.close();
    }
}
