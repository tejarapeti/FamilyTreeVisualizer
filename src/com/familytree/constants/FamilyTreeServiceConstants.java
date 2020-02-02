package com.familytree.constants;

import java.util.Map;

public class FamilyTreeServiceConstants {

    public static final String GRAND = "GRAND";
    public static final String GREAT = "GREAT";
    public static final String separator = " ";
    public static final Map<RelationName, RelationType> relationToRelationTypeMap =
            Map.of(RelationName.FATHER, RelationType.PREDECESSOR,
                    RelationName.MOTHER, RelationType.PREDECESSOR,
                    RelationName.SON, RelationType.SUCCESSOR,
                    RelationName.DAUGHTER, RelationType.SUCCESSOR,
                    RelationName.SIBLING, RelationType.PARALLEL,
                    RelationName.SPOUSE, RelationType.PARALLEL);

}
