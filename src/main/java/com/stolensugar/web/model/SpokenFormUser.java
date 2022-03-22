package com.stolensugar.web.model;

import java.util.List;
import java.util.Map;

public class SpokenFormUser {
    private String spokenFormId;
    private String userId;
    private String choice;
    private List<String> choiceHistory;
    private Map<String, String> details;
    private Boolean updatedBranch;

    public SpokenFormUser(String spokenFormId, String userId, String choice) {
        this.spokenFormId = spokenFormId;
        this.userId = userId;
        this.choice = choice;
    }

    public String getSpokenFormId() {
        return spokenFormId;
    }

    public void setSpokenFormId(String spokenFormId) {
        this.spokenFormId = spokenFormId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getUpdatedBranch() {
        return updatedBranch;
    }

    public void setUpdatedBranch(Boolean updatedBranch) {
        this.updatedBranch = updatedBranch;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<String> getChoiceHistory() {
        return choiceHistory;
    }

    public void setChoiceHistory(List<String> choiceHistory) {
        this.choiceHistory = choiceHistory;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((spokenFormId == null) ? 0 : spokenFormId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpokenFormUser other = (SpokenFormUser) obj;
        if (spokenFormId == null) {
            if (other.spokenFormId != null)
                return false;
        } else if (!spokenFormId.equals(other.spokenFormId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SpokenFormUser{" +
                "spokenFormId='" + spokenFormId + '\'' +
                ", userId='" + userId + '\'' +
                ", choice='" + choice + '\'' +
                ", choiceHistory=" + choiceHistory +
                ", details=" + details +
                ", updatedBranch=" + updatedBranch +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public SpokenFormUser(Builder builder) {
        this.spokenFormId = builder.spokenFormId;
        this.userId = builder.userId;
        this.choice = builder.choice;
        this.choiceHistory = builder.choiceHistory;
        this.details = builder.details;
        this.updatedBranch = builder.updatedBranch;
    }

    public static final class Builder {
        private String spokenFormId;
        private String userId;
        private String choice;
        private List<String> choiceHistory;
        private Map<String, String> details;
        private Boolean updatedBranch;

        private Builder() { 

        }

        public Builder withSpokenFormId(String spokenFormId) {
            this.spokenFormId = spokenFormId;
            return this;
        }

        public Builder withChoice(String choice) { 
            this.choice = choice;
            return this;
        }

        public Builder withChoiceHistory(List<String> choiceHistory) {
            this.choiceHistory = choiceHistory;
            return this;
        }

        public Builder withDetails(Map<String, String> details) {
            this.details = details;
            return this;
        }

        public Builder withUpdatedBranch(Boolean updatedBranch) {
            this.updatedBranch = updatedBranch;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public SpokenFormUser build() {return new SpokenFormUser(this);}
    }

}
