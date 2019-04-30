package YK_Cracking17_Hard;

public class YK_Hard12Util_BiNode {
    public YK_Hard12Util_BiNode node1;
    public YK_Hard12Util_BiNode node2;
    public int data;

    public YK_Hard12Util_BiNode(int data) {
        this.data = data;
        this.node1 = null;
        this.node2 = null;
    }

    public YK_Hard12Util_BiNode(int data, YK_Hard12Util_BiNode node1, YK_Hard12Util_BiNode node2) {
        this.data = data;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "[data:  " + data + ", node1: " + ((node1 != null) ? node1.data : "-") + ", node2: " + ((node2 != null) ? node2.data : "-") + "]";
    }

    public String fullTreeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        if(node1 != null) {
            sb.append('\n');
            sb.append(node1.fullTreeToString());
        }
        if(node2 != null) {
            sb.append('\n');
            sb.append(node2.fullTreeToString());
        }
        return sb.toString();
    }
}
