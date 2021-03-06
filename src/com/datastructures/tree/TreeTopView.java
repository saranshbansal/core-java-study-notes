package com.datastructures.tree;

import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

// Class to store all Nodes with their normalized levels.
class NodePack
{
    Node node;
    int lvl;


    NodePack(Node node, int lvl)
    {
        this.node = node;
        this.lvl = lvl;
    }
}


//Java program to print top view of binary tree
public class TreeTopView
{

    Node root;


    public TreeTopView()
    {
        root = null;
    }


    // function should print the topView of 
    // the binary tree 
    private void topView(Node root)
    {
        Queue<NodePack> q = new LinkedList<>();
        // map to compare levels and store output
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        if (root == null)
        {
            return;
        }
        // Add root node to queue (if any) as it obviously comes in top view
        q.add(new NodePack(root, 0));

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container 
        // contains an element whose key is equivalent 
        // to lvl, or returns zero otherwise. 
        while (!q.isEmpty())
        {
            // remove the nodepack from queue.
            NodePack thisNodePack = q.poll();

            // store nodes at unique normalized levels to our top view map.
            if (!topViewMap.containsKey(thisNodePack.lvl))
            {
                topViewMap.put(thisNodePack.lvl, thisNodePack.node);
            }

            if (thisNodePack.node.left != null)
            {
                q.add(new NodePack(thisNodePack.node.left, thisNodePack.lvl - 1));
            }
            if (thisNodePack.node.right != null)
            {
                q.add(new NodePack(thisNodePack.node.right, thisNodePack.lvl + 1));
            }

        }
        for (Entry<Integer, Node> entry : topViewMap.entrySet())
        {
            System.out.print(entry.getValue().key);
        }
    }


    // Driver Program to test above functions 
    public static void main(String[] args)
    {
        /* Create following Binary Tree 
         1 
        / \ 
        2 3 
        \ 
         4 
         \ 
         5 
         \ 
             6*/
        TreeTopView tree = new TreeTopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root);
    }

}
