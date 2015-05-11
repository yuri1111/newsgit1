package by.it;

/**
 * Created by NM Group on 10.05.2015.
 */
public class ServiceCheckAdmin {
    public boolean checkAdmin (String email, String pass){
        Authors log = new Authors();
        log.setEmail(email);
        log.setPass(pass);
        PageNewsDao adminEnter = PageNewsDao.GetMySingle();
        return (adminEnter.checkUser(log));
    }
}
