package com.familytree.dataobjects;

import com.familytree.constants.TreeVisualizationFormat;

public class FamilyTreeVisualizerResponse {
    TreeVisualizationFormat visualizationFormat;
    String resultantView;
    String message;

    public TreeVisualizationFormat getVisualizationFormat() {
        return visualizationFormat;
    }

    public void setVisualizationFormat(TreeVisualizationFormat visualizationFormat) {
        this.visualizationFormat = visualizationFormat;
    }

    public String getResultantView() {
        return resultantView;
    }

    public void setResultantView(String resultantView) {
        this.resultantView = resultantView;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
