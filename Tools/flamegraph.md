# 火焰图的简单使用

- git clone https://github.com/brendangregg/FlameGraph.git 下载对应的Flamegraph工具，开箱即用

- 配置好perf环境

- 启动需要被测的程序

- netstat -anp | grep xxxx(xxxx为对应的端口)，找出程序的进程号

- ```bash
  sudo perf record -F 99 -p 123432 -g -- sleep 30
  -F : 记录的频率
  -p : 进程号
  sleep 30 : 持续30s
  -g : 记录调用栈，但是在GCC环境下，很多地址是未知的，会造成火焰图很多unknown函数，可以通过将 -g 改成 --call-graph dwarf 来生成一个更大更详细的火焰图
  ```

- ```bash
  sudo perf script | FlameGraph/stackcollapse-perf.pl | FlameGraph/flamegraph.pl > perf.svg
  通过 perf.data 生成 浏览器打开的火焰图
  ```

- Y轴代表调用栈，X轴的宽度越大，表示所占用的越多，优化空间越大

