package utils;

class PrimesAtkins implements IPrimes {
	//private ArrayList<Long> _primes;
	private int _limit;
	private boolean _primes[];
	
	public PrimesAtkins(int limit)
	{
		_limit = 0;
		if (limit > (Integer.MAX_VALUE - 1))
			return;
		_limit = limit;
		_primes = new boolean[_limit + 1];
		FindPrimes();
	}
	
	@Override
	public boolean isPrime(long val)
	{
		if (val > _limit)
			return false;
		if (val < 2)
			return false;
		return _primes[(int)val];
	}
	
	@Override
	public long generatePrime(long val) throws Exception
	{
		for (int n = (int)(val + 1); n <= _limit; ++n)
		{
			if (_primes[n])
				return n;
		}
		throw new Exception("out of bounds");
	}
	
	private void FindPrimes()
	{
		int upperLimit = (int)Math.sqrt(_limit);
		
		_primes[2] = true;
		_primes[3] = true;

		for (int x = 1; x <= upperLimit; x++)
		{
			int xx = x*x;

			for (int y = 1; y <= upperLimit; y++)
			{
				int yy = y*y;
				
				int n = (int) (4 * xx + yy);
				if (n <= _limit && (n % 12 == 1 || n % 12 == 5))
					_primes[n] ^= true;
				n = (int) (3 * xx + yy);
				if (n <= _limit && n % 12 == 7)
					_primes[n] ^= true;
				n = (int) (3 * xx - yy);
				if (x > y && n <= _limit && n % 12 == 11)
					_primes[n] ^= true;
			}
		}
		for (int n = 5; n <= upperLimit; n+=2)
		{
			if (_primes[n])
			{
				int s = n * n;
				for (int k = s; k <= _limit; k += s)
					_primes[k] = false;
			}
		}
	}

	@Override
	public long generatePreviousPrime(long start) throws Exception {
		if (start > _limit)
			throw new Exception("start value out of bounds");
		for (int n = (int)(start - 1); n >= 2; --n)
			if (_primes[n])
				return n;
		throw new Exception("no prime less than 2");
	}
}
