/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Project Information
 */

package Model;

public class M_projectData_projectInfo {
    String title;
    String content;

    public M_projectData_projectInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String _content) {
        this.content = _content;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
