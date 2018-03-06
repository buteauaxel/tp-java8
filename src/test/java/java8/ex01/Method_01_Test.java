package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode int sumAge
        default int age(){
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
        	int ageTotal = 0;
        	for (Person p: findAll() ){
        		ageTotal += p.getAge();      		
        	}
        	return ageTotal;
        	
        }
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        IDao daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoA.age();

        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        IDao daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoB.age();

        assert result == 5050;

    }
}
