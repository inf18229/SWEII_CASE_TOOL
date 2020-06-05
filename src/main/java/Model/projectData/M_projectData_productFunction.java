/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Product Functions
 */

package Model.projectData;

public class M_projectData_productFunction extends M_projectData_productContent {
    //TODO: renaming
    public String id = "";
    public String function = "";
    public String actor = "";
    public String description = "";
    public int functionPointWeighting;
    public String functionPointCategory = "";
    public int functionPointDET;
    public int functionPointFTR;


    public void calculateWeight(){
        /**
         * calculates the weight depending on DET and FTR depending on schmea
         */
        switch (functionPointCategory){
            case "EI-Eingabe":
                if(functionPointFTR<=1){
                    if(functionPointDET<=15){
                        functionPointWeighting=0;
                    }
                    else{
                        functionPointWeighting=1;
                    }
                }
                else if(functionPointFTR==2){
                    if(functionPointDET<=4){
                        functionPointWeighting=0;
                    }
                    else if(functionPointDET>=5&&functionPointDET<=15){
                        functionPointWeighting=1;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                else{
                    if(functionPointDET<=4){
                        functionPointWeighting=1;
                    }
                    else if(functionPointDET>=5&&functionPointDET<=15){
                        functionPointWeighting=2;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                break;
            case "EO-Ausgabe":
                if(functionPointFTR<=1){
                    if(functionPointDET<=19){
                        functionPointWeighting=0;
                    }
                    else{
                        functionPointWeighting=1;
                    }
                }
                else if(functionPointFTR>=2 && functionPointFTR<=3){
                    if(functionPointDET<=5){
                        functionPointWeighting=0;
                    }
                    else if(functionPointDET>=6&&functionPointDET<=19){
                        functionPointWeighting=1;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                else{
                    if(functionPointDET<=5){
                        functionPointWeighting=1;
                    }
                    else if(functionPointDET>=6&&functionPointDET<=19){
                        functionPointWeighting=2;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                break;
            case "EQ-Abfrage":
                if(functionPointFTR<=1){
                    if(functionPointDET<=19){
                        functionPointWeighting=0;
                    }
                    else{
                        functionPointWeighting=1;
                    }
                }
                else if(functionPointFTR>=2 && functionPointFTR<=3){
                    if(functionPointDET<=5){
                        functionPointWeighting=0;
                    }
                    else if(functionPointDET>=6&&functionPointDET<=19){
                        functionPointWeighting=1;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                else{
                    if(functionPointDET<=5){
                        functionPointWeighting=1;
                    }
                    else if(functionPointDET>=6&&functionPointDET<=19){
                        functionPointWeighting=2;
                    }
                    else{
                        functionPointWeighting=2;
                    }
                }
                break;
        }
    }
    public String getId() {
        return id;
    }

    public String getFunction() {
        return function;
    }

    public String getActor() {
        return actor;
    }

    public String getDescription() {
        return description;
    }

    public int getFunctionPointWeighting() {
        return functionPointWeighting;
    }

    public String getFunctionPointCategory() {
        return functionPointCategory;
    }

    public int getFunctionPointDET() {
        return functionPointDET;
    }

    public int getFunctionPointFTR() {
        return functionPointFTR;
    }

    public String toString(){
     return "ProductDataElement:" +id+", "+function+", "+actor+", "+description+", "+functionPointCategory+", "+functionPointWeighting+", "+functionPointFTR+", "+getFunctionPointDET();
    }
}
