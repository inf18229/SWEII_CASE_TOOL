package MODEL;

import MODEL.PROJECTDATA.M_PROJECTDATA;

/**
 * I_M_IMPORT is the interface for import
 */
public interface I_M_IMPORT {

    /**
     * the import method for project data has to be implemented to be run by the M_IMPOT class
     * it should import the project data of a project
     *
     * @param path the path from where the project data should be imported
     * @return the imported project data
     */
    public M_PROJECTDATA importProject(String path);

    /**
     * the import method for config data has to be implemented to be run by the M_IMPORT class
     * it should import the config data of a project into the current project
     *
     * @param projData the project that imports the config data
     * @param path     the path from where the config data should be imported
     */
    public void importProject(M_PROJECTDATA projData, String path);
}
