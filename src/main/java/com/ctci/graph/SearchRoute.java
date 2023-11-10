package com.ctci.graph;

import java.util.LinkedList;

public class SearchRoute {
    public static boolean searchRoute(GraphNode source, GraphNode dest){
        if(source == dest){
            return true;
        }
        LinkedList<GraphNode> q = new LinkedList<>();
        source.state=State.Visiting;
        q.add(source);
        GraphNode node;
        while(!q.isEmpty()){
            node = q.removeFirst();
            if(node!=null){
                for(GraphNode adjNode: node.adjacents){
                    if(adjNode.state==State.UnVisited){
                        if(adjNode==dest){
                            return true;
                        }else{
                            adjNode.state=State.Visiting;
                            q.add(adjNode);
                        }
                    }
                }
                node.state=State.Visited;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);

        n1.adjacents.add(n2);
        n1.adjacents.add(n3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        n2.adjacents.add(n4);
        n2.adjacents.add(n5);

        GraphNode n6 = new GraphNode(6);

        System.out.println(searchRoute(n1,n5));

    }
}
