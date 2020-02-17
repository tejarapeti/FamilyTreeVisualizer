package com.familytree.dao;

import com.familytree.database.InMemoryGraphDB;
import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.Person;
import com.familytree.dataobjects.Relation;
import com.familytree.exception.DataUnavailableException;
import com.familytree.exception.InvalidInputException;

import java.util.LinkedList;
import java.util.List;

public class FamilyTreeDAOImpl implements FamilyTreeDAO {
    private InMemoryGraphDB graphDBInstance;

    public FamilyTreeDAOImpl(){
        graphDBInstance = InMemoryGraphDB.getInstance();
    }

    private boolean isPersonAvailable(String personId) {
        if(personId == null || personId.isEmpty()){
            return false;
        }
        return graphDBInstance.getPersonsMap().containsKey(personId);
    }

    @Override
    public Person getPerson(String personId) throws InvalidInputException, DataUnavailableException {
        if(personId == null || personId.isEmpty()){
            throw new InvalidInputException("person id cannot be null or empty");
        }
        if(!isPersonAvailable(personId)){
            throw new DataUnavailableException("The person " + personId + " does not exist");
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
