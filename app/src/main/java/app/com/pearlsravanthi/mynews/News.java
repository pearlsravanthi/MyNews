package app.com.pearlsravanthi.mynews;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by sravanthi
 */

public class News {
    private String mWebTitle;
    private String mPublicationDate;
    private String mWebUrl;
    private String mSectionName;

    public News(JSONObject newsObject) {
        try {
            this.mWebTitle = newsObject.getString("webTitle");
            this.mPublicationDate = newsObject.getString("webPublicationDate");
            this.mWebUrl = newsObject.getString("webUrl");
            this.mSectionName = newsObject.getString("sectionName");
        } catch (JSONException e) {
            Log.e(TAG, "Error creating a News object from JSONObject", e);
        }
    }

    public String getWebTitle() { return mWebTitle; }
    public String getPublicationDate() { return mPublicationDate; }
    public String getWebUrl() { return mWebUrl; }
    public String getSectionName() { return mSectionName; }

    public static List<News> getNewsListFromJson(JSONArray jsonNewsObjects) {
        if( jsonNewsObjects == null || jsonNewsObjects.length() == 0) return null;

        List<News> newsList = new ArrayList<News>();

        //Extract news objects and from JSONArray
        for(int i = 0; i < jsonNewsObjects.length(); i++) {
            try {
                JSONObject newsObject = jsonNewsObjects.getJSONObject(i);
                newsList.add(new News(newsObject));
            } catch (JSONException e) {
                Log.e(TAG, "Error extracting news objects from JSONArray: ", e);
            }
        }

        return newsList;
    }
}
