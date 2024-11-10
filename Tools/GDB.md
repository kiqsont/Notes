## GDB启动方法

- **gdb filename**
- **gdb attach pid**，可以先使用 *ps -ef | grep program_name*找出pid，调试完后使用detach让程序继续跑
- **gdb filename core_filename**

---

# GDB常用调试命令

## run

用于启动程序，再次输入r可重新启动程序，缩写是r



## continue

让程序继续运行，有点像VS的F5，缩写c



## break

设置断点，缩写b

```bash
break function_name
break filename:lineNo
```



## tbreak

设置临时断点，只触发一次



## backtrace

查看当前的调用堆栈，缩写bt



## frame

查看调用堆栈更具体一点的信息，缩写f



## info / display

info 查看信息，比如 info breakpoints 查看所有的断点信息

display会在每次中断时自动输出

```bash
display $ebx
display /x $ebx
info display
delete display 
```





## enable/disable/delete

使用/禁用/删除 断点



## list

查看当前位置前后10行代码，再 l 就是后面10行

list+、list- 前后控制



## print / ptype

输出值，缩写是p

输出值类型

p func()可以直接输出执行结果

p strerror(errno)就不用查手册了

有一堆的format，比如 p /x val输出16进制



## thread

```bash
info threads 查看当前进程所有的thread信息及它们中断的位置

thread 2 将当前线程切换到thread2，就能查看对应的堆栈了
```



## next/step

next是执行下一行，相当与VS的F10，缩写是n

step是进入函数，相当于VS的F11，缩写是s



## return / finish / until / jump

return是直接返回，不执行当前函数之后的代码，可以选择直接return一个值，不然的话return返回的东西是未定义的

finish是完成当前函数

until是直到运行到xx行才停下来，相当于打一个断点然后continue

jump是不执行下面的代码，直接跳过到某个位置



## disassemble

显示汇编代码

可以通过设置set disassembly-flavor intel将默认的AT&T改成intel汇编



## set args / show args

```bash
set args ../xxx.conf
set args "arg 1" "arg 2"
show args
```



## watch

监控一个变量、一段内存

注意监控指针时，要检测的不是变量存的地址，而是地址对应的值 watch *ptr



## dir

添加路径，如果源文件移动，符号表所保存的索引就对不上位置，可以通过dir命令去添加路径

```bash
dir path1:path2	# :可以拼接多个路径
```

---

# 多线程调试

调试多线程时，通过 *info threads* 先查看所有的线程信息，再跟进具体线程进行调试



## 控制线程切换

**set scheduler-locking on/step/off**



### off

默认行为



### on

锁定当前线程，其他线程全部暂停



### setp

锁定线程，当 *next / step* 时其它线程暂停，而 *until / finish / return* 时其它线程可以运行

---

# 调试多进程

## 方法1：开多个Shell然后attach

先用gdb run程序，然后**lsof -i -Pn | grep program_name**找出子进程的pid，再开个Shell去attach

这个方法有个缺点，就是attach前的内容不能进行跟踪，如果attach后再run让它重新运行，又会破坏父子进程之间的联系



## 方法2：follow-fork

```bash
# set follow-fork parent
set follow-fork child
show foolow-fork mode
run
```

---

# 调试信息小知识



## 编译与符号表 

调试前提：使用 **-g** 去编译，最好是 O0未优化的

有-g编译的就是有符号表(symbols)，可以被gdb识别

可以使用 *strip program_name* 去除可执行文件的符号表



## 条件断点

```bash
# 给11行 打上 条件断点 (my_val == 9)
break 11 if my_val == 9

# 给已存在的1号断点加上触发条件
condition 1 my_val == 19
```



## 函数存在但无法加断点

```bash
遇到Make breakpoint pending on future shared library load?y/n时说明给xxx函数添加的断点失败
```

可以改成给xx文件的xx行添加断点



## pirnt输出完整字符串

当字符串太长时，gdb会进行截取然后加...，可以通过

```bash
set print element 0
```

让gdb输出完整的字符串



## 让调试程序接受信号

gdb会截断一些信号比如C^

```bash
handle SIGINT nostop print
```

让gdb把信号传递给程序

---

# 图形界面



## gdbtui

gdb自带的小的图形界面，缺点是经常花屏，调整大小时要space强行让窗口刷新

在gdb中使用Ctrl + X + A打开gdbtui

可以layout mode切换模式

- src 展示源代码和command窗口
- asm 展示汇编和command窗口
- split 展示源代码、汇编、command窗口
- regs 展示寄存器窗口

使用 winheight src + 5 调整窗口大小的代码行



## cgdb

一个对gdb的gui封装，比gdbtui好用

但是输出中文好像会乱码