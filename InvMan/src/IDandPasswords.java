import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords(){
        loginInfo.put("jharby1028","6138385");
        loginInfo.put("jharby","pizza");
        loginInfo.put("jharbs","01276438");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
