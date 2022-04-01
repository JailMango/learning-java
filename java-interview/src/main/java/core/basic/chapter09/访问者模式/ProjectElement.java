package core.basic.chapter09.访问者模式;

import java.util.Date;

import lombok.ToString;

/**
 * ProjectElement
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.访问者模式
 * @since R9.0
 */
@ToString
public class ProjectElement implements Element {

    private String projectName;

    private String projectContent;

    private String visitorName;

    private Date visitTime;

    public ProjectElement(String projectName, String projectContent) {
        this.projectName = projectName;
        this.projectContent = projectContent;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void signature(String visitorName, Date visitTime) {
        this.visitorName = visitorName;
        this.visitTime = visitTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
