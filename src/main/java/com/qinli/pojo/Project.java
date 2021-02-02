package com.qinli.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 与前端交互的project封装，其中member属性需经工具类com.qinli.util.ProjectClassPackUtil#projectClassPack(java.util.List, com.qinli.mapper.ProjectMapper)处理
 */
public class Project {
    private String id;
    private String title;
    private String host;
    private String department;
    private List<Map<String , String>> member;
    private String start_time;
    private String end_time;
    private String project_status;
    private String funds;
    private String level;
    private String host_school;
    private String coop_school;
    private String guide_id;
    private String recommend;
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Map<String , String>> getMember() {
        return member;
    }

    public void setMember(List<Map<String , String>> member) {
        this.member = member;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHost_school() {
        return host_school;
    }

    public void setHost_school(String host_school) {
        this.host_school = host_school;
    }

    public String getCoop_school() {
        return coop_school;
    }

    public void setCoop_school(String coop_school) {
        this.coop_school = coop_school;
    }

    public String getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(String guide_id) {
        this.guide_id = guide_id;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", host='" + host + '\'' +
                ", department='" + department + '\'' +
                ", member=" + member +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", project_status='" + project_status + '\'' +
                ", funds='" + funds + '\'' +
                ", level='" + level + '\'' +
                ", host_school='" + host_school + '\'' +
                ", coop_school='" + coop_school + '\'' +
                ", guide_id='" + guide_id + '\'' +
                ", recommend='" + recommend + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    /*public String toJson() {
        return "{\"id\":\""+ id +
                "\",\"title\":\"" + title +
                "\",\"host\":\"" + host +
                "\",\"department\":\"" + department +
                "\",\"member\":[" + member +
                "],\"rank\":[" + rank +
                "],\"salary_number\":[" + salary_number +
                "],\"start_time\":\"" + start_time +
                "\",\"end_time\":\"" + end_time +
                "\",\"project_status\":\"" + project_status +
                "\",\"funds\":\"" + funds +
                "\",\"level\":\"" + level +
                "\",\"host_school\":" + (host==""?"null":"\"" + host + "\"") +
                ",\"coop_school\":" + (coop_school==""?"null":"\"" + coop_school + "\"") +
                ",\"guide_id\":\"" + guide_id +
                "\",\"recommend\":" + (recommend==""?"null":"\"" + recommend + "\"") +
                ",\"code\":" + (code==""?"null":"\"" + code + "\"") +
                "}";
    }*/
}
