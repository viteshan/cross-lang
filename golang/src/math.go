// math.go
package main

import "C"

//export Multiply
func Multiply(x int64, y int64) int64 {
	return x * y
}

//export Hello
func Hello(s *C.char) *C.char {
	return C.CString("hello " + C.GoString(s) + "!")
}

// main function is required, don't know why!
func main() {} // a dummy function
