package com.sschudakov

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author sergii.chudakov
 */
class NodeSpec extends Specification {

    def "getCopy() should return copy of given list by its head node"() {
        given:
        def list = new Node<>('1', new Node<>('2', new Node<>('3', new Node<>('4', new Node<>('5')))))

        when:
        def result = list.getCopy()

        then:
        result == list
    }

    def "getCopy() should return independent deep copy of linked list by given head node"() {
        given:
        def list = new Node<>('1', new Node<>('2', new Node<>('3', new Node<>('4', new Node<>('5')))))
        def listToCompare = new Node<>('1', new Node<>('2', new Node<>('3', new Node<>('4', new Node<>('5')))))

        when: 'copy list'
        def result = list.getCopy()

        and: 'make changes to result copy'
        result.getNext().setNext(null)

        then: 'expect result copy does not equal to original list'
        result != list

        and: 'original list should remain unchanged'
        list == listToCompare
    }

    @Unroll
    def "getCopy() should return expected results for various inputs"() {
        expect:
        list.getCopy() == result

        where:
        list                                              || result
        new Node()                                        || new Node()
        new Node<>('1')                                   || new Node<>('1')
        new Node<>('1', new Node<>('2'))                  || new Node<>('1', new Node<>('2'))
        new Node<>('1', new Node<>('2', new Node<>('3'))) || new Node<>('1', new Node<>('2', new Node<>('3')))
        new Node<>(1)                                     || new Node<>(1)
        new Node<>(1, new Node<>(2))                      || new Node<>(1, new Node<>(2))
        new Node<>(1, new Node<>(2, new Node<>(3)))       || new Node<>(1, new Node<>(2, new Node<>(3)))
    }

}