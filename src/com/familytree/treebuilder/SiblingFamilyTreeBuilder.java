package com.familytree.treebuilder;

import com.familytree.constants.FamilyTreeServiceConstants;
import com.familytree.constants.RelationName;
import com.familytree.dao.FamilyTreeDAO;
import com.familytree.dataobjects.FamilyMember;
import com.familytree.dataobjects.FamilyTreeNode;
import com.familytree.dataobjects.Person;
import com.familytree.exception.DataUnavailableException;
import com.familytree.exception.InvalidInputException;

import java.util.*;

public class SiblingFamilyTreeBuilder implements FamilyTreeBuilder{

    private FamilyTreeDAO familyTreeDAO;

    public SiblingFamilyTreeBuilder(FamilyTreeDAO familyTreeDAO){
        this.familyTreeDAO = familyTreeDAO;
    }

    @Override
    public FamilyTreeNode buildFamilyTree(String personId, int level) throws DataUnavailableException, InvalidInputException {
        if(personId == null || personId.isEmpty()){
            //throw exception
            return null;
        }
        final FamilyTreeNode root = new FamilyTreeNode();
        root.setFamilyMemberName(FamilyTreeServiceConstants.SIBLINGS);
        Person firstPerson = familyTreeDAO.getPerson(personId);
        final List<FamilyTreeNode> siblings = new LinkedList<>();
        final FamilyTreeNode firstPersonNode = new FamilyTreeNode();
        firstPersonNode.setFamilyMemberName(firstPerson.getName());
        siblings.add(firstPersonNode);
        final Queue<String> familyMembers = new LinkedList<>();
        familyMembers.offer(firstPerson.getPersonId());
        int currentLevel = 1;

        while(!familyMembers.isEmpty()){
            int levelCount = familyMembers.size();
            while(levelCount-- > 0){
                final String currentFamilyMember = familyMembers.poll();
                final List<FamilyMember> immediateFamilyMembers = familyTreeDAO.getImmediateFamilyMembers(currentFamilyMember);
                for(FamilyMember familyMember : immediateFamilyMembers){
                    final RelationName relationWithMember = familyMember.getRelationWithMember().getRelationName();
                    if(relationWithMember.equals(RelationName.SIBLING)){
                        if(currentLevel == 1){
                            final FamilyTreeNode siblingNode = new FamilyTreeNode();
                            siblingNode.setFamilyMemberName(familyMember.getMember().getName());
                            siblings.add(siblingNode);
                        } else{
                            fetchSiblings(familyMember.getMember(), currentLevel, siblings);
                        }
                    } else if(relationWithMember.equals(RelationName.MOTHER) || relationWithMember.equals(RelationName.FATHER)){
                        familyMembers.offer(familyMember.getMember().getPersonId());
                    }
                }
            }
            currentLevel++;
        }

        root.setRelatedFamilyMembers(siblings);
        return root;
    }

    private void fetchSiblings(final Person person, int currentLevel, final  List<FamilyTreeNode> siblings) {
        final Queue<String> familyMembers = new LinkedList<>();
        familyMembers.offer(person.getPersonId());

        while(!familyMembers.isEmpty() && currentLevel>0){
            int levelCount = familyMembers.size();
            currentLevel--;
            while(levelCount-- > 0){
                String currentFamilyMember = familyMembers.poll();
                final List<FamilyMember> immediateFamilyMembers = familyTreeDAO.getImmediateFamilyMembers(currentFamilyMember);
                for(FamilyMember familyMember : immediateFamilyMembers){
                    final RelationName relationWithMember = familyMember.getRelationWithMember().getRelationName();
                   if(relationWithMember.equals(RelationName.SON) || relationWithMember.equals(RelationName.DAUGHTER)){
                       if(currentLevel == 1){
                           final FamilyTreeNode siblingNode = new FamilyTreeNode();
                           siblingNode.setFamilyMemberName(familyMember.getMember().getName());
                           siblings.add(siblingNode);
                       } else{
                           familyMembers.offer(familyMember.getMember().getPersonId());
                       }
                    }
                }
            }
        }
    }
}
