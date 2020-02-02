package com.familytree.visualizer;

import com.familytree.dataobjects.FamilyTreeNode;

import java.util.Iterator;

public class TextFamilyTreeVisualizer implements FamilyTreeVisualizer{
    @Override
    public String generateFamilyTreeVisualization(final FamilyTreeNode familyTreeRoot) {
        if(familyTreeRoot == null){
            return null;
        }
        final StringBuilder resultantView = new StringBuilder();
        treeVisualizationUtil(familyTreeRoot, resultantView, "", "");
        return resultantView.toString();
    }

    private void treeVisualizationUtil(final FamilyTreeNode familyTreeNode, final StringBuilder resultantView, final String prefix, final String childPrefix) {
        resultantView.append(prefix);
        resultantView.append(familyTreeNode.toString());
        resultantView.append("\n");
        if(familyTreeNode.getRelatedFamilyMembers() != null && !familyTreeNode.getRelatedFamilyMembers().isEmpty()){
            final Iterator<FamilyTreeNode> familyTreeIterator = familyTreeNode.getRelatedFamilyMembers().iterator();
            while(familyTreeIterator.hasNext()){
                final FamilyTreeNode nextNode = familyTreeIterator.next();
                if(familyTreeIterator.hasNext()){
                    treeVisualizationUtil(nextNode, resultantView, childPrefix+"|________________", childPrefix+"|               ");
                } else{
                    treeVisualizationUtil(nextNode, resultantView, childPrefix+"|________________", childPrefix+"                ");
                }
            }
        }

    }
}
