package com.example.holidaytrip;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PlanRVModal implements Parcelable {

    private String planName;
    private String planPrice;
    private String planDesc;
    private String planLocation;
    private String planID;

    public PlanRVModal(){

    }

    public PlanRVModal(String planName, String planPrice, String planDesc, String planLocation, String planID) {
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDesc = planDesc;
        this.planLocation = planLocation;
        this.planID = planID;
    }

    protected PlanRVModal(Parcel in) {
        planName = in.readString();
        planPrice = in.readString();
        planDesc = in.readString();
        planLocation = in.readString();
        planID = in.readString();
    }

    public static final Creator<PlanRVModal> CREATOR = new Creator<PlanRVModal>() {
        @Override
        public PlanRVModal createFromParcel(Parcel in) {
            return new PlanRVModal(in);
        }

        @Override
        public PlanRVModal[] newArray(int size) {
            return new PlanRVModal[size];
        }
    };

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public String getPlanLocation() {
        return planLocation;
    }

    public void setPlanLocation(String planLocation) {
        this.planLocation = planLocation;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(planName);
        parcel.writeString(planPrice);
        parcel.writeString(planDesc);
        parcel.writeString(planLocation);
        parcel.writeString(planID);
    }
}
