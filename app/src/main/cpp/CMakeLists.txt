# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

cmake_minimum_required(VERSION 3.10.2)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds it for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.

             # 设置so文件名称.
             native-lib1
             # 设置这个so文件为共享.
             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             #指定要编译文件路径
             native-lib.cpp
            native-lib.cpp ../jni/getNameJNI.c
        )
             # src/main/cpp/native-lib.cpp )
#        native-lib.cpp ../jni/getNameJNI.c)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because system libraries are included in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.


#  指定子编译文件的路径
# add_subdirectory


find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in the
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       # 指定目标库.
                       native-lib1

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
