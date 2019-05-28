package com.kevin.io;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/27
 */
public class Demo {

    /**
     *
     * IO流又叫BIO（同步、阻塞）
     *      IO流简单来说就是input和output流，IO流主要是用来处理设备之间的数据传输，
     *      Java IO对于数据的操作都是通过流实现的，而java用于操作流的对象都在IO包中。
     *
     *      IO流中的三类数据源：
     *          基于磁盘文件：FileInputStream、FileOutputSteam、FileReader、FileWriter
     *          基于内存：ByteArrayInputStream ByteArrayOutputStream（ps:字节数组都是在内存中产生）
     *          基于网络：SocketInputStream、SocketOutputStream（ps:网络通信时传输数据）
     *      1.InputStream:read(xx)读取字节系列方法
     *      2.OutputStream:writer(xx)写入字节系列方法
     *      3.Reader:read(xx)读取字符系列方法
     *      4.Writer:writer(xx)写入字符系列方法
     *
     * NIO（同步、非阻塞）
     *      NIO之所以是同步，是因为它的accept/read/write方法的内核I/O操作都会阻塞当前线程
     *      三个主要组成部分：Channel（通道）、Buffer（缓冲区）、Selector（选择器）
     *      Channel的话分为四种：
     *          1.FileChannel从文件中读写数据。
     *          2.DatagramChannel以UDP的形式从网络中读写数据。
     *          3.SocketChannel以TCP的形式从网络中读写数据。
     *          4.ServerSocketChannel允许你监听TCP连接。
     *
     *      Buffer：
     *          Buffer实现有：ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, ShortBuffer，
     *          分别对应基本数据类型: byte, char, double, float, int, long, short。
     *          当然NIO中还有MappedByteBuffer,HeapByteBuffer, DirectByteBuffer。
     *
     *      Buffer参数：
     *          capacity：缓冲区数组的总长度
     *          position：下一个要操作的数据元素的位置
     *          limit：缓冲区数组中不可操作的下一个元素的位置：limit<=capacity
     *          mark：用于记录当前position的前一个位置或者默认是-1
     *
     *      Selector：
     *          Selector运行单线程处理多个Channel，如果你的应用打开了多个通道，但每个连接的流量都很低，
     *          使用Selector就会很方便。例如在一个聊天服务器中。要使用Selector, 得向Selector注册Channel，
     *          然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。一旦这个方法返回，
     *          线程就可以处理这些事件，事件的例子有如新的连接进来、数据接收等。
     *
     * AIO又叫NIO2(异步、非阻塞)
     *      AIO是异步IO的缩写，虽然NIO在网络操作中，提供了非阻塞的方法，但是NIO的IO行为还是同步的。对于NIO来说，
     *          我们的业务线程是在IO操作准备好时，得到通知，接着就由这个线程自行进行IO操作，IO操作本身是同步的。
     *
     *      但是对AIO来说，则更加进了一步，它不是在IO准备好时再通知线程，而是在IO操作已经完成后，再给线程发出通知。
     *          因此AIO是不会阻塞的，此时我们的业务逻辑将变成一个回调函数，等待IO操作完成后，由系统自动触发。
     *
     *      与NIO不同，当进行读写操作时，只须直接调用API的read或write方法即可。这两种方法均为异步的，对于读操作而言，
     *          当有流可读取时，操作系统会将可读的流传入read方法的缓冲区，并通知应用程序；对于写操作而言，
     *          当操作系统将write方法传递的流写入完毕时，操作系统主动通知应用程序。 即可以理解为，read/write方法都是异步的，
     *          完成后会主动调用回调函数。
     *          在JDK1.7中，这部分内容被称作NIO.2，主要在Java.nio.channels包下增加了下面四个异步通道：
     *              AsynchronousSocketChannel
     *              AsynchronousServerSocketChannel
     *              AsynchronousFileChannel
     *              AsynchronousDatagramChannel
     *      在AIO socket编程中，服务端通道是AsynchronousServerSocketChannel，这个类提供了一个open()静态工厂，
     *      一个bind()方法用于绑定服务端IP地址（还有端口号），另外还提供了accept()用于接收用户连接请求。
     *      在客户端使用的通道是AsynchronousSocketChannel,这个通道处理提供open静态工厂方法外，还提供了read和write方法。
     *
     *      在AIO编程中，发出一个事件（accept read write等）之后要指定事件处理类（回调函数），
     *      AIO中的事件处理类是CompletionHandler<V,A>，这个接口定义了如下两个方法，分别在异步操作成功和失败时被回调。
     *      void completed(V result, A attachment);
     *      void failed(Throwable exc, A attachment);
     *
     */
}
