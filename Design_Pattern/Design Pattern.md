## UML
![UML Example](https://img-blog.csdnimg.cn/5f32b49660604378be7a7249a8991cbc.png#pic_center)

****
- ## Principles
  * **单一责任**: 一个方法只做一个功能，一件事
  * **开放-封闭**: 对软件实体类, 应该是可以扩展, 而不可修改
  * **依赖倒转**: 应该通过接口的方式去桥接高层和低层模块, 比如电脑的某零件出问题了导致电脑故障，那就只需要替换该零件就可以了
  * **迪米特法则**: 两个不比彼此通信的类应该用一个中介去转发, 就比如需要和同事合作，但不熟，就需要主管为中介去连接
****

# Patterns

## Simple Factory
 一个工厂的createObject()可以接收参数去识别生成不同的对象，这些对象要都实现某些共有的接口interface_opeartion()
![Simple Factory](https://img-blog.csdnimg.cn/cffb786993b5418c9ddbfda5ec20bdc9.jpeg#pic_center)

## Strategy
一个Context实体类用来控制对Strategy对象的引用，Strategy类是一个抽象类，用来提供抽象方法接口![Strategy](https://img-blog.csdnimg.cn/abe37c7b5c5e4e4d89d08d365ad7eaa1.png#pic_center)

## Decorator
对某些需要重叠(装饰)的类，可以对其使用对象流嵌套    
有点像对象链表
![Decorator](https://img-blog.csdnimg.cn/3d54925ac9ad4d1598735d063742c226.png#pic_center)
## Method Factory
对比简单工厂，工厂方法模式把部分简单工厂的内部逻辑搬到客户端进行操作，降低了封装性，但同时加强了灵活性。Client不是直接找统一Factory要实例，而是直接找对应的Factory要实例
![Factory_Method](https://img-blog.csdnimg.cn/ea289ff3b4d6464cb1f368f70e21d4c8.png#pic_center)
## Prototype
原型模式，就是提供一个Deep-Copy方法，如Clone()
![Prototype](https://img-blog.csdnimg.cn/12ed7d942fd14a0c9bd3d945484943b1.png#pic_center)
## Temaplate Method
模板方法模式，对于某些大体一致但是有细微差别的操作，可以通过将共有操作提取成一个类，然后提供对细微差别的抽象函数，由不同的派生类去定制那些细微的差别
![Template Method](https://img-blog.csdnimg.cn/80a8f988b67c46ee9a8c30515af749a6.png#pic_center)
## Facade
外观模式，就是对一堆子系统提供一个高层的抽象接口，方便对子系统的控制
![Facade](https://img-blog.csdnimg.cn/956193d6f3024795992546900e8d6ac9.png#pic_center)
## Builder
建造者模式，将对象的构造部分和具体类对象分离，抽象出独立的构造部分
![Builder](https://img-blog.csdnimg.cn/c26a904e60334e51a7073cd1119959ae.png#pic_center)
## Observer
观察者模式，感觉比较像订阅模式，就是某个类A对类B发起订阅，将类A加入到类B的容器中，那么类B在需要时就可以对订阅者(类A)发起送一个boardcast。观察者模式的升级版就是事件委托，用回调函数或信号/槽或者别的语言特性可以实现
![Observer](https://img-blog.csdnimg.cn/8288da160ada4161bd1258f1950e8a90.png#pic_center)
## Abstract Factory
抽象工厂方法，就是工厂方法模式的升级版，在提供具体工厂的同时，这些工厂能提供各式各样的“产品族”。通过反射机制还能大大提高在增加“产品族”的开发效率
![Abstract Factory](https://img-blog.csdnimg.cn/5a41efb62e16402ab4e109d7fb89678b.png#pic_center)
使用简单工厂/反射优化
![Abstract Factory plus](https://img-blog.csdnimg.cn/54c40234379c400c898464d4f660eaf6.png#pic_center)

## State
状态模式，解耦复杂的条件判断，把一堆判断变为Object链表(每个State Object记录下一个状态)
![State](https://img-blog.csdnimg.cn/5081361192874c4bb75b5ff60e8857a0.png#pic_center)

## Adapter
适配器模式，用一个中间体适配器将不相关的接口连起来
![Adapter](https://img-blog.csdnimg.cn/d416e9b08b0a42a98e680b3e46d78c12.png#pic_center)

## Memento
备忘录模式，简单来说就是用一个结构体/对象去存某个对象的状态信息
![Memento](https://img-blog.csdnimg.cn/2b0aeddad7e14fb8a9e766d0e8b1e9d7.png#pic_center)

## Composite
组合模式，将对象组合成树形结构，使得这个组合体具有一致性。主要是区分添加的是叶子结点还是分支节点
![Composite](https://img-blog.csdnimg.cn/12fd72c148a94229a0df39c3728a3740.png#pic_center)

## Iterator
迭代器模式，为遍历某容器提供统一的接口。有点像C++容器的iterator和基于范围的for的组合
![Iterator](https://img-blog.csdnimg.cn/1f9ab739c0214b4fadbc5ce5e32f52f5.png#pic_center)

## Singleton
单例模式
- 懒汉式: 在第一次被调用时初始化，可以用std::call_once去实现 (双重锁定因为CPU的乱序执行而无法保证线程安全)
- 饿汉式: 用静态的手法实现，在静态初始化时分配好空间

## Bridge
桥接模式，如果实现系统可以从多个角度分类，每一个分类都有多种变化，那么可以使用桥接模式通过聚合的手段，将不同的分类、实现系统不同的面进行解耦
![Bridge](https://img-blog.csdnimg.cn/3b9c6c8decd445d8b69b37b4a8260c8c.png#pic_center)

## Command
命令模式， 将请求封装为对象，再抽象一个类用来存这些请求，已达到日志的效果
![Command](https://img-blog.csdnimg.cn/d02c5b87d08c4698991956ce7f658bbf.png#pic_center)

## Chain of Responsibility
职责链模式，有点类似状态模式，就是一个对象中有一个对上级对象的引用，该对象所发出的请求传递给上级对象去判断是继续往上层传还是能自己解决
![Chain of Responsibility](https://img-blog.csdnimg.cn/3eadd7479d4f4a52b5cbba4fb9951dc1.png#pic_center)

 ## Mediator
 中介者模式，其实就是拿一个类把两个类连接起来，但是个人感觉耦合度有点高，写起来太麻烦了，不如用适配器模式
 ![Mediator](https://img-blog.csdnimg.cn/cfe6c685329142e492f772cf329fd381.png#pic_center)
## Flyweight
享元模式，感觉上像是对象池，复用某个对象。但享元模式可以分为内部状态和外部状态，把一下对象放在内部状态去复用，而外部状态用来控制这些对象所表现出来的细微的变化、差别
![Flyweight](https://img-blog.csdnimg.cn/73ce0ae015a542fd82e3ec0635aea520.png#pic_center)

## Interpreter
解释器模式，用来解释你自己定义的语法的字符串/句子
![Interpreter](https://img-blog.csdnimg.cn/208ce3d0371e40fa8e8cc8f7bb84db56.png#pic_center)

## Visitor
访问者模式，将对象的数据结构和相关操作分离，可以在类数据结构不变的情况下提高灵活性？？没太看懂这个模式
![Visitor](https://img-blog.csdnimg.cn/ec1f4ed91b6647289a9a177cd525aaaf.png#pic_center)