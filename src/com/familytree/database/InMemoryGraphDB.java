package com.familytree.database;

import com.familytree.constants.FamilyTreeServiceConstants;
import com.familytree.constants.Gender;
import com.familytree.constants.RelationName;
import com.familytree.constants.RelationType;
import com.familytree.dataobjects.Person;
import com.familytree.dataobjects.Relation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryGraphDB {

    private static InMemoryGraphDB dbInstance;
    private Map<String, Person> personsMap;
    private Map<String, List<Relation>> relationsMap;

    private InMemoryGraphDB() {
        personsMap = new HashMap<>();
        relationsMap = new HashMap<>();
        initializeDBWithTestData();
    }

    public static InMemoryGraphDB getInstance() {
        if (dbInstance == null) {
            synchronized (InMemoryGraphDB.class) {
                if (dbInstance == null) {
                    dbInstance = new InMemoryGraphDB();
                }
            }
        }
        return dbInstance;
    }

    public Map<String, Person> getPersonsMap() {
        return personsMap;
    }

    public Map<String, List<Relation>> getRelationsMap() {
        return relationsMap;
    }

    private void initializeDBWithTestData() {
        Person Mike = new Person();
        Mike.setPersonId("Mike");
        Mike.setName("Mike");
        Mike.setGender(Gender.MALE);

        Person Sandra = new Person();
        Sandra.setPersonId("Sandra");
        Sandra.setName("Sandra");
        Sandra.setGender(Gender.FEMALE);

        Person John = new Person();
        John.setPersonId("John");
        John.setName("John");
        John.setGender(Gender.MALE);

        Person Emma = new Person();
        Emma.setPersonId("Emma");
        Emma.setName("Emma");
        Emma.setGender(Gender.FEMALE);

        Person Molly = new Person();
        Molly.setPersonId("Molly");
        Molly.setName("Molly");
        Molly.setGender(Gender.FEMALE);

        Person Adam = new Person();
        Adam.setPersonId("Adam");
        Adam.setName("Adam");
        Adam.setGender(Gender.MALE);

        Person Harry = new Person();
        Harry.setPersonId("Harry");
        Harry.setName("Harry");
        Harry.setGender(Gender.MALE);

        Person Samantha = new Person();
        Samantha.setPersonId("Samantha");
        Samantha.setName("Samantha");
        Samantha.setGender(Gender.FEMALE);

        Person Chris = new Person();
        Chris.setPersonId("Chris");
        Chris.setName("Chris");
        Chris.setGender(Gender.MALE);

        Person David = new Person();
        David.setPersonId("David");
        David.setName("David");
        David.setGender(Gender.MALE);

        Person Penny = new Person();
        Penny.setPersonId("Penny");
        Penny.setName("Penny");
        Penny.setGender(Gender.FEMALE);

        Person Mark = new Person();
        Mark.setPersonId("Mark");
        Mark.setName("Mark");
        Mark.setGender(Gender.MALE);

        Person Emily = new Person();
        Emily.setPersonId("Emily");
        Emily.setName("Emily");
        Emily.setGender(Gender.FEMALE);

        Person Anna = new Person();
        Anna.setPersonId("Anna");
        Anna.setName("Anna");
        Anna.setGender(Gender.FEMALE);

        Person Diana = new Person();
        Diana.setPersonId("Diana");
        Diana.setName("Diana");
        Diana.setGender(Gender.FEMALE);

        Person Leo = new Person();
        Leo.setPersonId("Leo");
        Leo.setName("Leo");
        Leo.setGender(Gender.MALE);

        personsMap.put("Mike", Mike);
        personsMap.put("Sandra", Sandra);
        personsMap.put("John", John);
        personsMap.put("Emma", Emma);
        personsMap.put("Harry", Harry);
        personsMap.put("Adam", Adam);
        personsMap.put("Molly", Molly);
        personsMap.put("Samantha", Samantha);
        personsMap.put("Chris", Chris);
        personsMap.put("David", David);
        personsMap.put("Penny", Penny);
        personsMap.put("Mark", Mark);
        personsMap.put("Emily", Emily);
        personsMap.put("Anna", Anna);
        personsMap.put("Diana", Diana);
        personsMap.put("Leo", Leo);

        List<Relation> relationsList = new LinkedList<>();
        relationsList.add(createRelation("Mike", "Sandra",
                RelationName.SPOUSE, FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Mike","Harry", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Mike","Adam", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsMap.put("Mike", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Sandra","Mike", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Sandra","Harry", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Sandra","Adam", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsMap.put("Sandra", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("John","Emma", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("John","Molly", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("John", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Emma","John", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Emma","Molly", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Emma", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Harry","Mike", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Harry","Sandra", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Harry","Adam", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Harry", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Adam","Mike", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Adam","Sandra", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Adam","Molly", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Adam","Harry", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("Adam","Chris", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Adam","David", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Adam","Penny", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Adam", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Molly","John", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Molly","Emma", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Molly","Adam", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Molly","Chris", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Molly","David", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Molly","Penny", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Molly", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Samantha","Chris", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Samantha","Emily", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsList.add(createRelation("Samantha","Anna", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Samantha", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Chris","Adam", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Chris","Molly", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Chris","Samantha", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Chris","David", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("Chris","Penny", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("Chris","Emily", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsList.add(createRelation("Chris","Anna", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Chris", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("David","Adam", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("David","Molly", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("David","Chris", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("David","Penny", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("David", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Penny","Adam", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Penny","Molly", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Penny","Mark", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Penny","Chris", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("Penny","David", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsList.add(createRelation("Penny","Leo", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Penny","Diana", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Penny", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Mark","Penny", RelationName.SPOUSE,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SPOUSE)));
        relationsList.add(createRelation("Mark","Leo", RelationName.SON,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SON)));
        relationsList.add(createRelation("Mark","Diana", RelationName.DAUGHTER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.DAUGHTER)));
        relationsMap.put("Mark", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Emily","Chris", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Emily","Samantha", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Emily","Anna", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Emily", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Anna","Chris", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Anna","Samantha", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Anna","Emily", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Anna", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Diana","Mark", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Diana","Penny", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Diana","Leo", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Diana", relationsList);

        relationsList = new LinkedList<>();
        relationsList.add(createRelation("Leo","Mark", RelationName.FATHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.FATHER)));
        relationsList.add(createRelation("Leo","Penny", RelationName.MOTHER,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.MOTHER)));
        relationsList.add(createRelation("Leo","Diana", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Leo", relationsList);
    }

    private Relation createRelation(String firstPersonId, String secondPersonId, RelationName relationName, RelationType relationType) {
        Relation relation = new Relation();
        relation.setFirstPersonId(firstPersonId);
        relation.setSecondPersonId(secondPersonId);
        relation.setRelationName(relationName);
        relation.setRelationType(relationType);
        return relation;
    }
}
