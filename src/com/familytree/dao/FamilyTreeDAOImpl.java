package com.familytree.dao;

import com.familytree.database.InMemoryGraphDB;
import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.Person;
import com.familytree.dataobjects.Relation;

import java.util.LinkedList;
import java.util.List;

public class FamilyTreeDAOImpl implements FamilyTreeDAO {
    private InMemoryGraphDB graphDBInstance;

    public FamilyTreeDAOImpl(){
        graphDBInstance = InMemoryGraphDB.getInstance();
    }

    @Override
    public boolean isPersonAvailable(String personId){
        if(personId == null || personId.isEmpty()){
            return false;
        }
        return graphDBInstance.getPersonsMap().containsKey(personId);
    }

    @Override
    public Person getPerson(String personId) {
        if(personId == null || personId.isEmpty() || !isPersonAvailable(personId)){
            return null;
        }
        return graphDBInstance.getPersonsMap().get(personId);
    }

    @Override
    public List<FamilyMember> getImmediateFamilyMembers(String personId){
        List<FamilyMember> immediateFamilyMembers = new LinkedList<>();
        if(personId == null || personId.isEmpty() || !isPersonAvailable(personId)){
            return immediateFamilyMembers;
        }


        List<Relation> relationsOfPerson = graphDBInstance.getRelationsMap().get(personId);
        if(relationsOfPerson != null){
            relationsOfPerson.forEach( relation -> {
                Person relatedPerson = graphDBInstance.getPersonsMap().get(relation.getSecondPersonId());
                immediateFamilyMembers.add(new FamilyMember(relatedPerson, relation));
            });
        }
        return immediateFamilyMembers;
    }
}
