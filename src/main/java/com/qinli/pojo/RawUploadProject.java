package com.qinli.pojo;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author Cambria
 * @creat 2021/1/22 15:09
 */
public class RawUploadProject {
    private String id;
    private String title;
    private String host;
    private String department;
    private String member;
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

    public RawUploadProject(Project project) {
        id = project.getId();
        title = project.getTitle();
        host = project.getHost();
        department = project.getDepartment();
        start_time = project.getStart_time();
        end_time = project.getEnd_time();
        project_status = project.getProject_status();
        funds = project.getFunds();
        level = project.getLevel();
        host_school = project.getHost_school();
        coop_school = project.getCoop_school();
        guide_id = project.getGuide_id();
        recommend = project.getRecommend();
        code = project.getCode();

        StringBuilder sb = new StringBuilder();
        List temp = project.getMember();
        Iterator<Map> it = temp.iterator();

        while (it.hasNext()) {
            sb.append(it.next().get("info") + "/");
        }
        member = sb.deleteCharAt(sb.length()-1).toString();
    }

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

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
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
        return "RawUploadProject{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", host='" + host + '\'' +
                ", department='" + department + '\'' +
                ", member='" + member + '\'' +
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
}
