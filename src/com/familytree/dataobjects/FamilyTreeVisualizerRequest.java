package com.familytree.dataobjects;

import com.familytree.constants.FamilyTreeType;
import com.familytree.constants.TreeVisualizationFormat;

public class FamilyTreeVisualizerRequest {
    private String personId;
    private int level;
    private FamilyTreeType treeType;
    private TreeVisualizationFormat visualizationFormat;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public FamilyTreeType getTreeType() {
        return treeType;
    }

    public void setTreeType(FamilyTreeType treeType) {
        this.treeType = treeType;
    }

    public TreeVisualizationFormat getVisualizationFormat() {
        return visualizationFormat;
    }

    public void setVisualizationFormat(TreeVisualizationFormat visualizationFormat) {
        this.visualizationFormat = visualizationFormat;
    }
}
