package Controller;

import Interfaces.ICompletion;
import Model.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

/**
 * Created by nsd on 17.07.17.
 */
public class DBUser {

    private static volatile DBUser instance;
    private Dao<User,Long> dao = null;

    public static DBUser getInstance() {
        DBUser localInstance = instance;
        if (localInstance == null) {
            synchronized (DBUser.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBUser();
                }
            }
        }
        return localInstance;
    }

    private DBUser(){


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            String[] str = { "user", "user", "user"};
            dao = DaoManager.createDao(new JdbcConnectionSource(str[0],str[1],str[2]),User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(dao!=null){
            try {
                if (!dao.isTableExists()) {
                    TableUtils.createTable(dao.getConnectionSource(),User.class);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }








    public void getUserWithUUID(String UUID, ICompletion<User> completion){



    }

    public void getUserWithUserName(String userName,ICompletion<User> completion){


    }


    public void getAllUsers(ICompletion < List<User> > completion) {



    }







}
