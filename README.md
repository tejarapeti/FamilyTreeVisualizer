## FamilyTreeVisualizer

### What does it do?
*FamilyTreeVisualizer* takes the name of the person whose family tree has to be printed, the no of levels of the tree  to be printed, the type of the tree ( Eg: Successor Tree, which shows all successors(son, grand daughter etc..) of the given person etc..), the format in which the tree has to be visualized ( Eg: Grahical Text visualization ( similar to unix directory tree structure) etc..) as inputs and returns the visualization of the family tree of the person in the requested visualization format.
Currently the application supports only Successor Tree Type and Text visualization but can be easily extended to other tree types and visualization formats. In the Text visualization of the family tree each node is of the form:
<person>|<spouse>(<relation with person whose family tree is being built>)
Eg: Chris|Samantha(GRAND SON)
where Chris is the person, Samantha is the spouse of the person and "GRAND SON" is the relation of the Chris with the person whose famiy tree is being built.

### How to use it?
Use the main method written in FamilyTreeServiceImpl class for generating family trees with sample data. The sample data is available in initializeDBWithTestData method present in InMemoryGraphDB.

for Example:
#### sample code to test the application:

```
        FamilyTreeServiceImpl service = new FamilyTreeServiceImpl();
        FamilyTreeVisualizerRequest request = new FamilyTreeVisualizerRequest();
        request.setPersonId("Mike");
        request.setLevel(6);
        request.setTreeType(FamilyTreeType.SUCCESSOR);
        request.setVisualizationFormat(TreeVisualizationFormat.TEXT);
        try {
            FamilyTreeVisualizerResponse response = service.getFamilyTree(request);
            System.out.println(response.getResultantView());
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
```

#### output for the code:

```
Mike|Sandra
|________________Harry(SON)
|________________Adam|Molly(SON)
                |________________Chris|Samantha(GRAND SON)
                |               |________________Emily(GREAT GRAND DAUGHTER)
                |               |________________Anna(GREAT GRAND DAUGHTER)
                |________________David(GRAND SON)
                |________________Penny|Mark(GRAND DAUGHTER)
                                |________________Leo(GREAT GRAND SON)
                                |________________Diana(GREAT GRAND DAUGHTER)


Process finished with exit code 0
```

### How to enter sample data in the in-memory db for testing?

for Example:
Mike is a person. His wife is Sandra. They have 2 sons, Harry and Adam. Harry and Adam are siblings.
the entries for these persons and their relations can be made in in initializeDBWithTestData method present in InMemoryGraphDB.
the code snippet for making these entries is as below.
add the below code to initializeDBWithTestData method present in InMemoryGraphDB:

```
        Person Mike = new Person();
        Mike.setPersonId("Mike");
        Mike.setName("Mike");
        Mike.setGender(Gender.MALE);

        Person Sandra = new Person();
        Sandra.setPersonId("Sandra");
        Sandra.setName("Sandra");
        Sandra.setGender(Gender.FEMALE);
        
        Person Adam = new Person();
        Adam.setPersonId("Adam");
        Adam.setName("Adam");
        Adam.setGender(Gender.MALE);

        Person Harry = new Person();
        Harry.setPersonId("Harry");
        Harry.setName("Harry");
        Harry.setGender(Gender.MALE);
        
        personsMap.put("Mike", Mike);
        personsMap.put("Sandra", Sandra);
        personsMap.put("Harry", Harry);
        personsMap.put("Adam", Adam);
        
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
        relationsList.add(createRelation("Adam","Harry", RelationName.SIBLING,
                FamilyTreeServiceConstants.relationToRelationTypeMap.get(RelationName.SIBLING)));
        relationsMap.put("Adam", relationsList);
```

#### NOTE: make sure each person has a unique person id.
