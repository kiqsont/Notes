# AVL树

平衡树的旋转分为 LL,LR,RL,RR，主要是将平衡点数绝对值大于1的最小子树（层数最高的第一个大于1的，连带接下来两个节点）进行中序排序，如

![](.\images\nodes_avl_tree.png)



---

---

# B树

## B-tree与B+ tree

B+树比B-tree多了个限制，数据只存在叶子结点，非叶子结点只存索引/孩子指针

B+ tree比B-tree更适合存储IO相关的数据

---

## B-tree与查找

B-tree主要用在IO相关的地方，而影响IO效率的因素有：1、数据大小；2、读写次数。用B-tree作为索引可以有效降低IO的次数

hash表：等值查询速度快，但是数据散列不均匀，不能范围查询

AVL/红黑树：层数太高，IO次数太多

---

## MySQL中的B+树索引

在mysql中，B+树一般由多个页组成，每个页16k

---

## 为什么MySQL使用B+树当索引而不是跳表，为什么redis使用跳表而不是B+树

**总结**：B+树层数小，跳表写入性能好

> **简答**：B+树高度比跳表小，磁盘IO次数更少，所对应的查询速度就更快
>
> **详细**：对于三层的B+树，能存放2kw数据，而同样数据的跳表，需要24层

> **简答**：redis是内存数据库，跟磁盘没关系，插入数据更快
>
> **详细**：跳表插入数据是根据随机函数确定层数，而B+树要旋转至平衡，有不小的开销

详细文章：[MySQL的索引为什么使用B+树而不使用跳表？-51CTO.COM](https://www.51cto.com/article/706701.html)



---

---



# 内存池

## 介绍

- heap的管理
- 减少频繁的内存申请/销毁
- 内存池可以帮助程序员更有效地管理内存，减少内存碎片，提高内存利用率，提高程序的性能

---

## 常见方案

- 向上取整，只分配2^n大小的内存块，方便回收而且内存对齐
- nginx的方案，将大块/小块内存分开处理，小块内存集中管理且不回收
- 给一个hashlist，key为内存块的大小，value是两个链表，已使用/已回收的内存块链表![](.\images\nodes_mempool_hashlist.png)

---

## nginx内存池

- 每个连接对应一个内存池
- 不回收小内存buffer，只回收大内存

底层实现：两个链表，分别对应 small block / big block![](.\images\nodes_mempool_nginx.png)

---

---



# heap内存管理

## new / delete

new会调用构造函数来初始化，而delete同样会调用析构函数

new的底层是malloc去操作，可以通过operator new去改变new的行为，但是不建议这样做

---

## malloc/free

malloc会先去freelist找合适的内存块，如果找不到，则通过sbrk去扩展heap区得到更大的heap空间，然后返回需要的内存块，但是是void*

一般来说，malloc出来的内存块有meta-data头，用来记录malloc出来的内存大小，以便free时使用

---

## 内存泄漏

- sanitizer:leak、address...
- Valgrind
- 通过重载operator new/delete去实现log记录申请/释放内存的地址或代码行

