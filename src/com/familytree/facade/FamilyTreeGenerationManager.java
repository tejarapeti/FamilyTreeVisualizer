package com.familytree.facade;

import com.familytree.dataobjects.FamilyTreeNode;
import com.familytree.treebuilder.FamilyTreeBuilder;
import com.familytree.util.FamilyTreeCommonUtil;
import com.familytree.visualizer.FamilyTreeVisualizer;

public class FamilyTreeGenerationManager {

    private FamilyTreeBuilder familyTreeBuilder;
    private FamilyTreeVisualizer familyTreeVisualizer;

    public FamilyTreeGenerationManager(FamilyTreeBuilder familyTreeBuilder, FamilyTreeVisualizer familyTreeVisualizer){
        this.familyTreeBuilder = familyTreeBuilder;
        this.familyTreeVisualizer = familyTreeVisualizer;
    }

    public String getFamilyTreeVisualization(final String personId,final int level){
        String visualization = null;

        FamilyTreeNode familyTreeRoot = familyTreeBuilder.buildFamilyTree(personId, level);
        //FamilyTreeCommonUtil util = new FamilyTreeCommonUtil();
        //util.printFamilyTreeLevelOrder(familyTreeRoot);
        if(familyTreeRoot != null){
            visualization = familyTreeVisualizer.generateFamilyTreeVisualization(familyTreeRoot);
        }
        return visualization;
    }
}
