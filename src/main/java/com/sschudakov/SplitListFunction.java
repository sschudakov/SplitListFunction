package com.sschudakov;

/**
 * Class containing split function for one-way-linked lists.
 *
 * @author sergii.chudakov
 *
 */
public class SplitListFunction {

    public SplitListFunction() {
        // intentionally left blank
    }

    /**
     * Splits input one-way-linked list into two sub-lists.
     * First contains only odd elements from input list, second - only even.
     * Order of elements in result lists is reversed compared to the order from input list.
     *
     * @param head
     *          point to the first element of input list.
     *
     * @return
     *      array containing two elements - list of odd and list of even elements from input list in reversed order.
     *      If 'head' is {@code null}, then {@code Node[] { null, null }} returned.
     *      If 'head' is the only element, then {@code Node[] { head, null }} returned.
     */
    public <T> Node[] splitNodesToOddAndEvenReversed(Node<T> head) throws NullPointerException {
        if (head == null) {
            return new Node[] { null, null };
        }

        // create a copy of linked list, so original list remains unchanged:
        Node<T> currentNode = head.getCopy();

        // init two result lists: first (containing odd elements) and second (containing even elements)
        Node<T> first = null;
        Node<T> second = null;

        for (int i = 1; currentNode != null; i++) {

            if (i % 2 == 1) {
                // for i % 2 == 1 -> put nodes to first list;
                Node<T> prevFirst = first;
                first = currentNode;
                currentNode = currentNode.getNext();
                first.setNext(prevFirst);

            } else {
                // for i % 2 == 0 -> put nodes to second list;
                Node<T> prevSecond = second;
                second = currentNode;
                currentNode = currentNode.getNext();
                second.setNext(prevSecond);
            }
        }

        return new Node[] { first, second };
    }
}
