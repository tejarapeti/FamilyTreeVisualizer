package com.familytree.service;

import com.familytree.dataobjects.FamilyTreeVisualizerRequest;
import com.familytree.dataobjects.FamilyTreeVisualizerResponse;
import com.familytree.exception.InvalidInputException;

public interface FamilyTreeService {

    FamilyTreeVisualizerResponse getFamilyTree(FamilyTreeVisualizerRequest request) throws InvalidInputException;

}
