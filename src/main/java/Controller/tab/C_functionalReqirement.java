package Controller.tab;

import Model.projectData.M_projectData;
import Model.projectData.M_projectData_productContentFactory;
import Model.projectData.M_projectData_productFunction;
import View.I_V_frame;

import javax.swing.*;

public class C_functionalReqirement implements I_C_functionalReqirement{
    private I_V_frame frameView;
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
        frameView=mainFrame;
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
    @Override
    public void newFuncReqElement(){
        //TODO: Rename Product Function to Functional Reqirement!
        System.out.println("Notified Tab Func Req that a new Element is requested");
        M_projectData_productFunction newProducFunction=new M_projectData_productContentFactory().createProductFunction(funcReqID.getText());
        newProducFunction.actor=funcReqProtagonist.getText();
        newProducFunction.function=funcReqFunction.getText();
        newProducFunction.description=funcReqDescription.getText();
        newProducFunction.functionPointCategory=funcReqFPCategory.getSelectedItem().toString();
        newProducFunction.functionPointFTR=(int)funcReqFPFTR.getValue();
        newProducFunction.functionPointDET=(int)funcReqFPDET.getValue();

        System.out.println(newProducFunction.toString());
        projectData.getProductFunctionList().add(newProducFunction);
        frameView.updateFuncReqIDList(funcReqID.getText());

    }
}
