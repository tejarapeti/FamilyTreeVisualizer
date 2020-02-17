package com.familytree.dataobjects;

import com.familytree.constants.RelationName;
import com.familytree.constants.RelationType;

public class Relation {
    //private int relationId;
    private String firstPersonId;
    private String secondPersonId;
    private RelationName relationName;
    private RelationType relationType;

    /*public int getRelationId() { return relationId; }

    public void setRelationId(int relationId) { this.relationId = relationId; }*/

    public String getFirstPersonId() {
        return firstPersonId;
    }

    public void setFirstPersonId(String firstPersonId) {
        this.firstPersonId = firstPersonId;
    }

    public String getSecondPersonId() {
        return secondPersonId;
    }

    public void setSecondPersonId(String secondPersonId) {
        this.secondPersonId = secondPersonId;
    }

    public RelationName getRelationName() {
        return relationName;
    }

    public void setRelationName(RelationName relationName) {
        this.relationName = relationName;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }
}
