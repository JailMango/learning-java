package core.basic.chapter09.组合模式;

import java.util.Enumeration;
import java.util.Vector;

import lombok.ToString;

/**
 * TreeNode
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.组合模式
 * @since R9.0
 */
@ToString
public class TreeNode {

    /**
     * Name
     */
    private String name;

    /**
     * Parent
     */
    private TreeNode parent;

    /**
     * Children
     */
    private Vector<TreeNode> children = new Vector<>();

    /**
     * Constructor
     * 
     * @param name String
     */
    public TreeNode(String name) {
        this.name = name;
    }

    public void add(TreeNode node) {
        children.add(node);
    }

    public void remove(TreeNode node) {
        children.remove(node);
    }

    public Enumeration<TreeNode> getChildren() {
        return this.children.elements();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
