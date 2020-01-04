package OOD.RelatedToMath;

/*
设计LINUX下的FIND函数
1.在系统中查找包含tomcat的文件或目录
find / -name '*tomcat*'


2.在某目录下查找名为“elm.cc”的文件
find /home/lijiajia/ -name elm.cc



3.查找文件名中包含某字符（如"elm"）的文件
find /home/lijiajia/ -name '*elm*'
find /home/lijiajia/ -name 'elm*'
find /home/lijiajia/ -name '*elm'
*/

/**
破题思路：
 和file system其实是一样的，可以先找到file有哪些类型的，然后设计一个abstract class来表示所有类型的文件的
 父类，其余所有的文件都由父类extends出来。

 find（）函数就是file system中的resolve()函数，根据路径找到对应的entry

* */


public class LinuxFind {

}
