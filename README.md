# Java-Thread
## 单一消费者 和 单一生产者（操作值方式）<br />
	com.simple.one.value
## 多消费者 和 多生产者（操作值方式）<br />	
	com.simple.many.value
## 单一消费者 和 单一生产者（操作栈方式）<br />
	com.simple.one.stack
## 多消费者 和 多生产者（操作栈方式）<br />
	com.simple.many.stack
## 通过管道进行线程通信 字节<br />
	com.piped.byteT
## 通过管道进行线程通信 字符<br />
	com.piped.charT
## 单一消费者 和 单一生产者（使用ReentrantLock）<br />
	com.lock.simple.one
## 多消费者 和 多生产者（使用ReentrantLock）<br />	
	com.lock.simple.many
## 读读共享（使用 ReentrantReadWriteLock）<br />		
	com.lock.readAndWrite.readAndread
## 读写互斥（使用 ReentrantReadWriteLock）（只要包含写操作 都是互斥 读写互斥／写读互斥／写写互斥）<br />		
	com.lock.readAndWrite.readAndwrite
## 使用DCl双检查锁来实现多线程环境中的延迟加载单例设计模式
	com.single.dcl
## 使用静态内部类来实现多线程环境中的延迟加载单例设计模式
	com.single.handler
## 使用序列化和反序列化来实现多线程环境中的延迟加载单例设计模式
	com.single.serialize
## 使用static代码块来实现多线程环境中的延迟加载单例设计模式
	com.single.staticDemo
## 使用枚举来实现多线程环境中的延迟加载单例设计模式
	com.single.enumDemo

