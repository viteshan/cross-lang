.PHONY: all clean


GO ?= latest

SERVERMAIN = $(shell pwd)/src/math.go
BUILDDIR = $(shell pwd)/build
LIB_LINUX = $(BUILDDIR)/linux/libmath.so
LIB_WINDOWS = $(BUILDDIR)/windows/libmath.dll
LIB_DARWIN = $(BUILDDIR)/darwin/libmath.dylib



all: windows darwin linux


clean:
	rm -r $(BUILDDIR)/

linux:
	env GOOS=linux GOARCH=amd64 go build -buildmode=c-shared -i -o $(LIB_LINUX) $(SERVERMAIN)
	@ls -ld $(LIB_LINUX)
	@echo "Linux cross compilation done."


darwin:
	env GOOS=darwin GOARCH=amd64 go build -buildmode=c-shared -i -o $(LIB_DARWIN) $(SERVERMAIN)
	@ls -ld $(LIB_DARWIN)
	@echo "Darwin cross compilation done."

windows:
	env GOOS=windows GOARCH=amd64 go build -buildmode=c-shared -i -o $(LIB_WINDOWS) $(SERVERMAIN)
	@ls -ld $(LIB_WINDOWS)
	@echo "Windows cross compilation done."
