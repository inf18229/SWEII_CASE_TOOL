package MODEL.PROJECTDATA;

public class M_PROJECTDATA_PROJECTINFO {
    String title;
    String content;

    public M_PROJECTDATA_PROJECTINFO(String title, String content) {
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