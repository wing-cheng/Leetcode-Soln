/*
    parameters:
        - l: the left number of the range
        - r: the right number of the range
        - res_count: the number of results
    You need to implement the function oddNumbers such that it returns an array storing the odd numbers in the range [l, r] (inclusive)
    and the number of elements in the array is returned in res_count.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *oddNumbers(int, int, int *);
void printArr(int *, int);

int main(void) {

    int count;
    int *a1 = oddNumbers(1, 6, &count);
    printArr(a1, count);

    return 0;
}

int *oddNumbers(int l, int r, int *res_count) {
    int *res = malloc(sizeof(int) * (r - l + 1));
    int i = 0;
    for (int j = l; j <= r; j++) {
        if (j % 2 != 0) {
            res[i] = j;
            i++;
        }
    }
    *res_count = i;
    return res;
}


void printArr(int *arr, int len) {
    for (int i = 0; i < len; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}