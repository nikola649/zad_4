package ada.osc.taskie.model;

import java.io.Serializable;

public class Task implements Serializable {

    private int mPriority;
    private String mTitle;
    private String mDescription;
    private String mDate;

    public Task(String title, String description, int priority, String date) {
        mTitle = title;
        mDescription = description;
        mPriority = priority;
        mDate = date;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
