package com.example.tree;

import com.google.gson.Gson;
import org.assertj.core.util.Lists;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node dennis = new Node(1, 0, "dennis");
        Node calm = new Node(2, 0, "calm");
        Node daughter = new Node(3, 1, "daughter");
        Node grandson = new Node(4, 3, "grandson");
        Node son = new Node(5, 2, "son");
        List<Node> nodes = Lists.newArrayList(dennis, calm, daughter, son, grandson);
        List<Node> tree = TreeUtil.buildTree(nodes);

        Gson g=new  Gson();

        System.out.println(g.toJson(tree));
    }
}