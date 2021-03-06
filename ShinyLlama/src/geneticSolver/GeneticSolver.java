package geneticSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticSolver {

	private final double mutationRate;
	private final int generationLimit;

	public GeneticSolver(
			final double mutationRate,
			final int generationLimit
	) {
		if (mutationRate > 1 || mutationRate < 0) {
			throw new IllegalArgumentException("The mutation rate must be between 0 and 1.");
		}
		this.mutationRate = mutationRate;
		this.generationLimit = generationLimit;
	}

	public int[] evolve(List<int[]> currentGeneration) {
		int length = currentGeneration.get(0).length;
		for (int i = 1; i < currentGeneration.size(); i++) {
			if (currentGeneration.get(i).length != length) {
				throw new IllegalArgumentException("All inputs must have the same length.");
			}
		}
		
		List<int[]> newGeneration = new ArrayList<int[]>();
		List<int[]> tempGen;
		for (int i = 1; i < generationLimit; i++) {
			tempGen = newGeneration;
			newGeneration = createNewGeneration(currentGeneration);
			currentGeneration = tempGen;
		}
		return survivalStage(newGeneration, 1).get(0);
	}

	/**
	 * Given a generation, create the full set of children
	 */
	List<int[]> createNewGeneration(List<int[]> generation) {
		return null;
	}

	/**
	 * Given a generation, reduce it to the best individuals in descending order
	 *
	 * @param numSurvivors The number of surviving individuals to return from the
	 * generation.  This cannot be less than or equal to 0.
	 */
	List<int[]> survivalStage(List<int[]> generation, int numSurvivors) {
		return null;
	}
}
