package com.familytree.treebuilder;

import com.familytree.dataobjects.FamilyTreeNode;

public interface FamilyTreeBuilder {

    public FamilyTreeNode buildFamilyTree(String personId, int level);
}
