import spock.lang.Specification

/**
 * Created on 17/05/2017.
 */
class MyTest extends Specification {
    def "my test"() {
        given:
          List<Integer> list = new ArrayList<>()
        when:
            list.add(1)
        then:
            2 == list.get(0)
    }
}
