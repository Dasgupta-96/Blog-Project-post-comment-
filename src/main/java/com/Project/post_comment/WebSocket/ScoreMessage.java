package com.Project.post_comment.WebSocket;

public class ScoreMessage {
  private String team;
  private int runs;
  private int wickets;
  private double overs;

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public int getRuns() {
    return runs;
  }

  public void setRuns(int runs) {
    this.runs = runs;
  }

  public int getWickets() {
    return wickets;
  }

  public void setWickets(int wickets) {
    this.wickets = wickets;
  }

  public double getOvers() {
    return overs;
  }

  public void setOvers(double overs) {
    this.overs = overs;
  }
}