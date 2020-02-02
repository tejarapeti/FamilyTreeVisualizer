package com.familytree.dao;

import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.Person;

import java.util.List;

public interface FamilyTreeDAO {

    boolean isPersonAvailable(String personId);

    Person getPerson(String personId);

    List<FamilyMember> getImmediateFamilyMembers(String personId);

}
