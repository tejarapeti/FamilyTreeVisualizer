package com.familytree.service;

import com.familytree.constants.FamilyTreeType;
import com.familytree.constants.TreeVisualizationFormat;
import com.familytree.dao.FamilyTreeDAOImpl;
import com.familytree.dataobjects.FamilyTreeVisualizerRequest;
import com.familytree.dataobjects.FamilyTreeVisualizerResponse;
import com.familytree.exception.InvalidInputException;
import com.familytree.facade.FamilyTreeGenerationManager;
import com.familytree.factory.FamilyTreeBuilderFactory;
import com.familytree.factory.FamilyTreeVisualizerFactory;
import com.familytree.treebuilder.FamilyTreeBuilder;
import com.familytree.visualizer.FamilyTreeVisualizer;

public class FamilyTreeServiceImpl implements FamilyTreeService {

    @Override
    public FamilyTreeVisualizerResponse getFamilyTree(FamilyTreeVisualizerRequest request) throws InvalidInputException{
        validate(request);
        final FamilyTreeBuilder familyTreeBuilder = FamilyTreeBuilderFactory.getInstance(request.getTreeType(), new FamilyTreeDAOImpl());
        final FamilyTreeVisualizer familyTreeVisualizer = FamilyTreeVisualizerFactory.getInstance(request.getVisualizationFormat());

        final FamilyTreeGenerationManager familyTreeGenerationManager = new FamilyTreeGenerationManager(familyTreeBuilder,familyTreeVisualizer);
        final String resultantView = familyTreeGenerationManager.getFamilyTreeVisualization(request.getPersonId(),request.getLevel());

        final FamilyTreeVisualizerResponse response = new FamilyTreeVisualizerResponse();
        response.setVisualizationFormat(request.getVisualizationFormat());
        response.setResultantView(resultantView);
        return response;
    }

    private void validate(final FamilyTreeVisualizerRequest request) throws InvalidInputException {
        if(request == null){
            throw new InvalidInputException("request object cannot be null");
        }
        if(request.getPersonId() == null || request.getPersonId().length() == 0){
            throw new InvalidInputException("personId cannot be null or empty");
        }
        if(request.getLevel() <= 0){
            throw new InvalidInputException("level has to be a positive non-zero integer");
        }
        if(request.getTreeType() == null){
            throw new InvalidInputException("tree type cannot be null");
        }
        if(request.getVisualizationFormat() == null){
            throw new InvalidInputException("visualization format cannot be null");
        }
    }

    public static void main(String[] args) {
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
    }
}
