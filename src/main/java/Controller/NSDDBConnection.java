package Controller;

/**
 * Created by nsd on 17.07.17.
 */
public class NSDDBConnection {

    public static String[] getDBConnection(){
        String DBURL = "mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/equalbackend";
        String Password = "NrL8cDQy23a7";
        String UserName = "adminmaJ9HZM";
        return  new String[]{ DBURL,UserName,Password };
    }

}
