package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

/**
 * TODO: add description
 */
public interface I_C_TAB {
    /**
     * this method sets the necessary links after instantiation of the controller
     *
     * @param view     reference to the view that should be referenced in this object
     * @param projData reference to the project data that should be referenced in this object
     */
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData);
    /**
     * //TODO: add description
     */
    public void updateProjectData();
}
