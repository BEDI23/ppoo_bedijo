package josue.services.implementations;

import josue.entities.Sms;
import josue.utils.Connexion;
import josue.services.SmsService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(Sms sms) throws SQLException {
        // Implement logic to send the SMS using an SMS gateway provider (e.g., Twilio, Nexmo, ClickSend)
        // Replace with your actual SMS sending logic
        System.out.println("Sending SMS to client ID: " + sms.getIdClient() + ", Message: " + sms.getLibelle());
    }

    @Override
    public List<Sms> getAllSms() throws SQLException {
        List<Sms> smsList = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM Sms";
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
        String sql = "SELECT * FROM Sms WHERE statue = TRUE"; // Assuming 'statue' is the column indicating pending status
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
