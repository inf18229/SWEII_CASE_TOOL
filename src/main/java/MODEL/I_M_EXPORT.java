package MODEL;

import MODEL.FUNCTIONPOINTESTIMATION.M_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA;

/**
 * I_M_EXPORT is the interface for export
 */
public interface I_M_EXPORT {

    /**
     * the export method for project data has to be implemented to be run by the M_EXPORT class
     * it should export the project data of a project
     * @param projData the project data that is exported
     * @param projPath the path to where the project data should be exported
     */
    public void export(M_PROJECTDATA projData, String projPath);

    /**
     * the export method for config data has to be implemented to be run by the M_EXPORT class
     * it should export the config data of a project
     * @param confData the config data that is exported
     * @param confPath the path to where the config data should be exported
     */
    public void export(M_FUNCTIONPOINTESTIMATION_CONFIGDATA confData, String confPath);
}
