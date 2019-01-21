package main

/*
#include <stdlib.h>

typedef struct {
	const char* error;
	const int code;
} _GoError_;

typedef _GoError_ GoError;

*/
import "C"
import (
	"fmt"
	"sort"
	"unsafe"
)

//export Multiply
func Multiply(x int64, y int64) int64 {
	return x * y
}

//export Hello
func Hello(s string) *C.char {
	//ss := string(C.GoString(s))
	aaa := getString()
	ddd := "hello " + aaa + "!\x00"

	return C.CString(ddd)
}

//export FreeCs
func FreeCs(cs *C.char) {
	C.free(unsafe.Pointer(cs))
}

func getString() string {
	return "----"
}

//export PrintCs
func PrintCs(cs *C.char) {
	fmt.Println(C.GoString(cs))
}

//export Hello2
func Hello2(s string) *C.char {
	ddd := "Hello Jie, 杰"
	return C.CString(ddd)
	//if e != nil {
	//	panic(e)
	//}
	//return result
}

//export Sort
func Sort(vals []int) {
	sort.Ints(vals)
}

//export Error
func Error() C.GoError {
	return C.GoError{
		error: C.CString("error---------"),
		code:  234,
	}
}

//export Test
func Test() int64 {
	return 0
}

//export Bol
func Bol(i bool) {
	fmt.Println(i)
}

// main function is required, don't know why!
func main() {
} // a dummy function
