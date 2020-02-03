package com.familytree.treebuilder;

import com.familytree.constants.FamilyTreeServiceConstants;
import com.familytree.constants.RelationName;
import com.familytree.constants.RelationType;
import com.familytree.dao.FamilyTreeDAO;
import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.FamilyTreeNode;
import com.familytree.dataobjects.Person;
import com.familytree.dataobjects.Relation;
import com.familytree.exception.DataUnavailableException;
import com.familytree.exception.InvalidInputException;

import java.util.*;

public class SuccessorFamilyTreeBuilder implements FamilyTreeBuilder {

    private FamilyTreeDAO familyTreeDAO;

    public SuccessorFamilyTreeBuilder(FamilyTreeDAO familyTreeDAO){
        this.familyTreeDAO = familyTreeDAO;
    }

    @Override
    public FamilyTreeNode buildFamilyTree(final String personId, final int level) throws DataUnavailableException, InvalidInputException {
        if(personId == null || personId.isEmpty() || level <= 0){
            //throw exception
            return null;
        }
        final FamilyTreeNode root = new FamilyTreeNode();
        final Queue<String> familyMemberQueue = new LinkedList<>();
        final Queue<FamilyTreeNode> familyTreeNodeQueue = new LinkedList<>();
        final Set<String> visitedFamilyMembersSet = new HashSet<>();

        final Person firstPerson = familyTreeDAO.getPerson(personId);
        root.setFamilyMemberName(firstPerson.getName());
        familyMemberQueue.offer(firstPerson.getPersonId());
        familyTreeNodeQueue.offer(root);
        visitedFamilyMembersSet.add(firstPerson.getPersonId());
        int currentLevel = level;

        while(!familyMemberQueue.isEmpty() && currentLevel > 0){
            int levelNodeCount = familyMemberQueue.size();
            while(levelNodeCount-- > 0){
                String currentFamilyMember = familyMemberQueue.poll();
                final FamilyTreeNode currentFamilyMemberNode = familyTreeNodeQueue.poll();
                final List<FamilyMember> immediateFamilyMembers = familyTreeDAO.getImmediateFamilyMembers(currentFamilyMember);
                if(immediateFamilyMembers == null || immediateFamilyMembers.isEmpty() || currentFamilyMemberNode == null){
                    continue;
                }
                final List<FamilyTreeNode> relatedFamilyMembersList = new LinkedList<>();
                for(FamilyMember familyMember : immediateFamilyMembers){
                    if(familyMember != null){
                        if(visitedFamilyMembersSet.contains(familyMember.getMember().getPersonId())){
                            continue;
                        }
                        if(familyMember.getRelationWithMember().getRelationName().equals(RelationName.SPOUSE)){
                            currentFamilyMemberNode.setSpouseName(familyMember.getMember().getName());
                        } else if(familyMember.getRelationWithMember().getRelationType().equals(RelationType.SUCCESSOR) && currentLevel > 1){
                            final FamilyTreeNode relatedFamilyMember = new FamilyTreeNode();
                            relatedFamilyMember.setFamilyMemberName(familyMember.getMember().getName());
                            relatedFamilyMember.setRelationName(getRelationName(familyMember.getRelationWithMember(), level, currentLevel));
                            visitedFamilyMembersSet.add(familyMember.getMember().getPersonId());
                            familyMemberQueue.offer(familyMember.getMember().getPersonId());
                            familyTreeNodeQueue.offer(relatedFamilyMember);
                            relatedFamilyMembersList.add(relatedFamilyMember);
                        }
                    }
                }
                currentFamilyMemberNode.setRelatedFamilyMembers(relatedFamilyMembersList);
            }
            currentLevel--;
        }
        return root;
    }

    private String getRelationName(final Relation relationWithMember, final int level, final int currentLevel) {
        if(relationWithMember == null){
            return null;
        }
        final StringBuilder derivedRelation = new StringBuilder();
        int levelDiff = level-currentLevel;
        while(levelDiff > 0){
            if(levelDiff == 1){
                derivedRelation.append(FamilyTreeServiceConstants.GRAND).append(FamilyTreeServiceConstants.separator);
            } else{
                derivedRelation.append(FamilyTreeServiceConstants.GREAT).append(FamilyTreeServiceConstants.separator);
            }
            levelDiff--;
        }
        derivedRelation.append(relationWithMember.getRelationName());
        return derivedRelation.toString();
    }
}
