package josue.services;

import josue.entities.Sms;
import java.util.List;

public interface SmsService {

    void sendSms(Sms sms);
    List<Sms> getAllSms();
    List<Sms> getPendingSms();
}

