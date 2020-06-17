package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import VIEW.I_V_FRAME;

/**
 * Tab Controller Interface defines all function that has to be provided by a tab Controller
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
     * triggeres an update of Project Data
     * minimal requirement of a Tab Element
     */
    public void updateProjectData();
}
