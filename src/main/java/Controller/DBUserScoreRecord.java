package Controller;

import Model.User;
import Model.UserScoreRecord;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by nsd on 17.07.17.
 */
public class DBUserScoreRecord {

    private static volatile DBUserScoreRecord instance;
    private Dao<UserScoreRecord,Long> dao = null;

    public static DBUserScoreRecord getInstance() {
        DBUserScoreRecord localInstance = instance;
        if (localInstance == null) {
            synchronized (DBUserScoreRecord.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBUserScoreRecord();
                }
            }
        }
        return localInstance;
    }

    private DBUserScoreRecord(){


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String[] str = { "user", "user", "user"};
            dao = DaoManager.createDao(new JdbcConnectionSource(str[0],str[1],str[2]), UserScoreRecord.class);

        } catch (Exception e) {
            e.printStackTrace();
        }


        if(dao!=null){
            try {
                if (!dao.isTableExists()) {
                    TableUtils.createTable(dao.getConnectionSource(),UserScoreRecord.class);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }




}
