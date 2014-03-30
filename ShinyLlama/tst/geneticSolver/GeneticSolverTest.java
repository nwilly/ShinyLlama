package geneticSolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeneticSolverTest {
	private GeneticSolver geneticSolver;

	private final int defaultGenerationLimit = 10;
	private final double defaultMutationRate = 0.05;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		geneticSolver = new GeneticSolver(defaultMutationRate, defaultGenerationLimit);
	}

	// construct tests

	@Test
	public void GIVEN_negativeMutationRate_WHEN_construct_THEN_exception() {
		// GIVEN
		double mutationRate = -1;
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("The mutation rate must be between 0 and 1.");

		// WHEN
		geneticSolver = new GeneticSolver(mutationRate, defaultGenerationLimit);

		// THEN: exception
	}

	@Test
	public void GIVEN_largeMutationRate_WHEN_construct_THEN_exception() {
		// GIVEN
		double mutationRate = 10;
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("The mutation rate must be between 0 and 1.");

		// WHEN
		geneticSolver = new GeneticSolver(mutationRate, defaultGenerationLimit);

		// THEN: exception
	}

	// procreate tests

	@Test
	public void GIVEN_mutationRateIsZero_WHEN_procreate_THEN_returnProperChild() {
		// GIVEN
		int[] parentOne = new int[10];
		int[] parentTwo = new int[10];
		for (int i = 0; i < parentOne.length; i++) {
			parentOne[i] = i;
			parentTwo[i] = 10 - i;
		}

		// WHEN
		geneticSolver = new GeneticSolver(0, defaultGenerationLimit);
		int[] child = geneticSolver.procreate(parentOne, parentTwo, -5, 10);

		// THEN
		assertEquals(parentOne.length, child.length);
		for (int i = 0; i < child.length; i++) {
			// This isn't a very good way to do this test, but I'm not sure of a better one atm
			if (child[i] != parentOne[i] || child[i] != parentTwo[i]) {
				fail("The child should not have mutated.");
			}
		}
	}

	// score tests

	@Test
	public void GIVEN_individual_WHEN_score_THEN_returnScore() {
		// GIVEN
		int expectedScore = 10;
		int[] individual = new int[10];
		for (int i = 0; i < individual.length; i++) {
			individual[i] = i;
		}

		// WHEN
		int actualScore = geneticSolver.score(individual);

		// THEN
		assertEquals(expectedScore, actualScore);
	}

	// survivalStage tests

	@Test
	public void GIVEN_validInputs_WHEN_survivalStage_THEN_returnValidList() {
		// TODO
	}

	// createNewGeneration tests
	// TODO
}
