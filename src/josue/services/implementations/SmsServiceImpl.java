package josue.services.implementations;

import josue.entities.Client;
import josue.entities.Sms;
import josue.utils.Connexion;
import josue.services.SmsService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(Sms sms)  throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO sms (idClient, libelle, statue) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, sms.getIdClient());
        statement.setString(2, sms.getLibelle());
        statement.setBoolean(3, sms.isStatue());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public List<Sms> getAllSms() throws SQLException {
        List<Sms> smsList = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM sms";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Sms sms = new Sms(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getString("libelle"),
                    resultSet.getBoolean("statue")
            );
            smsList.add(sms);
        }
        connection.close();
        return smsList;
    }

    @Override
    public List<Sms> getPendingSms() throws SQLException {
        List<Sms> pendingSmsList = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM sms WHERE statue = TRUE"; // Assuming 'statue' is the column indicating pending status
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Sms sms = new Sms(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getString("libelle"),
                    resultSet.getBoolean("statue")
            );
            pendingSmsList.add(sms);
        }
        connection.close();
        return pendingSmsList;
    }
}
