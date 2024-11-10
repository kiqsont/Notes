## 基本介绍

docker用来提程序需要的运行环境，可以看成进程级别的虚拟机

> **镜像 Image**
>
> 可以看做Elf文件，表明一个程序的一些运行信息
>
> ```bash
> A running container uses an isolated filesystem. This isolated filesystem is provided by an image, and the image must contain everything needed to run an application - all dependencies, configurations, scripts, binaries, etc. The image also contains other configurations for the container, such as environment variables, a default command to run, and other metadata.
> ```

>  **容器 Container**
>
> 跑起来的程序，可以看做一个进程
>
> ```bash
> A container is a sandboxed process running on a host machine that is isolated from all other processes running on that host machine. 
> 
> - Is a runnable instance of an image. You can create, start, stop, move, or delete a container using the Docker API or CLI.
> - Can be run on local machines, virtual machines, or deployed to the cloud.
> - Is portable (and can be run on any OS).
> - Is isolated from other containers and runs its own software, binaries, configurations, etc.
> ```



## 使用Docker运行一个例子

- *编写Dockerfile*

``` bash
# syntax=docker/dockerfile:1

FROM node:18-alpine
WORKDIR /app
COPY . .
RUN yarn install --production --ignore-engine
CMD ["node", "src/index.js"]
EXPOSE 3000	                 # 表示运行的程序会内部绑定的端口
```



- *Build Image*

```bash
docker build -t getting-started .
```

**-t** 跟image的名字

**.** 表示Dockerfile的位置



- *使用 Docker 运行*

```bash
docker run -dp 8888:3000 getting-started
```

**-d** --detach的缩写，运行在后台

**-p** --publish的缩写，表示地址的映射，[映射地址:实际运行地址]，这样访问8888端口时就会映射到内部运行在3000端口的程序



- *查看和关闭*

```bash
docker ps
docker stop container_id
```



## Docker Hub

可以给 *image* 打上 *tag* 然后 *push* 到 *repository* 上

```bash
docker tag getting-started kiqsont/getting-started
docker push kiqsont/getting-started
```



## Docker的数据持久化

因为跑在docker的程序是运行在一个虚拟的文件系统，所以持久化需要做特殊处理

第一种方式是：**Named volumes**

```bash
docker volume create volume_for_persist   # create
docker volume inspect volume_for_persist  # inspect
```

开辟一段空间，具体的文件空间是*inspect*出来的信息的 "*Mountpoint(/var/lib/docker/volumes/volume_for_persist/_data)*"

```bash
docker run -dp 8888:3000 --mount type=volume,src=volume_for_persist,target=/etc/persist_db getting-started
```



还有一种方式是：**Bind mounts**

```bash
... --mount type=bind,src="$(pwd)",target=/app ...
```

这样的方式是将本地文件系统映射到docker运行环境中，*docker*里面的*target*对应到*src*文件系统



## Container间的通信

因为docker的运行环境的隔离的，所以容器间的交互需要额外处理，比如说某个程序要访问运行在docker里面的MySQL，可以通过docker的network

```bash
docker network create my-network

docker run -d --network my-network --network-alias mysql \
-v test-mysql-data:/var/lib/mysql \
-e MYSQL_ROOT_PASSOWRD=password \
-e MY_SQL_DATABASE=dockerdb mysql:8.0

docker run -dp 127.0.0.1:8888:3000 -w /app -v "$(pwd):/app" \
--network my-network \
-e MYSQL_HOST=mysql -e MYSQL_USER=root -e MYSQL_PASSWORD=password \
-e MYSQL_DB=dockerdb node:18-alpine \
sh -c "yarn install && yarn run dev"
```



## Docker Compose

*compose* 是用来同时跑一组 *Container*的工具，通过编写一个 *compose.yaml* 来运行

```bash
docker compose up -d
docker compose down # --volumes remove the named volumes in compose
docker compose logs -f app
```

```yaml
# compose.yaml
services:
  app:
    image: node:18-alpine
    command: sh -c "yarn install && yarn run dev"
    ports:
      - 127.0.0.1:3000:3000
    working_dir: /app
    volumes:
      - ./:/app
    environment:
      MYSQL_HOST: mysql
      MYSQL_USER: root
      MYSQL_PASSWORD: secret
      MYSQL_DB: todos

  mysql:
    image: mysql:8.0
    volumes:
      - todo-mysql-data:/var/lib/mysql
    environment:
      MYSQL_ROOT_PASSWORD: secret
      MYSQL_DATABASE: todos

volumes:
  todo-mysql-data:
```

