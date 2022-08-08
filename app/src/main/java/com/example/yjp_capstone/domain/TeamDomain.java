package com.example.yjp_capstone.domain;

public class TeamDomain {
    private String teamTitle;
    private boolean status;

    public TeamDomain(String teamTitle, boolean status) {
        this.teamTitle = teamTitle;
        this.status = status;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
