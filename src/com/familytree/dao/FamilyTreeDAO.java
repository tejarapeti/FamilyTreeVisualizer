package com.familytree.dao;

import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.Person;
import com.familytree.exception.DataUnavailableException;
import com.familytree.exception.InvalidInputException;

import java.util.List;

public interface FamilyTreeDAO {

    Person getPerson(String personId) throws DataUnavailableException, InvalidInputException;

    List<FamilyMember> getImmediateFamilyMembers(String personId);

}
