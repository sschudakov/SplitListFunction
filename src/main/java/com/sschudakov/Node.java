package com.sschudakov;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class represents single node of one-way-linked list.
 *
 * @param <T>
 *     parameter type to be stored in each node of a list.
 *
 * @author sergii.chudakov
 */
class Node<T> {

    private T value;
    private Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * Makes independent deep copy of current list.
     * Any changes made to produced copy would not affect the original list.
     *
     * @return
     *      deep copy of current list.
     */
    public Node<T> getCopy() {
        // 'this' is not null, so init new head node of list it contains:
        Node<T> headCopy = new Node<>();
        headCopy.setValue(this.getValue());

        // store 'next original node' and 'current copy node' values for iteration:
        Node<T> nextOriginalNode = this.getNext();
        Node<T> currentCopyNode = headCopy;

        // iterate over list and create new node with same value
        // for each next node of original list:
        while (nextOriginalNode != null) {
            Node<T> nextCopyNode = new Node<>(nextOriginalNode.getValue());
            currentCopyNode.setNext(nextCopyNode);
            currentCopyNode = nextCopyNode;
            nextOriginalNode = nextOriginalNode.getNext();
        }

        return headCopy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("next", next)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Node<?> node = (Node<?>) o;

        return new EqualsBuilder()
                .append(value, node.value)
                .append(next, node.next)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .append(next)
                .toHashCode();
    }
}
