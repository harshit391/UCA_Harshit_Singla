int giveVal(char n)
{
	if (n >= 'A' && n <= 'Z')
		return n - 'A';

	if (n >= 'a' && n <= 'z')
		return n - 'a' + 26;

	if (n >= '0' && n <= '9')
		return n - '0' + 52;

	if (n == '+')
		return 62;

	return 63;
}

void decode(char in[], int n)
{
	if (n % 4 != 0)
	{
		printf("here\n");
		return;
	}

	int size = n / 4 * 3;

	if (in[n - 1] == '=') 
		n--;

	if (in[n-2] == '=')
		n--;

	char out[1000];

	int i = 0, j = 0;

	while (i < n)
	{
		int val = (giveVal(in[i++]) << 18);

		val |= (giveVal(in[i++]) << 12);

		val |= (giveVal(in[i++]) << 6);

		val |= (giveVal(in[i++]));

		if (j < size)
			out[j++] = (val >> 16) & 255;

		if (j < size)
			out[j++] = (val >> 8) & 255;

		if (j < size)
			out[j++] = val & 255;

	}

	out[j] = '\0';

	printf("%s\n", out);

}
