package josue.services;

import josue.entities.Sms;

import java.sql.SQLException;
import java.util.List;

public interface SmsService {

    void sendSms(Sms sms) throws SQLException;

    List<Sms> getAllSms() throws SQLException;

    List<Sms> getPendingSms() throws SQLException;

}

