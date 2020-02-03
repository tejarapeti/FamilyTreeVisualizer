package com.familytree.treebuilder;

import com.familytree.dataobjects.FamilyTreeNode;
import com.familytree.exception.DataUnavailableException;
import com.familytree.exception.InvalidInputException;

public interface FamilyTreeBuilder {

    public FamilyTreeNode buildFamilyTree(String personId, int level) throws DataUnavailableException, InvalidInputException;
}
