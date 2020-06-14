package MODEL.PROJECTDATA;

/**
 * Class defines how project Information has to be build
 */
public class M_PROJECTDATA_PROJECTINFO {
    public String title;
    public String content;

    /**
     * construct a project information objet
     * @param title contains the title of a project information object
     * @param content contains the content of a project information object
     */
    public M_PROJECTDATA_PROJECTINFO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
