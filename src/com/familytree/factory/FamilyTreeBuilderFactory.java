package com.familytree.factory;

import com.familytree.constants.FamilyTreeType;
import com.familytree.dao.FamilyTreeDAO;
import com.familytree.treebuilder.FamilyTreeBuilder;
import com.familytree.treebuilder.SiblingFamilyTreeBuilder;
import com.familytree.treebuilder.SuccessorFamilyTreeBuilder;

public class FamilyTreeBuilderFactory {
    public static FamilyTreeBuilder getInstance(FamilyTreeType treeType, FamilyTreeDAO familyTreeDAO){
        FamilyTreeBuilder familyTreeBuilder = null;
        if(treeType.equals(FamilyTreeType.SUCCESSOR)){
            familyTreeBuilder = new SuccessorFamilyTreeBuilder(familyTreeDAO);
        } else if(treeType.equals(FamilyTreeType.SIBLING)){
            familyTreeBuilder  = new SiblingFamilyTreeBuilder(familyTreeDAO);
        } else{
            familyTreeBuilder = new SuccessorFamilyTreeBuilder(familyTreeDAO);
        }
        return familyTreeBuilder;
    }
}
