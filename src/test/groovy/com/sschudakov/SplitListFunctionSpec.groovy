package com.sschudakov

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author sergii.chudakov
 */
class SplitListFunctionSpec extends Specification {

    SplitListFunction splitListFunction = new SplitListFunction()

    def "splitNodesToOddAndEvenReversed() should split list in reversed order"() {

        given:
        def list = new Node<>('1', new Node<>('2', new Node<>('3', new Node<>('4'))))

        when:
        def result = splitListFunction.splitNodesToOddAndEvenReversed(list)

        then:
        result.size() == 2
        result[0] == new Node<>('3', new Node<>('1'))
        result[1] == new Node<>('4', new Node<>('2'))


    }

    @Unroll
    def "splitNodesToOddAndEvenReversed() should return expected result for various inputs"() {
        expect: 'assign return value to result'
        def result = splitListFunction.splitNodesToOddAndEvenReversed(listToTest)

        and: 'result array of expected size'
        result.size() == 2

        and: 'result elements should equal to expected values'
        result[0] == oddElementsReversed
        result[1] == evenElementsReversed

        where:
        listToTest << [
                null,
                new Node(),
                new Node<>('1'),
                new Node<>('1', new Node<>('2')),
                new Node<>('1', new Node<>('2', new Node('3'))),
                new Node<>('1', new Node<>('2', new Node('3', new Node('4')))),
                new Node<>('1', new Node<>('2', new Node('3', new Node('4', new Node('5'))))),
                new Node<>('1', new Node<>('2', new Node('3', new Node('4', new Node('5', new Node('6')))))),
                new Node<>('1', new Node<>('2', new Node('3', new Node('4', new Node('5', new Node('6', new Node('7'))))))),
                new Node<>('1', new Node<>('2', new Node('3', new Node('4', new Node('5', new Node('6', new Node('7', new Node('8'))))))))

        ]

        oddElementsReversed << [
                null,
                new Node(),
                new Node<>('1'),
                new Node<>('1'),
                new Node<>('3', new Node<>('1')),
                new Node<>('3', new Node<>('1')),
                new Node<>('5', new Node<>('3', new Node<>('1'))),
                new Node<>('5', new Node<>('3', new Node<>('1'))),
                new Node<>('7', new Node<>('5', new Node<>('3', new Node<>('1')))),
                new Node<>('7', new Node<>('5', new Node<>('3', new Node<>('1'))))
        ]

        evenElementsReversed << [
                null,
                null,
                null,
                new Node<>('2'),
                new Node<>('2'),
                new Node<>('4', new Node<>('2')),
                new Node<>('4', new Node<>('2')),
                new Node<>('6', new Node<>('4', new Node<>('2'))),
                new Node<>('6', new Node<>('4', new Node<>('2'))),
                new Node<>('8', new Node<>('6', new Node<>('4', new Node<>('2'))))
        ]
    }

}