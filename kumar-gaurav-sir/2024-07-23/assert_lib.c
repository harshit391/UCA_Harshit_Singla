#include <stdio.h>
#include <assert.h>

// Assert.h is used for unit testing the function that whether they are giving us the expected output
// assert ( condition for expected output )

// Normal Selection Sort
void selection_sort(int * arr, int n) {
	
	for (int i = 0; i < n; i++) {
		
		int min = i;

		for (int j = i+1; j < n; j++) {
			
			if (arr[j] < arr[min]) {
				min = j;
			}
		}

		int temp = arr[i];

		arr[i] = arr[min];
		arr[min] = temp;
	}
}

void test_simple_input() {
	int arr[] = {3, 1, 7, 9, 5};
	int expected_output[] = {1, 3, 5, 7, 9};

	selection_sort(arr, 5);

	// As I mentioned on top how assert take values
	for (int i = 0; i < 5; i++) {
		assert(arr[i] == expected_output[i]);
	}
}

int main() {

	// Running the Assert Function Created by us for Testing the selection sort function
	test_simple_input();
	return 0;
}
