package problem_11;

//08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
//49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
//81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
//52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
//22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
//24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
//32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
//67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
//24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
//21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
//78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
//16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
//86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
//19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
//04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
//88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
//04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
//20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
//20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
//01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
//What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 20�20 grid?
public class Problem11 {

	int[][] _source;
	
	public Problem11()
	{
		// hard coded number grid
		// for the next project it would be good to have some sort of file reader
		_source = new int[20][20];
		_source[0] = new int[] { 8, 2,22,97,38,15, 0,40, 0,75, 4, 5, 7,78,52,12,50,77,91, 8};
		_source[1] = new int[] {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48, 4,56,62, 0};
		_source[2] = new int[] {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30, 3,49,13,36,65};
		_source[3] = new int[] {52,70,95,23, 4,60,11,42,69,24,68,56, 1,32,56,71,37, 2,36,91};
		_source[4] = new int[] {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80};
		_source[5] = new int[] {24,47,32,60,99, 3,45, 2,44,75,33,53,78,36,84,20,35,17,12,50};
		_source[6] = new int[] {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70};
		_source[7] = new int[] {67,26,20,68, 2,62,12,20,95,63,94,39,63, 8,40,91,66,49,94,21};
		_source[8] = new int[] {24,55,58, 5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72};
		_source[9] = new int[] {21,36,23, 9,75, 0,76,44,20,45,35,14, 0,61,33,97,34,31,33,95};
		_source[10] = new int[]{78,17,53,28,22,75,31,67,15,94, 3,80, 4,62,16,14, 9,53,56,92};
		_source[11] = new int[]{16,39, 5,42,96,35,31,47,55,58,88,24, 0,17,54,24,36,29,85,57};
		_source[12] = new int[]{86,56, 0,48,35,71,89, 7, 5,44,44,37,44,60,21,58,51,54,17,58};
		_source[13] = new int[]{19,80,81,68, 5,94,47,69,28,73,92,13,86,52,17,77, 4,89,55,40};
		_source[14] = new int[]{ 4,52, 8,83,97,35,99,16, 7,97,57,32,16,26,26,79,33,27,98,66};
		_source[15] = new int[]{88,36,68,87,57,62,20,72, 3,46,33,67,46,55,12,32,63,93,53,69};
		_source[16] = new int[]{ 4,42,16,73,38,25,39,11,24,94,72,18, 8,46,29,32,40,62,76,36};
		_source[17] = new int[]{20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74, 4,36,16};
		_source[18] = new int[]{20,73,35,29,78,31,90, 1,74,31,49,71,48,86,81,16,23,57, 5,54};
		_source[19] = new int[]{ 1,70,54,71,83,51,54,69,16,92,33,48,61,43,52, 1,89,19,67,48};
	}
	
	// check the right side of the specified coordinates
	private long checkRight(int x, int y)
	{
		int i1, i2, i3, i4;
		
		// check for out of bounds - to make the outer loop easier just return 0 and no error
		if (y < 0 || y > 19)
			return 0;
		
		if (x < 0 || x > 16)
			return 0;
		
		// get the cells
		i1 = _source[y][x];
		i2 = _source[y][x + 1];
		i3 = _source[y][x + 2];
		i4 = _source[y][x + 3];
		// return the result
		return i1*i2*i3*i4;
	}

	// check downside of the specified coordinates
	private long checkDown(int x, int y)
	{
		int i1, i2, i3, i4;

		if (y < 0 || y > 16)
			return 0;
		
		if (x < 0 || x > 19)
			return 0;
		i1 = _source[y][x];
		i2 = _source[y + 1][x];
		i3 = _source[y + 2][x];
		i4 = _source[y + 3][x];
		return i1*i2*i3*i4;
	}

	// check right diagonal of the specified coordinates
	private long checkDiag(int x, int y)
	{
		int i1, i2, i3, i4;

		if (y < 0 || y > 16)
			return 0;
		
		if (x < 0 || x > 16)
			return 0;
		i1 = _source[y][x];
		i2 = _source[y + 1][x + 1];
		i3 = _source[y + 2][x + 2];
		i4 = _source[y + 3][x + 3];
		return i1*i2*i3*i4;
	}

	// check left diagonal of the specified coordinates
	private long checkDiag2(int x, int y)
	{
		int i1, i2, i3, i4;

		if (y < 0 || y > 16)
			return 0;
		
		if (x < 3 || x > 19)
			return 0;
		i1 = _source[y][x];
		i2 = _source[y + 1][x - 1];
		i3 = _source[y + 2][x - 2];
		i4 = _source[y + 3][x - 3];
		return i1*i2*i3*i4;
	}
	
	// iterate through the grid for the answer
	public long getResult() {
		long result = 0, temp = 0;
		
		// just go through the whole grid, the check functions are very error resistant
		// ideas for optimizing: pack the functions in some kind of array, see reflection?
		for (int x = 0; x < 20; ++x)
		{
			for (int y = 0; y < 20; ++y)
			{
				temp = checkRight(x, y);
				if (temp > result)
					result = temp;
				temp = checkDown(x, y);
				if (temp > result)
					result = temp;
				temp = checkDiag(x, y);
				if (temp > result)
					result = temp;
				temp = checkDiag2(x, y);
				if (temp > result)
					result = temp;
			}
		}
		return result;
	}

}
