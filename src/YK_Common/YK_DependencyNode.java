package YK_Common;

import java.util.ArrayList;

public class YK_DependencyNode<E> {

    E value;
    ArrayList<YK_DependencyNode<E>> dependsOn;
    ArrayList<YK_DependencyNode<E>> blocks;

    public YK_DependencyNode(E value) {
        this.value = value;
        dependsOn = new ArrayList<>();
        blocks = new ArrayList<>();
    }

    public E getValue() { return value;}
    public void setValue(E value) { this.value = value;}

    public void addDependsOn(YK_DependencyNode<E> addDependsOn) {
        dependsOn.add(addDependsOn);
    }

    public void addBlocks(YK_DependencyNode<E> addBlocks) {
        blocks.add(addBlocks);
    }

    public void removeDependsOn(YK_DependencyNode<E> removeDependsOn) {
        dependsOn.remove(removeDependsOn);
    }

    public void removeItselfAsDepedency() {
        System.out.println("Visiting node: " + value);
        for(YK_DependencyNode<E> nodeBlocked : blocks) {
            System.out.println("Removing node: " + value + " as blocking node: " + nodeBlocked.value);
            nodeBlocked.removeDependsOn(this);//the important line
        }
        blocks.clear();//not needed for the algorithm, just for the debugging
    }

    public boolean noDependsOn() { return (dependsOn.isEmpty()); }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Value: ");
        sb.append(value);

        sb.append(", DependsOn: ");
        for(YK_DependencyNode<E> node : dependsOn) {
            sb.append(node.toStringValue());
            sb.append(' ');
        }

        sb.append(", Blocks: ");
        for(YK_DependencyNode<E> node : blocks) {
            sb.append(node.toStringValue());
            sb.append(' ');
        }

        return sb.toString();
    }

    public String toStringValue() { return value.toString(); }
}
