package Controller.tab;

import Model.projectData.M_projectData;
import View.I_V_frame;

import javax.swing.*;

public class C_functionalReqirement implements I_C_functionalReqirement{
    private JList funcReqIDList;
    private JTextField funcReqID;
    private JTextField funcReqFunction;
    private JTextField funcReqProtagonist;
    private JTextArea funcReqDescription;
    private JComboBox funcReqFPCategory;
    private JComboBox funcReqFPWeight;
    private JSpinner funcReqFPFTR;
    private JSpinner funcReqFPDET;
    private M_projectData projectData;

    public C_functionalReqirement(I_V_frame mainFrame, M_projectData projData){
    funcReqID=mainFrame.getTextFieldReqID();
    funcReqFunction=mainFrame.getTextFieldReqFunction();
    funcReqProtagonist=mainFrame.getTextFieldReqProtagonist();
    funcReqDescription=mainFrame.getTextAreaReqDescription();
    funcReqFPCategory=mainFrame.getComboBoxReqCategory();
    funcReqFPWeight=mainFrame.getComboBoxReqWeight();
    funcReqFPFTR=mainFrame.getSpinnerReqFTR();
    funcReqFPDET=mainFrame.getSpinnerReqDET();
    projectData=projData;

    }
    @Override
    public void updateProjectData(){

    }
}
