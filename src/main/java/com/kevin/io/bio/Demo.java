package com.kevin.io.bio;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/24
 */
public class Demo {


    /**
     *
     * IO流基本原理：
     *      数据流（stream）是指数据通信的通道。
     *      java程序中对程序的输入、输出操作是以流的方式进行的。
     *
     * IO流中的三类数据源：
     *      基于磁盘文件：FileInputStream、FileOutputSteam、FileReader、FileWriter
     *      基于内存：ByteArrayInputStream ByteArrayOutputStream（ps:字节数组都是在内存中产生）
     *      基于网络：SocketInputStream、SocketOutputStream（ps:网络通信时传输数据）
     *
     * IO流的分类：
     *      按流向分：
     *          (1)输入流：程序从数据源读取数据的流
     *          (2)输出流：程序向数据原写入数据的流
     *      按数据传输单位分：
     *          (1)字节流：以字节为单位传输数据的流
     *          (2)字符流：以字符为单位传输数据的流
     *      按功能分：
     *          (1)节点流：用于直接操作目标设备的流
     *          (2)处理流：是对一个已存在的连接和封装，通过对数据的处理为程序提供更为强大，灵活的读写功能
     *
     * <1>InputStream:read(xx)读取字节系列方法
     * <2>OutputStream:writer(xx)写入字节系列方法
     * <3>Reader:read(xx)读取字符系列方法
     * <4>Writer:writer(xx)写入字符系列方法
     *
     * 节点流：程序直接与数据源连接，和实际的输入/输出节点连接；
     * 处理流：对节点流进行包装，扩展原来的功能，由处理流执行IO操作
     *
     *
     * 处理流可以隐藏底层设备上节点流的差异，无需关心数据源的来源，程序只需要通过处理流执行IO操作。处理流以节点流作为构造参数。
     * 通常情况下，推荐使用处理流来完成IO操作。
     *
     * 缓冲流：是处理流的一种，建立在相应的节点流之上，对读写的数据提供了缓冲的功能，
     * 提高了读写的效率，还增加了一些新的方法.
     * 缓冲流提供一个缓冲区，能够提高输入输出的执行效率，减少同节点的频繁操作，
     *
     * JDK提供了四种缓冲流：
     *  （1）BufferedInputStream可以对InputStream流进行包装
     *  （2）BufferedOutputStream可以对任何的OutputStream流进行包装
     *  （4）BufferedReader可以对任何的Reader流进行包装
     *      *还增加了readLine()方法用于一次读取一行字符串
     *  （5）BufferedWriter可以对任何的Writer流进行包装
     *      *新增了方法newLine()用与写出一个行分隔符
     * 对于缓冲输出流，写出的数据会缓存在内存缓存区中，关闭此流前要用flush()方法将缓存区中的数据立即写出，关闭缓存流会自动关闭缓存流所包装的所有底层流
     *
     *
     * 转换流：将字节转成字符流，字节流使用范围广，但字符流更方便。如果是处理文本，建议使用字符流。
     * 在IO包中，实际上只有字节流，字符流是在字节流的基础上转换出来的。
     * 转换流用于在字节流和字符流之间转换。
     *
     * JDK提供了两种转换流
     *      1.InputStreamReader:
     *          (1)是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流的输入对象。
     *          (2)InputStreamReader需要和InputStream“套接”，它可以将字节流中读入的字节解码成字符
     *      2.OutputStreamWriter：
     *          (1)是Writer的子类，将输出的字符流变为字节流，即：将一个字符流的输出对象变为字节流的输出对象。
     *          (2)OutputStreamWriter需要和OutputStream“套接”，它可以将要写入字节流的字符编码成字节
     *      3.转换步骤：
     *         （1）写出数据：程序—转换流—>OutputStreamWriter—字节流—>文件
     *         （2）读入数据：程序<—转换流—InputStreamWriter<—字节流—文件
     *
     */
}
