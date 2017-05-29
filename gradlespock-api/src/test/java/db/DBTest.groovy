package db

import com.mga.repository.PersonRepository
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.Specification
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by slah on 23/05/2017.
 */
class DBTest extends Specification{
    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    @Autowired
    PersonRepository personRepository;


    // insert data (usually the database would already contain the data)
    def setupSpec() {
        sql.execute('create table PERSON (id int auto_increment PRIMARY KEY NOT NULL , ' +
                'firstname VARCHAR(100),' +
                'lastname VARCHAR(100))' );

        sql.execute("insert into PERSON(firstname, lastname) values ('f1', 'n1'),('f2', 'n3') " );
    }

    //TODO(MGA) :change the name
    def "maximum of two numbers"() {
        expect:
        a.contains("f")

        where:
        [a, b] << sql.rows("select firstname, lastname from person")
    }

    def "test repo data with h2 db"() {
        expect:
            findAll {}.size() > 0;

        where:
            personRepository.findAll();
    }
}
