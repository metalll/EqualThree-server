package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by nsd on 17.07.17.
 */


@DatabaseTable
public class UserReplay {


    public UserReplay(){};



    @DatabaseField(generatedId = true)
    private long userReplayId;

    @DatabaseField
    private String userUUID;
    @DatabaseField
    private String userReplay;





    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUserReplay() {
        return userReplay;
    }

    public void setUserReplay(String userReplay) {
        this.userReplay = userReplay;
    }

    public long getUserReplayId() {
        return userReplayId;
    }

    public void setUserReplayId(long userReplayId) {
        this.userReplayId = userReplayId;
    }
}
