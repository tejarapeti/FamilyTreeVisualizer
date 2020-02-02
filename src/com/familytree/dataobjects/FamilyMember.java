package com.familytree.dataobjects;

public class FamilyMember {
    Person member;
    Relation relationWithMember;

    public FamilyMember(Person member, Relation relationWithMember){
        this.member = member;
        this.relationWithMember = relationWithMember;
    }

    public Person getMember() {
        return member;
    }

    public void setMember(Person member) {
        this.member = member;
    }

    public Relation getRelationWithMember() {
        return relationWithMember;
    }

    public void setRelationWithMember(Relation relationWithMember) {
        this.relationWithMember = relationWithMember;
    }
}
