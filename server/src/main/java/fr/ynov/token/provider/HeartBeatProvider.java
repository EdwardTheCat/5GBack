package fr.ynov.token.provider;

import fr.ynov.db.DBConnection;
import fr.ynov.token.ressources.HeartBeat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HeartBeatProvider {

    private Connection conn;

    public HeartBeatProvider() {
        this.conn = DBConnection.getConnection();
    }

    public HeartBeat findHeartBeatByUserId(int UserId) throws Exception{

            String query = "SELECT * FROM User WHERE user_id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,UserId);
            ResultSet rs = ps.executeQuery();
            if(rs.first()) {
                return new HeartBeat(rs.getString("user_token"));
            }
            return null;
    }

    public void addHeartBeat(HeartBeat hb)throws Exception{
            String query = "INSERT INTO User WHERE user_token = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString	(1, hb.getToken());
            int res = ps.executeUpdate();
    }

    public void deleteHeartBeat(HeartBeat hb)throws Exception{

            String query = "DELETE FROM User WHERE user_token = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString	(1, hb.getToken());
            int res = ps.executeUpdate();
    }
}

