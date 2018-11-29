package fr.ynov.token.provider;

import fr.ynov.db.DBConnection;
import fr.ynov.token.ressources.HeartBeat;

import java.sql.PreparedStatement;

public class HeartBeatProvider {



    public HeartBeat findHeartBeatByUserId(int UserId){

        try {

            String query = "SELECT * FROM User WHERE User.id = ? ";

            if(conn==null){
                this.conn = DBConnection.getConnection();}

            if(conn==null){
                System.out.println("connexion null");
            PreparedStatement ps = conn.prepareStatement(query);
    }


}

    public void updateHeartBeat(HeartBeat hb){

        if(40 secondes){
            HeartBeat hb = new HeartBeat();
        }

    }

    public void addHeartBeat(HeartBeat hb){

        HeartBeat hb = new HeartBeat();

        if(conn == null) DBConnection.getConnection();

        try {
            String query = "ADD FROM token WHERE token";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString	(1, token.getContent());
            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL error : Ajoute heartbeat");
            e.printStackTrace();

        } finally  {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { e.printStackTrace();}
            }
        }
        return res;
    }
}

    public void deleteHeartBeat(HeartBeat hb){

        int res = 0;

        if(conn == null) DBConnection.getConnection();

        try {
            String query = "DELETE FROM token WHERE token";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString	(1, token.getContent());
            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL error : Delete heartbeat");
            e.printStackTrace();

        } finally  {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { e.printStackTrace();}
            }
        }
        return res;
    }

    }

}

