package VIEW;

public interface I_V_START extends I_V_BASIC {

    /**
     * opens the JFileChooser and returns the chosen path
     *
     * @param existingFile false: new file should be created
     *                     true: existing file should be opened
     * @return path to the chosen file
     */
    public String getPath(boolean existingFile);
}
