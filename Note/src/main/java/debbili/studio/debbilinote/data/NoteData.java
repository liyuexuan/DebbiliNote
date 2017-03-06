package debbili.studio.debbilinote.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liyue_000 on 2017/3/5.
 */
public class NoteData {
    public int id = -1;
    public String title = "";
    public String content = "";
    public Date createDate;
    public boolean isShare = false;
    public List<String> shareList = new ArrayList<String>();
    public boolean isAlarm = false;
    public Date alarmDate;
    public int repeatType = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isShare() {
        return isShare;
    }

    public void setShare(boolean share) {
        isShare = share;
    }

    public List<String> getShareList() {
        return shareList;
    }

    public void setShareList(List<String> shareList) {
        this.shareList = shareList;
    }

    public boolean isAlarm() {
        return isAlarm;
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }
}
