package problem_3;

import utils.IPrimes;
import utils.PrimesFactory;

// What is the largest prime factor of the number 600851475143 ?
public class Problem3 {

	// use prime factorization to check for largest prime
	public long getLargestPrimeFactor(long number) {
		long result = 0;
		IPrimes p = PrimesFactory.getSieve();
		
		// check the remaining number for larger primes than we already found
		for (long i = 2; i <= number; ++i)
		{
			// clean division and divisor is prime?
			if (p.isPrime(i) && ((number % i) == 0))
			{
				// divide number by "i" since we already established
				// that the division has no remainder and making the number
				// smaller makes large performance improvements
				number = number / i;
				result = i;
			}
		}
		return result;
	}

}
