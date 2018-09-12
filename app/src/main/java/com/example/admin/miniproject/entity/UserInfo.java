package com.example.admin.miniproject.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class UserInfo implements Parcelable, Serializable {
    public static final String JSON_KEY = "user_info";

    /*********** 解析标志位,按需解析，提升性能，请勿删除 ********/
    public static final int FLAG_VIP = 1;
    public static final int FLAG_LIVE = 2;
    public static final int FLAG_PUB = 4;
    public static final int FLAG_PARAMS = 8;
    private String uid;                //用户uid
    private String newno;              //迅雷id
    private String birthday;           //生日
    private String country;            //地区
    private String province;           //省
    private String sex;                //性别
    private String city;               //城市
    private String description;        //个性签名
    private String nickname;           //用户昵称
    private String portraitUrl;        //头像地址
    private String kind;               //身份类别
    private long loginTime;            //登录时间,单位ms


    public UserInfo() {

    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNewno() {
        return newno;
    }

    public void setNewno(String newno) {
        this.newno = newno;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSex() {
        return sex;
    }



    public void setSex(String sex) {
        this.sex = sex;
    }



    public boolean isMale() {
        return sex == null ? true : !"female".equals(sex);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNickname() {
        return TextUtils.isEmpty(nickname) ? "迅雷用户" : nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }



    public static UserInfo parseFrom(JSONObject jsonObject) throws JSONException {
        return parseFrom(new UserInfo(), jsonObject);
    }


    public static UserInfo parseFrom(UserInfo userInfo, JSONObject jsonObject) throws JSONException {
        if (jsonObject == null || jsonObject.length() <= 0) return userInfo;
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        userInfo.uid = jsonObject.getString("uid");
        userInfo.newno = jsonObject.optString("newno");
        userInfo.birthday = jsonObject.optString("birthday");
        userInfo.country = jsonObject.optString("country");
        userInfo.province = jsonObject.optString("province").trim();
        userInfo.city = jsonObject.optString("city").trim();
        userInfo.sex = jsonObject.optString("sex", Sex.UNKNOWN);
        userInfo.description = jsonObject.optString("description").trim();
        userInfo.nickname = jsonObject.optString("nick_name").trim();
        userInfo.portraitUrl = jsonObject.optString("portrait_url");

        return userInfo;
    }

    /**
     * 将VideoUserInfo转为JsonObject形式
     *
     * @return JSONObject
     */
    public JSONObject toJSONObject() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uid", uid);
            jsonObject.put("newno", newno);
            jsonObject.put("birthday", birthday);
            jsonObject.put("country", country);
            jsonObject.put("province", province);
            jsonObject.put("city", city);
            jsonObject.put("sex", sex);
            jsonObject.put("description", description);
            jsonObject.put("nick_name", nickname);
            jsonObject.put("portrait_url", portraitUrl);
            jsonObject.put("kind", kind);

            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*********** 性别 *************/
    public static abstract class Sex {
        public static final String UNKNOWN = "unknown";
        public static final String MALE = "male";
        public static final String FEMALE = "female";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.newno);
        dest.writeString(this.birthday);
        dest.writeString(this.country);
        dest.writeString(this.province);
        dest.writeString(this.sex);
        dest.writeString(this.city);
        dest.writeString(this.description);
        dest.writeString(this.nickname);
        dest.writeString(this.portraitUrl);
        dest.writeString(this.kind);
        dest.writeLong(this.loginTime);

    }

    protected UserInfo(Parcel in) {
        this.uid = in.readString();
        this.newno = in.readString();
        this.birthday = in.readString();
        this.country = in.readString();
        this.province = in.readString();
        this.sex = in.readString();
        this.city = in.readString();
        this.description = in.readString();
        this.nickname = in.readString();
        this.portraitUrl = in.readString();
        this.kind = in.readString();
        this.loginTime = in.readLong();

    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public static UserInfo create() {
        UserInfo userInfo = new UserInfo();
        userInfo.uid = "614753256";
        userInfo.nickname = "Test User";
        userInfo.portraitUrl = "http://img2.user.kanimg.com/usrimg/614753256/300x300";

        return userInfo;
    }
}
