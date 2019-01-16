import ctypes
import platform


if 'linux' in str(platform.system()).lower():
    lib = ctypes.CDLL("lib/libmath.so")
elif 'windows' in str(platform.system()).lower():
    lib = ctypes.WinDLL("lib/libmath.dll")
elif 'darwin' == str(platform.system()).lower():
    lib = ctypes.CDLL("lib/libmath.dylib")

lib.Hello.argtypes = [ctypes.c_char_p]
lib.Hello.restype = ctypes.c_char_p

print lib.Multiply(2, 4)
print(lib.Hello("viteshan"))
