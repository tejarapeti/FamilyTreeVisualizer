package com.familytree.dataobjects;

import java.util.List;

public class FamilyTreeNode {
    private String familyMemberName;
    private String spouseName;
    private String relationName;
    private List<FamilyTreeNode> relatedFamilyMembers;

    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public List<FamilyTreeNode> getRelatedFamilyMembers() {
        return relatedFamilyMembers;
    }

    public void setRelatedFamilyMembers(List<FamilyTreeNode> relatedFamilyMembers) {
        this.relatedFamilyMembers = relatedFamilyMembers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(familyMemberName);
        if(spouseName != null && !spouseName.isEmpty()) result.append("|").append(spouseName);
        if(relationName != null && !relationName.isEmpty()) result.append("(").append(relationName).append(")");
        return result.toString();
    }
}
