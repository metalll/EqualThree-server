package Controller;

import Model.User;
import Model.UserReplay;
import Model.UserScoreRecord;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by nsd on 17.07.17.
 */
public class DBUserReplay {

    private static volatile DBUserReplay instance;
    private Dao<UserReplay,Long> dao = null;

    public static DBUserReplay getInstance() {
        DBUserReplay localInstance = instance;
        if (localInstance == null) {
            synchronized (DBUserReplay.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBUserReplay();
                }
            }
        }
        return localInstance;
    }

    private DBUserReplay(){


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String[] str = NSDDBConnection.getDBConnection();
            dao = DaoManager.createDao(new JdbcConnectionSource(str[0],str[1],str[2]), UserReplay.class);

           } catch (Exception e) {
            e.printStackTrace();
        }


        if(dao!=null){
            try {
                if (!dao.isTableExists()) {
                    TableUtils.createTable(dao.getConnectionSource(),UserReplay.class);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }



}
