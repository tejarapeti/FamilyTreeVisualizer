package com.familytree.factory;

import com.familytree.constants.TreeVisualizationFormat;
import com.familytree.visualizer.FamilyTreeVisualizer;
import com.familytree.visualizer.TextFamilyTreeVisualizer;

public class FamilyTreeVisualizerFactory {

    public static FamilyTreeVisualizer getInstance(TreeVisualizationFormat visualizationFormat){
        FamilyTreeVisualizer familyTreeVisualizer = null;

        if(visualizationFormat.equals(TreeVisualizationFormat.TEXT)){
            familyTreeVisualizer = new TextFamilyTreeVisualizer();
        } else{
            familyTreeVisualizer = new TextFamilyTreeVisualizer();
        }
        return familyTreeVisualizer;
    }
}
