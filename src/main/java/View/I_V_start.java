package View;

public interface I_V_start extends I_V_basic {

    void debugPrint(String output);

    /**
     * opens the JFileChooser and returns the chosen path
     *
     * @param existingFile false: new file should be created
     *                true: existing file should be opened
     * @return path to the chosen file
     */
    String getPath(boolean existingFile);
}
