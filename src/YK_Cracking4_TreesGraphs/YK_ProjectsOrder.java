package YK_Cracking4_TreesGraphs;

import YK_Common.YK_DependencyNode;

import java.util.ArrayList;

/*
Source: Cracking p.110 exercise 4.7

Given "projects" and dependencies between projects (which projects depends on which), build an algorithm
to find order of projects, or say that there is no way order (loop dependencies).

My implementation is a bit more elegant than the solution in the book.  It's not technically necessary to keep who depends on me,
just a number of such dependencies, but keeping this information as I need is more elegant and easier to debug.

In the book there is another solution also with DFS that also looks good.

Added YK_DependencyNode that does part of the work, but is also a bidirectional tree (with direction mattering).
 */

public class YK_ProjectsOrder {

    public ArrayList<Integer> getProjectsOrder(ArrayList<YK_DependencyNode<Integer>> nodes) {

        boolean bAddedToBuild = true;
        ArrayList<YK_DependencyNode<Integer>> nodesNotDone = new ArrayList<>(nodes);

        System.out.println("---------------------------------------------");
        System.out.println("Start getProjectsOrder, got nodes:");
        for(YK_DependencyNode<Integer> node: nodesNotDone) {
            System.out.println(node.toString());
        }
        System.out.println("=============================================");

        ArrayList<Integer> projectsOrder = new ArrayList<>();

        while((nodesNotDone.size() > 0) && bAddedToBuild) {

            System.out.println("Starting a pass, number of nodes left: " + nodesNotDone.size());

            bAddedToBuild = false;

            //Needed since need to remove as part of the code, Java doesn't allow nodesNotDone.remove(node) as part of for loop
            ArrayList<YK_DependencyNode<Integer>> nodesNotDoneTemp = new ArrayList<>(nodesNotDone);

            for(YK_DependencyNode<Integer> node: nodesNotDoneTemp) {
                if(node.noDependsOn()) {
                    System.out.println("Adding to project order node: " + node.getValue());
                    node.removeItselfAsDepedency();
                    projectsOrder.add(node.getValue());
                    nodesNotDone.remove(node);
                    bAddedToBuild = true;
                }
            }
        }

        if (bAddedToBuild == false) {
            System.out.println("End getProjectsOrder, didn't find a way to do all projects, projects still not done: ");
            for(YK_DependencyNode<Integer> node: nodesNotDone) {
                System.out.println(node.toString());
            }
            return null;
        }

        System.out.println("---------------------------------------------");
        System.out.println("End getProjectsOrder, got nodes:");
        for(YK_DependencyNode<Integer> node: nodes) {
            System.out.println(node.toString());
        }
        System.out.println("Project order: " + projectsOrder.toString());
        System.out.println("=============================================");

        return projectsOrder;
    }
}
