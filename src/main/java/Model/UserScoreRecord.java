package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by nsd on 17.07.17.
 */

@DatabaseTable
public class UserScoreRecord {


    public UserScoreRecord(){}

    @DatabaseField(generatedId = true)
    private long userScoreRecordId;
    @DatabaseField
    private String userUUID;
    @DatabaseField
    private String userScore;
    @DatabaseField
    private String userName;


    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
