package YK_Cracking4_TreesGraphs;

import YK_Common.YK_DependencyNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_ProjectsOrderTest {

    private ArrayList<YK_DependencyNode<Integer>> getNodes(int num) {
        ArrayList<YK_DependencyNode<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            nodes.add(new YK_DependencyNode<>(i));
        }

        return nodes;
    }

    @Test
    void exampleFromBook() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(7);

        nodes.get(1).addBlocks(nodes.get(2));
        nodes.get(2).addDependsOn(nodes.get(1));

        nodes.get(3).addBlocks(nodes.get(4));
        nodes.get(4).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(6));
        nodes.get(6).addDependsOn(nodes.get(3));

        nodes.get(4).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(4));

        nodes.get(6).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(6));

        nodes.get(6).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(6));

        nodes.get(5).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(5));

        int[] arrayExpected = {1, 2, 3, 4, 6, 5, 0};
        ArrayList<Integer> listExpected = new ArrayList<>();
        for(int single: arrayExpected) {
            listExpected.add(single);
        }

        assertEquals(listExpected,new YK_ProjectsOrder().getProjectsOrder(nodes));
    }

    @Test
    void exampleFromBookInOneGraph() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(7);

        nodes.get(1).addBlocks(nodes.get(2));
        nodes.get(2).addDependsOn(nodes.get(1));

        nodes.get(3).addBlocks(nodes.get(4));
        nodes.get(4).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(6));
        nodes.get(6).addDependsOn(nodes.get(3));

        nodes.get(4).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(4));

        nodes.get(6).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(6));

        nodes.get(6).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(6));

        nodes.get(5).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(5));

        nodes.get(6).addBlocks(nodes.get(2));
        nodes.get(2).addDependsOn(nodes.get(6));

        int[] arrayExpected = {1, 3, 4, 6, 2, 5, 0};
        ArrayList<Integer> listExpected = new ArrayList<>();
        for(int single: arrayExpected) {
            listExpected.add(single);
        }

        assertEquals(listExpected, new YK_ProjectsOrder().getProjectsOrder(nodes));
    }


    @Test
    void example1Node() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(1);

        int[] arrayExpected = {0};
        ArrayList<Integer> listExpected = new ArrayList<>();
        for(int single: arrayExpected) {
            listExpected.add(single);
        }

        assertEquals(listExpected, new YK_ProjectsOrder().getProjectsOrder(nodes));
    }

    @Test
    void exampleLoopFail() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(2);

        nodes.get(0).addBlocks(nodes.get(1));
        nodes.get(1).addDependsOn(nodes.get(0));

        nodes.get(1).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(1));

        assertNull(new YK_ProjectsOrder().getProjectsOrder(nodes));
    }

    @Test
    void exampleBiggerLoop() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(4);

        nodes.get(0).addBlocks(nodes.get(1));
        nodes.get(1).addDependsOn(nodes.get(0));

        nodes.get(1).addBlocks(nodes.get(2));
        nodes.get(2).addDependsOn(nodes.get(1));

        nodes.get(2).addBlocks(nodes.get(3));
        nodes.get(3).addDependsOn(nodes.get(2));

        nodes.get(3).addBlocks(nodes.get(1));
        nodes.get(1).addDependsOn(nodes.get(3));

        assertNull(new YK_ProjectsOrder().getProjectsOrder(nodes));
    }

    @Test
    void exampleFailSimilarToFromBook() {

        ArrayList<YK_DependencyNode<Integer>> nodes = getNodes(7);

        nodes.get(1).addBlocks(nodes.get(2));
        nodes.get(2).addDependsOn(nodes.get(1));

        nodes.get(3).addBlocks(nodes.get(4));
        nodes.get(4).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(3));

        nodes.get(3).addBlocks(nodes.get(6));
        nodes.get(6).addDependsOn(nodes.get(3));

        nodes.get(4).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(4));

        nodes.get(6).addBlocks(nodes.get(5));
        nodes.get(5).addDependsOn(nodes.get(6));

        nodes.get(6).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(6));

        nodes.get(5).addBlocks(nodes.get(0));
        nodes.get(0).addDependsOn(nodes.get(5));

        //Addition
        nodes.get(0).addBlocks(nodes.get(4));
        nodes.get(4).addDependsOn(nodes.get(0));

        assertNull(new YK_ProjectsOrder().getProjectsOrder(nodes));
    }



}