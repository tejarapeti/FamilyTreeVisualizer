package com.familytree.util;

import com.familytree.dataobjects.FamilyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FamilyTreeCommonUtil {

    public void printFamilyTreeLevelOrder(final FamilyTreeNode root){
        if(root == null ) return;
        final Queue<FamilyTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNodeCount = queue.size();
            while(levelNodeCount-- > 0){
                final FamilyTreeNode currentNode = queue.poll();
                System.out.print(currentNode.toString() + "\t");
                for(FamilyTreeNode childNode : currentNode.getRelatedFamilyMembers()){
                    if(childNode != null){
                        queue.offer(childNode);
                    }
                }
            }
            System.out.println();
        }
    }
}
