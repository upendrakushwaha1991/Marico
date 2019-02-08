
package com.cpm.reckitt_benckiser_gt.getterSetter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ChecklistMaster implements Serializable {

    @SerializedName("Checklist_Id")
    @Expose
    private Integer checklistId;
    @SerializedName("Checklist")
    @Expose
    private String checklist;

    private ArrayList<ChecklistAnswer> checkListAnswer = new ArrayList<>();

    private int answered_cd = 0;

    public int getAnswered_cd() {
        return answered_cd;
    }

    public void setAnswered_cd(int answered_cd) {
        this.answered_cd = answered_cd;
    }

    public ArrayList<ChecklistAnswer> getCheckListAnswer() {
        return checkListAnswer;
    }

    public void setCheckListAnswer(ArrayList<ChecklistAnswer> checkListAnswer) {
        this.checkListAnswer = checkListAnswer;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

}
