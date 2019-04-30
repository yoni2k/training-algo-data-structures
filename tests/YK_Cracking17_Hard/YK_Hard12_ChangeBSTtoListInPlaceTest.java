package YK_Cracking17_Hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard12_ChangeBSTtoListInPlaceTest {

    @Test
    void treeWithOneNode() {
        YK_Hard12Util_BiNode origHead = new YK_Hard12Util_BiNode(5);
        YK_Hard12Util_BiNode newHead = new YK_Hard12_ChangeBSTtoListInPlace().getOrderedList(origHead);

        assertEquals(origHead.data, newHead.data);
        assertNull(newHead.node1);
        assertNull(newHead.node2);
    }

    private boolean compareList(YK_Hard12Util_BiNode expHead, YK_Hard12Util_BiNode actHead) {
        if((expHead == null) && (actHead == null)) {
            System.out.println("compare: both null");
            return true;
        } else if ((expHead != null) && (actHead != null)) {
            System.out.println("compare: both not null, expHead: " + expHead + ", actHead: " + actHead);
            if(expHead.data != actHead.data) {
                System.out.println("compare: ERROR: data's don't equal, expHead: " + expHead.data + ", actHead: " + actHead.data);
                return false;
            }
            if((expHead.node1 == null)^(actHead.node1 == null)) {
                System.out.println("compare: ERROR: one of the node1 is null, one not: expHead: " + expHead.node1 + ", actHead: " + actHead.node1);
                return false;
            }
            if((expHead.node1 != null) && (expHead.node1.data != actHead.node1.data)) {
                System.out.println("compare: ERROR: data's of node1 don't equal, expHead: " + expHead.node1.data + ", actHead: " + actHead.node1.data);
                return false;
            }
            if((expHead.node2 == null)^(actHead.node2 == null)) {
                System.out.println("compare: ERROR: one of the node2 is null, one not: expHead: " + expHead.node2 + ", actHead: " + actHead.node2);
                return false;
            }
            if((expHead.node2 != null) && (expHead.node2.data != actHead.node2.data)) {
                System.out.println("compare: ERROR: data's of node2 don't equal, expHead: " + expHead.node2.data + ", actHead: " + actHead.node2.data);
                return false;
            }
            return compareList(expHead.node2, actHead.node2);
        } else {
            System.out.println("one not null, ERROR: expHead: " + expHead + ", actHead: " + actHead);
            return false;
        }
    }

    private YK_Hard12Util_BiNode[] getNodes(int num) {
        YK_Hard12Util_BiNode[] nodes = new YK_Hard12Util_BiNode[num + 1];

        for(int i = 1; i <= num; i++) {
            nodes[i] = new YK_Hard12Util_BiNode(i);
        }

        return nodes;
    }

    private void setLeftRight(YK_Hard12Util_BiNode[] nodes, int ind, int indL, int indR) {
        if(indL != -1) {
            nodes[ind].node1 = nodes[indL];
        }
        if (indR != -1) {
            nodes[ind].node2 = nodes[indR];
        }
    }

    private void connect(YK_Hard12Util_BiNode[] nodes, int indP, int indN) {
        nodes[indP].node2 = nodes[indN];
        nodes[indN].node1 = nodes[indP];
    }

    private void printAllNodes(YK_Hard12Util_BiNode[] nodes) {
        for(YK_Hard12Util_BiNode node : nodes) {
            System.out.println(node);
        }
    }

    @Test
    void fullTree() {
        YK_Hard12Util_BiNode[] nodesOrig = getNodes(7);
        setLeftRight(nodesOrig, 4, 2, 6);
        setLeftRight(nodesOrig, 2, 1, 3);
        setLeftRight(nodesOrig, 6, 5, 7);
        YK_Hard12Util_BiNode origHead = nodesOrig[4];
        System.out.println("Original tree:");
        System.out.println(origHead.fullTreeToString());
        System.out.println("Original nodes:");
        printAllNodes(nodesOrig);

        YK_Hard12Util_BiNode[] nodesExp = getNodes(7);
        connect(nodesExp, 1,2);
        connect(nodesExp, 2,3);
        connect(nodesExp, 3,4);
        connect(nodesExp, 4,5);
        connect(nodesExp, 5,6);
        connect(nodesExp, 6,7);
        YK_Hard12Util_BiNode expHead = nodesExp[1];
        System.out.println("Expected nodes:");
        printAllNodes(nodesExp);

        YK_Hard12Util_BiNode newHead = new YK_Hard12_ChangeBSTtoListInPlace().getOrderedList(origHead);
        System.out.println("Actual head: " + newHead);
        System.out.println("Actual nodes: ");
        printAllNodes(nodesOrig);

        assertTrue(compareList(expHead, newHead));
    }

    @Test
    void partialTree() {
        YK_Hard12Util_BiNode[] nodesOrig = getNodes(9);
        setLeftRight(nodesOrig, 5, 2, 6);
        setLeftRight(nodesOrig, 2, 1, 4);
        setLeftRight(nodesOrig, 6, -1, 8);
        setLeftRight(nodesOrig, 4, 3, -1);
        setLeftRight(nodesOrig, 8, 7, 9);
        YK_Hard12Util_BiNode origHead = nodesOrig[5];
        System.out.println("Original tree:");
        System.out.println(origHead.fullTreeToString());
        System.out.println("Original nodes:");
        printAllNodes(nodesOrig);

        YK_Hard12Util_BiNode[] nodesExp = getNodes(9);
        connect(nodesExp, 1,2);
        connect(nodesExp, 2,3);
        connect(nodesExp, 3,4);
        connect(nodesExp, 4,5);
        connect(nodesExp, 5,6);
        connect(nodesExp, 6,7);
        connect(nodesExp, 7,8);
        connect(nodesExp, 8,9);
        YK_Hard12Util_BiNode expHead = nodesExp[1];
        System.out.println("Expected nodes:");
        printAllNodes(nodesExp);

        YK_Hard12Util_BiNode newHead = new YK_Hard12_ChangeBSTtoListInPlace().getOrderedList(origHead);
        System.out.println("Actual head: " + newHead);
        System.out.println("Actual nodes: ");
        printAllNodes(nodesOrig);

        assertTrue(compareList(expHead, newHead));
    }

}