package com.kevin.io.bio;

/**
 * @author caonanqing
 * @version 1.0
 * @description     随机访问文件类
 *
 *   优点：1.既可以读也可以写，2.可以指定位置读写。
 *   RandomAccessFile是Java输入/输出流体系中功能最丰富的文件内容访问类，
 *      既可以读取文件内容，也可以向文件输出数据。
 *
 *   与普通的输入/输出流不同的是，RandomAccessFile支持跳到文件任意位置读写数据，
 *      RandomAccessFile对象包含一个记录指针，用以标识当前读写处的位置，
 *      当程序创建一个新的RandomAccessFile对象时，该对象的文件记录指针对于文件头（也就是0处），
 *      当读写n个字节后，文件记录指针将会向后移动n个字节。
 *      除此之外，RandomAccessFile可以自由移动该记录指针
 *
 *   RandomAccessFile包含两个方法来操作文件记录指针：
 *      long getFilePointer()：返回文件记录指针的当前位置
 *      void seek(long pos)：将文件记录指针定位到pos位置
 *      RandomAccessFile类在创建对象时，除了指定文件本身，还需要指定一个mode参数，该参数指定RandomAccessFile的访问模式，该参数有如下四个值：
 *
 *      r：以只读方式打开指定文件。如果试图对该RandomAccessFile指定的文件执行写入方法则会抛出IOException
 *      rw：以读取、写入方式打开指定文件。如果该文件不存在，则尝试创建文件
 *      rws：以读取、写入方式打开指定文件。相对于rw模式，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备，默认情形下(rw模式下),是使用buffer的,只有cache满的或者使用RandomAccessFile.close()关闭流的时候儿才真正的写到文件
 *      rwd：与rws类似，只是仅对文件的内容同步更新到磁盘，而不修改文件的元数据
 *
 * @createDate 2019/5/27
 */
public class RandomAccessFileDemo {
}
