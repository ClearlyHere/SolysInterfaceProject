package Model.conf;

public class Conf {
    private static final String url = "jdbc:mysql://localhost:3306/tp2_jdbc";
    private static final String username = "root";
    private static final String password = "";

    public static String getUrl(){
        return url;
    }
    public static String getUsername(){
        return username;
    }
    public static String getPassword(){
        return password;
    }

}

